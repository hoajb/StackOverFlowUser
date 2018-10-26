package it.hoanguyenminh.stackoverflowuser.screen.reputation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import it.hoanguyenminh.stackoverflowuser.base.fragment.BaseListFragment;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseAdapter;
import it.hoanguyenminh.stackoverflowuser.model.Reputation;

public class ReputationsFragment extends BaseListFragment<ReputationsPresenter, ReputationsViewAdapter, Reputation> {
    public static final String ARGS_USER_ID = "ARGS_USER_ID";

    public static ReputationsFragment newInstance(long userID) {

        Bundle args = new Bundle();

        args.putLong(ARGS_USER_ID, userID);

        ReputationsFragment fragment = new ReputationsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private long mUserID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mUserID = arguments.getLong(ARGS_USER_ID, 0);
        }

        getPresenter().updateUserID(mUserID);
    }

    @Override
    protected ReputationsViewAdapter initAdapter() {
        return new ReputationsViewAdapter();
    }


    @Override
    protected BaseAdapter.ItemClickListener<Reputation> getListener() {
        return new BaseAdapter.ItemClickListener<Reputation>() {
            @Override
            public void onItemClick(View itemView, Reputation itemData, int position, int typeClick) {
                //TODO nothing
            }
        };
    }

    @Override
    protected ReputationsPresenter initPresenter() {
        return new ReputationsPresenterImpl();
    }
}
