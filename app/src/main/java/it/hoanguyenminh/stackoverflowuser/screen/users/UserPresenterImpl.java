package it.hoanguyenminh.stackoverflowuser.screen.users;

import it.hoanguyenminh.stackoverflowuser.SOFApplication;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseListPresenterImpl;
import it.hoanguyenminh.stackoverflowuser.config.AppConfig;
import it.hoanguyenminh.stackoverflowuser.model.User;
import it.hoanguyenminh.stackoverflowuser.model.Users;
import it.hoanguyenminh.stackoverflowuser.screen.reputation.ReputationsActivity;
import retrofit2.Call;

public class UserPresenterImpl extends BaseListPresenterImpl<User, Users> implements UsersPresenter {

    @Override
    protected Call<Users> getCallRequest(int page) {
        return getRequest().getUsers(AppConfig.SITE, AppConfig.USER_PAGE_SIZE, page);
    }

    @Override
    public void favouriteUser(User user, int pos) {

    }

    @Override
    public void onItemClick(User model, int pos) {
        super.onItemClick(model, pos);

        ReputationsActivity.startActivity(SOFApplication.getContext(),model.getUserId());
    }

}
