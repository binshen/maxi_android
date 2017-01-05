package com.maxi.waterpurifier.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxi.waterpurifier.R;
import com.maxi.waterpurifier.model.Device;

import java.util.List;

/**
 * Created by bin.shen on 05/01/2017.
 */

public class DeviceListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Device> mDevices;

    public DeviceListAdapter(Context context, List<Device> devices) {
        this.mContext = context;
        this.mDevices = devices;
    }

    @Override
    public int getCount() {
        return mDevices.size();
    }

    @Override
    public Object getItem(int position) {
        return mDevices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_device_list, parent, false);
        }
        ImageView mIvDeviceStatus = (ImageView) convertView.findViewById(R.id.iv_device_status);
        TextView mTvDeviceStatus = (TextView) convertView.findViewById(R.id.tv_device_status);
        TextView mTvDeviceName = (TextView) convertView.findViewById(R.id.tv_device_name);
        TextView mTvDeviceWaterQuality = (TextView) convertView.findViewById(R.id.tv_device_water_quality);
        Device device = mDevices.get(position);
        mTvDeviceName.setText(device.getName());
        int status = device.getStatus();
        if(status == 1) {
            mTvDeviceStatus.setText("正在运行");
            mTvDeviceStatus.setTextColor(mContext.getResources().getColor(R.color.device_status_start));
            mIvDeviceStatus.setImageResource(R.mipmap.icon_device_start);
        } else {
            mTvDeviceStatus.setText("停止运行");
            mTvDeviceStatus.setTextColor(mContext.getResources().getColor(R.color.device_status_stop));
            mIvDeviceStatus.setImageResource(R.mipmap.icon_device_stop);
        }
        int waterQuality = device.getWaterQuality();
        if(waterQuality == 1) {
            mTvDeviceWaterQuality.setText("出水水质: 非常棒");
        } else {
            mTvDeviceWaterQuality.setText("出水水质: 不理想");
        }
        return convertView;
    }
}
