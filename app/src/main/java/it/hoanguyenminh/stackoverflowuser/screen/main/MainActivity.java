package it.hoanguyenminh.stackoverflowuser.screen.main;

import it.hoanguyenminh.stackoverflowuser.base.activity.BaseSingleFragmentActivity;
import it.hoanguyenminh.stackoverflowuser.screen.users.UsersFragment;

public class MainActivity extends BaseSingleFragmentActivity<UsersFragment> {

    @Override
    protected UsersFragment getFragment() {
        return UsersFragment.newInstance();
    }
}
