package com.example.vietvan.lapitchat.ui.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.vietvan.lapitchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Intro extends AppCompatActivity {


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {

            Intent start = new Intent(Intro.this, Home.class);
            startActivity(start);
            finish();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSignIn, R.id.btnSignUp, R.id.btn_bluetooth})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                startActivity(new Intent(Intro.this, SignIn.class));
                break;
            case R.id.btnSignUp:
                startActivity(new Intent(Intro.this, SignUp.class));
                break;
            case R.id.btn_bluetooth:
                BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (bluetoothAdapter == null) {
                    Toast.makeText(this, "Bluetooth is not available!", Toast.LENGTH_SHORT).show();
                    finish(); //automatic close app if Bluetooth service is not available!
                } else {

                    startActivity(new Intent(Intro.this, ChatBluetooth.class));
                }

                break;
            default:
                break;
        }
    }
}
