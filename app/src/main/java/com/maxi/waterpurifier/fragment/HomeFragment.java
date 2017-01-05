package com.maxi.waterpurifier.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.etsy.android.grid.StaggeredGridView;
import com.maxi.waterpurifier.DeviceMainActivity;
import com.maxi.waterpurifier.R;
import com.maxi.waterpurifier.adapter.MainAdAdapter;
import com.maxi.waterpurifier.base.BaseFragment;
import com.maxi.waterpurifier.widget.ImageTextView;

public class HomeFragment extends BaseFragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    private SliderLayout mSlider;

    private ImageTextView mItvMainIcon1;
    private ImageTextView mItvMainIcon2;
    private ImageTextView mItvMainIcon3;
    private ImageTextView mItvMainIcon4;
    private ImageTextView mItvMainIcon5;
    private ImageTextView mItvMainIcon6;
    private ImageTextView mItvMainIcon7;
    private ImageTextView mItvMainIcon8;

    private StaggeredGridView mGridView;
    private MainAdAdapter mAdapter;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSlider = (SliderLayout) view.findViewById(R.id.slider);

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
//        for(String name : url_maps.keySet()){
//            TextSliderView textSliderView = new TextSliderView(getContext());
//            textSliderView.image(url_maps.get(name));
//            textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
//            mSlider.addSlider(textSliderView);
//        }

        DefaultSliderView sliderView1 = new DefaultSliderView(getContext());
        sliderView1.image(R.drawable.home_slider1);
        sliderView1.setScaleType(BaseSliderView.ScaleType.Fit);
        mSlider.addSlider(sliderView1);
        DefaultSliderView sliderView2 = new DefaultSliderView(getContext());
        sliderView2.image(R.drawable.home_slider1);
        sliderView2.setScaleType(BaseSliderView.ScaleType.Fit);
        mSlider.addSlider(sliderView2);
        DefaultSliderView sliderView3 = new DefaultSliderView(getContext());
        sliderView3.image(R.drawable.home_slider1);
        sliderView3.setScaleType(BaseSliderView.ScaleType.Fit);
        mSlider.addSlider(sliderView3);
        DefaultSliderView sliderView4 = new DefaultSliderView(getContext());
        sliderView4.image(R.drawable.home_slider1);
        sliderView4.setScaleType(BaseSliderView.ScaleType.Fit);
        mSlider.addSlider(sliderView4);
        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        //mSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Visible);
        //mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(5000);
        mSlider.addOnPageChangeListener(this);
        mSlider.setCustomIndicator((PagerIndicator) view.findViewById(R.id.custom_indicator));


//        mGridView = (StaggeredGridView) view.findViewById(R.id.grid_view);
//        mAdapter = new MainAdAdapter(getContext());
//        mGridView.setAdapter(mAdapter);

        mItvMainIcon1 = (ImageTextView) view.findViewById(R.id.itv_main_icon_1);
        mItvMainIcon2 = (ImageTextView) view.findViewById(R.id.itv_main_icon_2);
        mItvMainIcon3 = (ImageTextView) view.findViewById(R.id.itv_main_icon_3);
        mItvMainIcon4 = (ImageTextView) view.findViewById(R.id.itv_main_icon_4);
        mItvMainIcon5 = (ImageTextView) view.findViewById(R.id.itv_main_icon_5);
        mItvMainIcon6 = (ImageTextView) view.findViewById(R.id.itv_main_icon_6);
        mItvMainIcon7 = (ImageTextView) view.findViewById(R.id.itv_main_icon_7);
        mItvMainIcon8 = (ImageTextView) view.findViewById(R.id.itv_main_icon_8);
        mItvMainIcon1.setOnClickListener(this);
        mItvMainIcon2.setOnClickListener(this);
        mItvMainIcon3.setOnClickListener(this);
        mItvMainIcon4.setOnClickListener(this);
        mItvMainIcon5.setOnClickListener(this);
        mItvMainIcon6.setOnClickListener(this);
        mItvMainIcon7.setOnClickListener(this);
        mItvMainIcon8.setOnClickListener(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.itv_main_icon_1:
                //Toast.makeText(getContext(), "您点击了：淼溪净水", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), DeviceMainActivity.class));
                break;
            case R.id.itv_main_icon_2:
                Toast.makeText(getContext(), "您点击了：智能家居", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itv_main_icon_3:
                Toast.makeText(getContext(), "您点击了：远程医疗", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itv_main_icon_4:
                Toast.makeText(getContext(), "您点击了：便民服务", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itv_main_icon_5:
                Toast.makeText(getContext(), "您点击了：外卖订餐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itv_main_icon_6:
                Toast.makeText(getContext(), "您点击了：蔬果生鲜", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itv_main_icon_7:
                Toast.makeText(getContext(), "您点击了：装修建材", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itv_main_icon_8:
                Toast.makeText(getContext(), "您点击了：社区资讯", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
