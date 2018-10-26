package it.hoanguyenminh.stackoverflowuser.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import it.hoanguyenminh.stackoverflowuser.R;
import it.hoanguyenminh.stackoverflowuser.base.fragment.BaseFragment;

public abstract class BaseSingleFragmentActivity<F extends BaseFragment> extends BaseActivity {
    protected abstract F getFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        F fragment = getFragment();

        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frameContent, fragment, fragment.getFragmentTag())
                    .commit();
        }

    }
}
