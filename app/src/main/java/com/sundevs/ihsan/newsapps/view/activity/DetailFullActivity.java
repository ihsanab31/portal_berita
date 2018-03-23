package com.sundevs.ihsan.newsapps.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
public class DetailFullActivity extends NormalActivity {
    @BindView(R.id.webview)
    WebView webView;
    @Override
    protected int getActivityView() {
        return R.layout.activity_detail_full;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initData(){
        String url = getBundle().getString("url", null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    @OnClick(R.id.ic_menu)
    void back(){
        finish();
    }
}
