package it.hoanguyenminh.stackoverflowuser.screen.reputation;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseAdapter;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseHolderView;
import it.hoanguyenminh.stackoverflowuser.model.Reputation;

public class ReputationsViewAdapter extends BaseAdapter<Reputation> {

    @NonNull
    @Override
    public BaseHolderView<Reputation> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //not viewType now
        return ReputationItemViewHolder.newInstance(viewGroup);
    }

}
