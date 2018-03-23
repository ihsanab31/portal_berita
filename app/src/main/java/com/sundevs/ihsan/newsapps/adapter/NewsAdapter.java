package com.sundevs.ihsan.newsapps.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sundevs.ihsan.newsapps.R;
import com.sundevs.ihsan.newsapps.view.activity.DetailNewsActivity;
import com.sundevs.ihsan.newsapps.model.News;

import java.util.List;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> listNews;

    public NewsAdapter(Context context, List<News> listNews){
        this.context = context;
        this.listNews = listNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News news = listNews.get(position);
        Glide.with(context)
                .load(news.getImgNews())
                .placeholder(R.drawable.ic_null)
                .into(holder.imgNews);
        holder.lblTitleNews.setText(news.getTitleNews());
        holder.lblDateNews.setText(news.getDateNews().substring(0,10)+" "+news.getDateNews().substring(11,16));
        if(news.getAuthorNews() == null){
            holder.lblAuthorNews.setText("Unknown Author");
        }
        else{
            holder.lblAuthorNews.setText(news.getAuthorNews());
        }

        holder.cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailNewsActivity.class);
                i.putExtra("imgNews", news.getImgNews());
                i.putExtra("titleNews", news.getTitleNews());
                if(news.getContentNews() == null){
                    i.putExtra("contentNews", "No Description");
                }
                else{
                    i.putExtra("contentNews", news.getContentNews());
                }
                i.putExtra("dateNews", news.getDateNews().substring(0,10)+" "+news.getDateNews().substring(11,16));
                if(news.getAuthorNews() == null){
                    i.putExtra("authorNews", "Unknown Author");
                }
                else{
                    i.putExtra("authorNews", news.getAuthorNews());
                }
                i.putExtra("sourceNews", news.getSourceNews());
                context.startActivity(i);
                ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvNews;
        private ImageView imgNews;
        private TextView lblTitleNews, lblDateNews, lblAuthorNews;

        public ViewHolder(View itemView) {
            super(itemView);

            cvNews = (CardView) itemView.findViewById(R.id.cv_news);
            imgNews = (ImageView) itemView.findViewById(R.id.img_news);
            lblTitleNews = (TextView) itemView.findViewById(R.id.title_news);
            lblDateNews = (TextView) itemView.findViewById(R.id.date_news);
            lblAuthorNews = (TextView) itemView.findViewById(R.id.author_news);
        }
    }
}
