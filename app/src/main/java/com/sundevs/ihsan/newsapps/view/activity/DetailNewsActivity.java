package com.sundevs.ihsan.newsapps.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sundevs.ihsan.newsapps.R;
import com.sundevs.ihsan.newsapps.view.base.NormalActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class DetailNewsActivity extends NormalActivity {

    String imgNews, titleNews, contentNews, dateNews, authorNews, sourceNews;
    @BindView(R.id.img_news)
    ImageView ivImgNews;
    @BindView(R.id.title_news)
    TextView tvTitleNews;
    @BindView(R.id.content_news)
    TextView tvContentNews;
    @BindView(R.id.author_news)
    TextView tvAuthorNews;
    @BindView(R.id.date_news)
    TextView tvDateNews;
    @BindView(R.id.source_news)
    TextView tvSourceNews;

    @Override
    protected int getActivityView() {
        return R.layout.activity_detail_news;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
            case R.id.share: {
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_TEXT, titleNews + "\n\n" + contentNews + "\n\n" + sourceNews);
                startActivity(Intent.createChooser(i, "Share this Article ?"));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    private void initData(){
        imgNews = getIntent().getStringExtra("imgNews");
        titleNews = getIntent().getStringExtra("titleNews");
        contentNews = getIntent().getStringExtra("contentNews");
        dateNews = getIntent().getStringExtra("dateNews");
        authorNews = getIntent().getStringExtra("authorNews");
        sourceNews = getIntent().getStringExtra("sourceNews");
        Glide.with(getApplicationContext())
                .load(imgNews)
                .placeholder(R.drawable.ic_null)
                .into(ivImgNews);
        tvTitleNews.setText(titleNews);
        tvContentNews.setText(contentNews);
        tvDateNews.setText(dateNews);
        tvSourceNews.setText(getResources().getString(R.string.view_more));
        tvAuthorNews.setText(authorNews);


    }

    @OnClick({R.id.ic_menu, R.id.source_news})
    void back( View view){
        switch (view.getId()){
            case R.id.ic_menu:
                finish();
                break;
            case R.id.source_news:
                Intent i = new Intent(getApplicationContext(), DetailFullActivity.class);
                i.putExtra("url", sourceNews);
                startActivity(i);
               overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
