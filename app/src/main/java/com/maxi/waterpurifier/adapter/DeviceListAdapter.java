package com.maxi.waterpurifier.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return convertView;
    }
}
