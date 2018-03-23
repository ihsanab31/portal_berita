package com.sundevs.ihsan.newsapps.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.sundevs.ihsan.newsapps.R;
import com.sundevs.ihsan.newsapps.adapter.ViewPagerAdapter;
import com.sundevs.ihsan.newsapps.view.base.NormalActivity;
import com.sundevs.ihsan.newsapps.view.fragement.BusinessFragment;
import com.sundevs.ihsan.newsapps.view.fragement.EntertainmentFragment;
import com.sundevs.ihsan.newsapps.view.fragement.HealthFragment;
import com.sundevs.ihsan.newsapps.view.fragement.ScienceFragment;
import com.sundevs.ihsan.newsapps.view.fragement.SportFragment;
import com.sundevs.ihsan.newsapps.view.fragement.TechnologyFragment;

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
public class MainActivity extends NormalActivity {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.ic_picture,
            R.drawable.ic_monitor,
            R.drawable.ic_money,
            R.drawable.ic_tv,
            R.drawable.ic_trophy,
            R.drawable.ic_doctor
    };

    @Override
    protected int getActivityView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ScienceFragment(), null);
        adapter.addFragment(new TechnologyFragment(), null);
        adapter.addFragment(new BusinessFragment(), null);
        adapter.addFragment(new EntertainmentFragment(), null);
        adapter.addFragment(new SportFragment(), null);
        adapter.addFragment(new HealthFragment(), null);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }
}
