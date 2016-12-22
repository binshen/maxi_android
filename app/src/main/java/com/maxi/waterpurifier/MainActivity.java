package com.maxi.waterpurifier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.maxi.waterpurifier.base.BaseActivity;
import com.maxi.waterpurifier.fragment.HomeFragment;
import com.maxi.waterpurifier.fragment.MineFragment;
import com.maxi.waterpurifier.fragment.NearbyFragment;
import com.maxi.waterpurifier.fragment.OrderFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private long clickTime = 0;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        //BadgeItem numberBadgeItem = new BadgeItem().setBorderWidth(2).setBackgroundColor(Color.RED).setText("3").setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_home_2, "主页").setActiveColor("#ff2698fa").setInactiveIconResource(R.mipmap.main_home_1));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_nearby_2, "附近").setActiveColor("#ff2698fa").setInactiveIconResource(R.mipmap.main_nearby_1));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_order_2, "订单").setActiveColor("#ff2698fa").setInactiveIconResource(R.mipmap.main_order_1));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_mine_2, "我的").setActiveColor("#ff2698fa").setInactiveIconResource(R.mipmap.main_mine_1));
        bottomNavigationBar.setFirstSelectedPosition(0).initialise();

        fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new NearbyFragment());
        fragments.add(new OrderFragment());
        fragments.add(new MineFragment());
        return fragments;
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame, new HomeFragment());
        ft.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fragments.get(position);
        ft.replace(R.id.main_frame, fragment);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - clickTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次后退键退出程序", Toast.LENGTH_SHORT).show();
                clickTime = System.currentTimeMillis();
            } else {
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
