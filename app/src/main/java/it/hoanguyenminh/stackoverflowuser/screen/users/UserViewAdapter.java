package it.hoanguyenminh.stackoverflowuser.screen.users;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseAdapter;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseHolderView;
import it.hoanguyenminh.stackoverflowuser.model.User;

public class UserViewAdapter extends BaseAdapter<User> {

    @NonNull
    @Override
    public BaseHolderView<User> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //not viewType now
        return UserItemViewHolder.newInstance(viewGroup);
    }
}
