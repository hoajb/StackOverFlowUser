package it.hoanguyenminh.stackoverflowuser.base.recycler;

import java.util.ArrayList;

import it.hoanguyenminh.stackoverflowuser.base.mvp.BaseView;
import it.hoanguyenminh.stackoverflowuser.model.BaseModel;

public interface BaseListView<M extends BaseModel> extends BaseView {
    void bindingList(ArrayList<M> list, int page);
}
