package it.hoanguyenminh.stackoverflowuser.screen.users;

import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseListPresenter;
import it.hoanguyenminh.stackoverflowuser.model.User;

public interface UsersPresenter extends BaseListPresenter<User> {
    void favouriteUser(User user, int pos);
}

