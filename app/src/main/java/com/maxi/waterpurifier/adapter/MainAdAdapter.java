package com.maxi.waterpurifier.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.maxi.waterpurifier.R;

/**
 * Created by bin.shen on 22/12/2016.
 */

public class MainAdAdapter extends BaseAdapter {

    private Context mContext;


    public int[] imgList = {
        R.drawable.main_ad_1,
        R.drawable.main_ad_2,
        R.drawable.main_ad_2,
        R.drawable.main_ad_1
    };

    public MainAdAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_main_ad, parent, false);
        }

        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_main_ad);
        iv.setBackgroundResource(imgList[position]);
        return convertView;
    }
}
