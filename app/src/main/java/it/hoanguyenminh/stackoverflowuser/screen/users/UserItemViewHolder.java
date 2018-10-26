package it.hoanguyenminh.stackoverflowuser.screen.users;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.hoanguyenminh.stackoverflowuser.R;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseHolderView;
import it.hoanguyenminh.stackoverflowuser.model.User;
import it.hoanguyenminh.stackoverflowuser.utils.DateTimeUtils;

public class UserItemViewHolder extends BaseHolderView<User> {
    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.userReputation)
    TextView userReputation;
    @BindView(R.id.userLocation)
    TextView userLocation;
    @BindView(R.id.userLastAccessDate)
    TextView userLastAccessDate;
    private View mRootView;

    public static BaseHolderView<User> newInstance(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserItemViewHolder(v);
    }

    UserItemViewHolder(@NonNull final View itemView) {
        super(itemView);
        mRootView = itemView;
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void bindingView(@NonNull User model, int position) {
        Resources resources = userName.getResources();
        Glide.with(thumbnail.getContext()).load(model.getProfileImage()).into(thumbnail);
        userName.setText(model.getDisplayName());
        userReputation.setText(resources.getString(R.string.reputation_,
                String.valueOf(model.getReputation())));
        userLocation.setText(resources.getString(R.string.location_,
                String.valueOf(model.getLocation())));
        userLastAccessDate.setText(resources.getString(R.string.last_access_date_,
                DateTimeUtils.formatDate(model.getLastAccessDate())));

        if (position % 2 == 0) {
            mRootView.setBackgroundColor(resources.getColor(R.color.colorLight));
        } else {
            mRootView.setBackgroundColor(resources.getColor(R.color.white));
        }
    }
}
