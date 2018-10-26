package it.hoanguyenminh.stackoverflowuser.model;

import java.util.ArrayList;

public abstract class BaseListModel<M extends BaseModel> extends BaseModel {
    public abstract ArrayList<M> getArrayList();
}
