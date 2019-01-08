package com.example.vietvan.lapitchat.ui.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vietvan.lapitchat.R;
import com.example.vietvan.lapitchat.ui.adapter.MessagesAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class ChatBluetooth extends AppCompatActivity implements MessagesAdapter.OnClickItem {
    private static final int REQUEST_ENABLE_BLUETOOTH = 100;
    private static final int REQUEST_CONNECT_DEVICE_SECURE = 101;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.btn_more)
    ImageView btnMore;
    @BindView(R.id.btn_bluetooth)
    ImageView btnBluetooth;
    @BindView(R.id.rv_messages)
    RecyclerView rvMessages;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_camera)
    ImageView ivCamera;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.ll_collapse)
    LinearLayout llCollapse;
    @BindView(R.id.edt_message)
    EmojiconEditText edtMessage;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.iv_send)
    ImageView ivSend;
    @BindView(R.id.ll_bot)
    LinearLayout llBot;
    @BindView(R.id.root_view)
    RelativeLayout rootView;
    BluetoothAdapter bluetoothAdapter;
    @Override
    public void onClick() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bluetooth);
        ButterKnife.bind(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
       bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BLUETOOTH);
        }
    }

    @OnClick({R.id.iv_back, R.id.btn_more, R.id.btn_bluetooth, R.id.iv_add, R.id.iv_camera, R.id.iv_photo, R.id.iv_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_more:
                break;
            case R.id.btn_bluetooth:
                Intent serverIntent = new Intent(this, DeviceListActivity.class);
                startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_SECURE);
                break;
            case R.id.iv_add:
                break;
            case R.id.iv_camera:
                break;
            case R.id.iv_photo:
                break;
            case R.id.iv_send:
                break;
        }
    }

}
