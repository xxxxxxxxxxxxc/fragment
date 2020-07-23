package com.thoughtworks.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.to_android_fragment)
    Button toAndroidFragment;

    @BindView(R.id.to_java_fragment)
    Button toJavaFragment;

    @OnClick(R.id.to_android_fragment) void click() {
        Log.d("click", "android click");
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_fragment, this.androidFragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.to_java_fragment) void java_click() {
        Log.d("click", "java click");
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_fragment, this.javaFragment);
        fragmentTransaction.commit();
    }


    private AndroidFragment androidFragment = new AndroidFragment();
    private JavaFragment javaFragment = new JavaFragment();

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_fragment, this.androidFragment);
        fragmentTransaction.commit();
    }
}