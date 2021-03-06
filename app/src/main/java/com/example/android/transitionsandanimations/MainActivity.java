package com.example.android.transitionsandanimations;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseClass {
    private static final String LOG_TAG = "TAG_N";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        ImageView yellowBlock = findViewById(R.id.yellowBlock);
        ImageView androidBlock = findViewById(R.id.androidBlock);

        explodeTransition(this, redBlock);
        fadeTransition(this, blueBlock);
        rotateView(yellowBlock);
        switchAnimation(androidBlock,blueBlock,new Intent(
                this, SecondActivity.class),this);
    }

    public void getVortex2(View view){
        Log.d(LOG_TAG, "Button clicked!");
        Intent intentA =  new Intent(this, VortextActivity2.class);
        startActivity(intentA);
    }

    public void getVortex1(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intentB =  new Intent(this, VortexActivity.class);
        startActivity(intentB);
    }
    public void getScoreR(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intentC =  new Intent(this, RecycleActivity.class);
        startActivity(intentC);
    }
}

