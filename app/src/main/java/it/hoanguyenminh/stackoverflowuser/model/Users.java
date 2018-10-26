package it.hoanguyenminh.stackoverflowuser.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Users extends BaseListModel {
    @SerializedName("items")
    private ArrayList<User> mUsers;

    public ArrayList<User> getUsers() {
        return mUsers;
    }

    @Override
    public ArrayList getArrayList() {
        return getUsers();
    }
}
