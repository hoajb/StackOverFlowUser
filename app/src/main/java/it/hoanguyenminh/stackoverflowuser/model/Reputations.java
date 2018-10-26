package it.hoanguyenminh.stackoverflowuser.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Reputations extends BaseListModel<Reputation> {
    @SerializedName("items")
    private ArrayList<Reputation> mList;

    public ArrayList<Reputation> getList() {
        return mList;
    }

    @Override
    public ArrayList<Reputation> getArrayList() {
        return getList();
    }
}
