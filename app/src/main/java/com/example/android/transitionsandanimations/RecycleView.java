package com.example.android.transitionsandanimations;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecycleView extends RecyclerView.Adapter<RecycleView.ScoreViewHolder> {

    private final LinkedList<String> mScoreList;
    private final LayoutInflater mInflater;

    class ScoreViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView scoreItemView;
        final RecycleView mAdapter;

        public ScoreViewHolder(View itemView, RecycleView adapter) {
            super(itemView);
            scoreItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();

            String element = mScoreList.get(mPosition);
            mScoreList.set(mPosition, "Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }
    }

    public RecycleView(Context context, LinkedList<String> scoreList) {
        mInflater = LayoutInflater.from(context);
        this.mScoreList = scoreList;
    }

    @Override
    public RecycleView.ScoreViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.score_layout, parent, false);
        return new ScoreViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecycleView.ScoreViewHolder holder,
                                 int position) {
        String mCurrent = mScoreList.get(position);
        holder.scoreItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mScoreList.size();
    }
}

