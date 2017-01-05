package com.maxi.waterpurifier;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maxi.waterpurifier.adapter.DeviceListAdapter;
import com.maxi.waterpurifier.base.BaseActivity;
import com.maxi.waterpurifier.model.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceMainActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private DeviceListAdapter mDeviceListAdapter;
    private ListView mLvDevices;
    private List<Device> mDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_main);

        RelativeLayout mHeadLayout = (RelativeLayout) findViewById(R.id.head_layout);
        mHeadLayout.setBackgroundColor(getResources().getColor(R.color.maxi_head_main_color));
        ImageView btn_head_left = (ImageView) findViewById(R.id.btn_head_left);
        btn_head_left.setImageResource(R.mipmap.btn_back2);
        btn_head_left.setOnClickListener(this);
        TextView mTvHeader = (TextView) findViewById(R.id.tv_head_title);
        mTvHeader.setText("淼溪净水");
        mTvHeader.setTextColor(getResources().getColor(R.color.white));
        ImageView btn_head_right = (ImageView) findViewById(R.id.btn_head_right);
        btn_head_right.setImageResource(R.mipmap.icon_device_add);
        btn_head_right.setOnClickListener(this);

        mDevices = new ArrayList<>();
        Device d1 = new Device();
        d1.set_id("id_1");
        d1.setName("淼溪净水器设备1");
        d1.setStatus(1);
        d1.setWaterQuality(1);
        mDevices.add(d1);

        Device d2 = new Device();
        d2.set_id("id_2");
        d2.setName("淼溪净水器设备2");
        d2.setStatus(0);
        d1.setWaterQuality(1);
        mDevices.add(d2);

        mDeviceListAdapter = new DeviceListAdapter(getApplicationContext(), mDevices);
        mLvDevices = (ListView) findViewById(R.id.lv_device_list);
        mLvDevices.setOnItemClickListener(this);
        mLvDevices.setAdapter(mDeviceListAdapter);

        mDeviceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_head_left:
                finish();
                break;

            case R.id.btn_head_right:

                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), mDevices.get(position).get_id(), Toast.LENGTH_SHORT).show();
    }
}
