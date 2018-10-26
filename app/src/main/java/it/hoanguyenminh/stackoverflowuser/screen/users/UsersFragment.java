package it.hoanguyenminh.stackoverflowuser.screen.users;

import android.os.Bundle;
import android.view.View;

import it.hoanguyenminh.stackoverflowuser.base.fragment.BaseListFragment;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseAdapter;
import it.hoanguyenminh.stackoverflowuser.model.User;
import it.hoanguyenminh.stackoverflowuser.screen.reputation.ReputationsActivity;

public class UsersFragment extends BaseListFragment<UsersPresenter, UserViewAdapter, User> {

    public static UsersFragment newInstance() {

        Bundle args = new Bundle();

        UsersFragment fragment = new UsersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected UserViewAdapter initAdapter() {
        return new UserViewAdapter();
    }


    @Override
    protected BaseAdapter.ItemClickListener<User> getListener() {
        return new BaseAdapter.ItemClickListener<User>() {
            @Override
            public void onItemClick(View itemView, User itemData, int position, int typeClick) {
//                getPresenter().onItemClick(itemData, position);
                ReputationsActivity.startActivity(getActivity(), itemData.getUserId());
            }
        };
    }

    @Override
    protected UsersPresenter initPresenter() {
        return new UserPresenterImpl();
    }

}
