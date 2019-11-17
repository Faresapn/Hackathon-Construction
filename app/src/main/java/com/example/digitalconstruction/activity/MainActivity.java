package com.example.digitalconstruction.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.digitalconstruction.Adapter.PageAdapter;
import com.example.digitalconstruction.R;
import com.example.digitalconstruction.fragment.AktivitasFragment;
import com.example.digitalconstruction.fragment.BerandaFragment;
import com.example.digitalconstruction.fragment.LaporanFragment;
import com.example.digitalconstruction.fragment.ProfilFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    BottomNavigationBar bottomNavigationBar;
    private List<Fragment> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNav();
        initViewPager();

    }

    private void initViewPager() {
        mList = new ArrayList<>();
        mList.add(new BerandaFragment());
        mList.add(new AktivitasFragment());
        mList.add(new LaporanFragment());
        mList.add(new ProfilFragment());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOnPageChangeListener(this);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(pageAdapter);
    }

    private void initBottomNav(){
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar
                .setActiveColor(R.color.white)
                .setInActiveColor(R.color.textHeading)
                .setBarBackgroundColor(R.color.colorActive)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "Beranda"))
                .addItem(new BottomNavigationItem(R.drawable.ic_cached_black_24dp, "Aktivitas"))
                .addItem(new BottomNavigationItem(R.drawable.ic_mail_outline_black_24dp, "Laporan"))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_outline_black_24dp, "Profil"))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    @Override
    public void onTabSelected(int position) {
        //tab被选中
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
