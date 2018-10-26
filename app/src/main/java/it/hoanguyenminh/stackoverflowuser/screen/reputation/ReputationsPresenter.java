package it.hoanguyenminh.stackoverflowuser.screen.reputation;

import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseListPresenter;
import it.hoanguyenminh.stackoverflowuser.model.Reputation;

public interface ReputationsPresenter extends BaseListPresenter<Reputation> {
    void updateUserID(long userID);
}

