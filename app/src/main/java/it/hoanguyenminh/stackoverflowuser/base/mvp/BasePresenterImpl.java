package it.hoanguyenminh.stackoverflowuser.base.mvp;

import it.hoanguyenminh.stackoverflowuser.base.request.NetworkRequest;
import it.hoanguyenminh.stackoverflowuser.base.request.RequestCallback;
import it.hoanguyenminh.stackoverflowuser.model.BaseModel;
import retrofit2.Call;

public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    private V mView;
    private NetworkRequest.NetworkAPI mRequest;
    private boolean isAttached;

    protected V getView() {
        return mView;
    }

    @Override
    public void attachView(V view) {
        mRequest = NetworkRequest.newInstance().getNetworkAPI();
        mView = view;
        isAttached = true;
    }

    public NetworkRequest.NetworkAPI getRequest() {
        return mRequest;
    }

    public void addCall(Call call, RequestCallback<? extends BaseModel> callback) {
        if (isAttached) {
            call.enqueue(callback);
        }
    }

    @Override
    public void detachView() {
        mView = null;
        isAttached = false;
    }
}
