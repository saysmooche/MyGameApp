package com.example.android.transitionsandanimations;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.LinkedList;

public class RecycleActivity extends AppCompatActivity {

    private final LinkedList<String> mScoreList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private RecycleView mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int scoreListSize = mScoreList.size();
                mScoreList.addLast("+ Score " + scoreListSize);
                mRecyclerView.getAdapter().notifyItemInserted(scoreListSize);
                mRecyclerView.smoothScrollToPosition(scoreListSize);
            }
        });

        for (int i = 0; i < 20; i++) {
            mScoreList.addLast("Score " + i);
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new RecycleView(this, mScoreList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

