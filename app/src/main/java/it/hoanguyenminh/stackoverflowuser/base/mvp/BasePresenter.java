package it.hoanguyenminh.stackoverflowuser.base.mvp;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
