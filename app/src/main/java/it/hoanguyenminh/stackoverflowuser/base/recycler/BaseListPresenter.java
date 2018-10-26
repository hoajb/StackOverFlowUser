package it.hoanguyenminh.stackoverflowuser.base.recycler;

import it.hoanguyenminh.stackoverflowuser.base.mvp.BasePresenter;
import it.hoanguyenminh.stackoverflowuser.model.BaseModel;

public interface BaseListPresenter<M extends BaseModel> extends BasePresenter<BaseListView> {

    void loadList(int page);

    void loadMore();

    void onItemClick(M model, int pos);

}
