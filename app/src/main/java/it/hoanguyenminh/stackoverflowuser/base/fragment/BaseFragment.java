package it.hoanguyenminh.stackoverflowuser.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import it.hoanguyenminh.stackoverflowuser.R;
import it.hoanguyenminh.stackoverflowuser.base.mvp.BasePresenter;
import it.hoanguyenminh.stackoverflowuser.base.mvp.BaseView;
import it.hoanguyenminh.stackoverflowuser.customview.LoadingDialog;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    private P mPresenter;

    protected abstract P initPresenter();

    protected P getPresenter() {
        return mPresenter;
    }

    private LoadingDialog mLoadingDialog;
    private Unbinder mUnbinder;

    public String getFragmentTag() {
        return BaseFragment.class.getName();
    }

    protected abstract @LayoutRes
    int layoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId(), null);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading(String mess, boolean canCancel) {
        FragmentActivity activity = getActivity();
        if (activity == null) return;
        hideSoftKeyboard();
        initLoadingDialog();
        mLoadingDialog.setCancelable(canCancel);
        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }

        mLoadingDialog.setMessage("");
    }

    @Override
    public void hideLoading() {
        FragmentActivity activity = getActivity();
        if (activity == null) return;
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    private void initLoadingDialog() {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog.create(getActivity());
            mLoadingDialog.setCancelable(false);
        }
    }

    public void hideSoftKeyboard() {
        FragmentActivity activity = getActivity();
        if (activity == null) return;

        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showPopup(String message) {
        FragmentActivity activity = getActivity();
        if (activity == null) return;

        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null/* un - handle now*/);
    }


}
