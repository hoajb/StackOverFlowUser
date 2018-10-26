package it.hoanguyenminh.stackoverflowuser.base.mvp;

public interface BaseView {
    void showLoading(String mess, boolean canCancel);

    void hideLoading();

    void showPopup(String message);

}
