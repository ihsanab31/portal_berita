package com.sundevs.ihsan.newsapps.view.fragement;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sundevs.ihsan.newsapps.BuildConfig;
import com.sundevs.ihsan.newsapps.R;
import com.sundevs.ihsan.newsapps.adapter.NewsAdapter;
import com.sundevs.ihsan.newsapps.api.EndPoint;
import com.sundevs.ihsan.newsapps.api.BaseURL;
import com.sundevs.ihsan.newsapps.model.News;
import com.sundevs.ihsan.newsapps.model.NewsResponse;
import com.sundevs.ihsan.newsapps.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class HealthFragment extends BaseFragment {
    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    private NewsAdapter adapter;
    List<News> listNews = new ArrayList<>();
    final String category = "health";
    ProgressDialog loading;
    EndPoint apiService;

    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_health;
    }

    @Override
    protected void onBindView() {
        apiService = BaseURL.getAPIService();
        adapter = new NewsAdapter(getContext(), listNews);
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.setAdapter(adapter);
        refresh();
    }


    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        apiService.getListNews("id", category, BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listNews = response.body().getNewsList();

                    rvNews.setAdapter(new NewsAdapter(getContext(), listNews));
                    adapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(getContext(), "Failed to Fetch Data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getContext(), "Failed to Connect Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
