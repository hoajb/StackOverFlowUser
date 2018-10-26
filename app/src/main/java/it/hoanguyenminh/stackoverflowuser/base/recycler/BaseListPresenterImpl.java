package it.hoanguyenminh.stackoverflowuser.base.recycler;

import java.util.ArrayList;

import it.hoanguyenminh.stackoverflowuser.base.mvp.BasePresenterImpl;
import it.hoanguyenminh.stackoverflowuser.base.request.RequestCallback;
import it.hoanguyenminh.stackoverflowuser.base.request.RequestError;
import it.hoanguyenminh.stackoverflowuser.model.BaseListModel;
import it.hoanguyenminh.stackoverflowuser.model.BaseModel;
import retrofit2.Call;

public abstract class BaseListPresenterImpl<M extends BaseModel, ML extends BaseListModel>
        extends BasePresenterImpl<BaseListView> implements BaseListPresenter<M> {

    private int mCurrentPage = 0;

    public int getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(int page) {
        this.mCurrentPage = page;
    }

    protected abstract Call<ML> getCallRequest(int page);

    @Override
    public void loadList(final int page) {
        getView().showLoading("", false);
        addCall(getCallRequest(page), new RequestCallback<ML>() {
            @Override
            public void onSuccess(ML data) {
                ArrayList arrayList = data.getArrayList();
                getView().bindingList(arrayList, page);
            }

            @Override
            public void onFailure(RequestError error) {
                getView().showPopup(error.getErrorMess());
            }

            @Override
            public void onFinish() {
                getView().hideLoading();
            }
        });
    }

    @Override
    public void loadMore() {
        //TODO
    }

    @Override
    public void onItemClick(M model, int pos) {

    }


}
