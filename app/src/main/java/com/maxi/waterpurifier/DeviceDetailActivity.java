package com.maxi.waterpurifier;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maxi.waterpurifier.base.BaseActivity;
import com.maxi.waterpurifier.fragment.FilterStatusFragment;
import com.maxi.waterpurifier.fragment.WaterYieldFragment;

import java.util.ArrayList;
import java.util.List;

public class DeviceDetailActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRgDeviceGroup;
    private RadioButton mRbBtnFilterStatus;
    private RadioButton mRbBtnWaterYield;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        RelativeLayout mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mHeadLayout.setBackgroundColor(getResources().getColor(R.color.maxi_head_main_color));
        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setImageResource(R.mipmap.btn_back2);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("淼溪净水");
        mTvHeader.setTextColor(getResources().getColor(R.color.white));
        ImageView btn_head_right = (ImageView) findViewById(R.id.btn_head_right);
        btn_head_right.setImageResource(R.mipmap.icon_device_config);
        btn_head_right.setOnClickListener(this);

        mRgDeviceGroup = (RadioGroup) findViewById(R.id.rg_device_group);
        mRgDeviceGroup.setOnCheckedChangeListener(this);

        mRbBtnFilterStatus = (RadioButton) findViewById(R.id.rb_btn_filter_status);
        mRbBtnFilterStatus.getPaint().setFakeBoldText(true);
        mRbBtnWaterYield = (RadioButton) findViewById(R.id.rb_btn_water_yield);
        mRbBtnWaterYield.getPaint().setFakeBoldText(true);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        FilterStatusFragment fsFragment = new FilterStatusFragment();
        WaterYieldFragment wyFragment = new WaterYieldFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(fsFragment);
        fragments.add(wyFragment);
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setCurrentItem(0);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRgDeviceGroup.check(R.id.rb_btn_filter_status);
                        break;
                    case 1:
                        mRgDeviceGroup.check(R.id.rb_btn_water_yield);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.btn_head_right:
                startActivityForResult(new Intent(this, DeviceConfigActivity.class), 1);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        Drawable drawable = getResources().getDrawable(R.drawable.bg_underline);
        switch (checkedId) {
            case R.id.rb_btn_filter_status:
                mViewPager.setCurrentItem(0);
                mRbBtnFilterStatus.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                mRbBtnFilterStatus.setTextColor(getResources().getColor(R.color.device_water_tab1));
                mRbBtnWaterYield.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                mRbBtnWaterYield.setTextColor(getResources().getColor(R.color.device_water_tab2));
                break;

            case R.id.rb_btn_water_yield:
                mViewPager.setCurrentItem(1);
                mRbBtnFilterStatus.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                mRbBtnFilterStatus.setTextColor(getResources().getColor(R.color.device_water_tab2));
                mRbBtnWaterYield.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                mRbBtnWaterYield.setTextColor(getResources().getColor(R.color.device_water_tab1));
                break;
        }
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                finish();
            }
        }
    }
}
