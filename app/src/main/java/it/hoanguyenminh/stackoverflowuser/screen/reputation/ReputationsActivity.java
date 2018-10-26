package it.hoanguyenminh.stackoverflowuser.screen.reputation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import it.hoanguyenminh.stackoverflowuser.base.activity.BaseSingleFragmentActivity;

public class ReputationsActivity extends BaseSingleFragmentActivity<ReputationsFragment> {
    private long mUserID;

    public static void startActivity(Context context, long userID) {
        Intent intent = new Intent(context, ReputationsActivity.class);
        intent.putExtra(ReputationsFragment.ARGS_USER_ID, userID);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        mUserID = intent.getLongExtra(ReputationsFragment.ARGS_USER_ID, 0);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected ReputationsFragment getFragment() {
        return ReputationsFragment.newInstance(mUserID);
    }

}
