package org.github.meuracha.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.github.domain.model.PickUpGame;
import org.github.meuracha.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cliente on 02/02/2016.
 */
public class PickUpGameAdapter extends RecyclerView.Adapter<PickUpGameAdapter.ViewHolder> {


    private final List<PickUpGame> mDataSet;

    public PickUpGameAdapter(ArrayList<PickUpGame> data) {
        Log.wtf("Pick up games adapter", "data:"+data.toString());
        this.mDataSet = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_pick_up_games, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataSet.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public CardView cv;
        public ViewHolder(View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv_pick_up_games);
            mTextView = (TextView) v.findViewById(R.id.tv_card_pick_up_game_name);
        }
    }
}
