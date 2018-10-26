package it.hoanguyenminh.stackoverflowuser.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import it.hoanguyenminh.stackoverflowuser.R;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseAdapter;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseListPresenter;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseListView;
import it.hoanguyenminh.stackoverflowuser.model.BaseModel;

public abstract class BaseListFragment<P extends BaseListPresenter, A extends BaseAdapter<M>, M extends BaseModel>
        extends BaseFragment<P> implements BaseListView<M> {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private A mAdapter;

    protected abstract A initAdapter();

    public void updateAdapter(ArrayList<M> arrayList) {
        if (mAdapter == null) {
            mAdapter = initAdapter();
            mAdapter.setItemClickListener(getListener());
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.updateData(arrayList);
        }
    }

    @Override
    public void bindingList(ArrayList<M> list, int page) {
        if (page == 1) {
            updateAdapter(list);
            mAdapter.setData(list);
        } else {
            mAdapter.updateData(list);
        }
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    protected BaseAdapter.ItemClickListener<M> getListener() {
        return null;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(getLayoutManager());

        getPresenter().loadList(1);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_single_recyclerview;
    }
}
