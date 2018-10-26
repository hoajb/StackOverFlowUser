package it.hoanguyenminh.stackoverflowuser.screen.reputation;

import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseListPresenterImpl;
import it.hoanguyenminh.stackoverflowuser.config.AppConfig;
import it.hoanguyenminh.stackoverflowuser.model.Reputation;
import it.hoanguyenminh.stackoverflowuser.model.Reputations;
import retrofit2.Call;

public class ReputationsPresenterImpl extends BaseListPresenterImpl<Reputation, Reputations> implements ReputationsPresenter {

    private long mUserID;

    public ReputationsPresenterImpl() {
    }

    @Override
    protected Call<Reputations> getCallRequest(int page) {
        return getRequest().getReputations(mUserID, AppConfig.SITE, AppConfig.USER_PAGE_SIZE, page);
    }


    @Override
    public void onItemClick(Reputation model, int pos) {
        super.onItemClick(model, pos);
    }

    @Override
    public void updateUserID(long userID) {
        mUserID = userID;
    }
}
