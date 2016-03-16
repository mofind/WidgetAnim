package com.mofind.widgetanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mofind.widgetanim.support.anim.AnimUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shakeOnclick1(View v) {
        AnimUtils.horizontalShake(this, v);
    }

    public void shakeOnclick2(View v) {
        AnimUtils.verticalShake(this, v);
    }

    public void retate3DOnclick1(View v) {
        AnimUtils.retate3D(this, v, true);
    }

    public void retate3DOnclick2(View v) {
        AnimUtils.retate3D(this, v, false);
    }

    public void rockOnclick(View v) {
        AnimUtils.clickScale(this, v);
    }
}
