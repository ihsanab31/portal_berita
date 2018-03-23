package com.sundevs.ihsan.newsapps.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.sundevs.ihsan.newsapps.R;
import com.sundevs.ihsan.newsapps.view.base.NoActionBarConfig;
import com.sundevs.ihsan.newsapps.view.base.NormalActivity;

import butterknife.BindView;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class SplashScreenActivity extends NormalActivity implements Animation.AnimationListener  {
    Animation animBlink;
    final int SPLASH_TIME_OUT = 2000;
    @BindView(R.id.img_splash)
    ImageView imageView;
    @Override
    protected int getActivityView() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NoActionBarConfig noActionBarConfig = new NoActionBarConfig();
        noActionBarConfig.fullScreen(this);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        imageView.startAnimation(animBlink);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation == animBlink) {

        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
