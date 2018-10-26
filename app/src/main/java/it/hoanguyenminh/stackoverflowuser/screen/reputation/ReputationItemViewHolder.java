package it.hoanguyenminh.stackoverflowuser.screen.reputation;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.hoanguyenminh.stackoverflowuser.R;
import it.hoanguyenminh.stackoverflowuser.base.recycler.BaseHolderView;
import it.hoanguyenminh.stackoverflowuser.model.Reputation;
import it.hoanguyenminh.stackoverflowuser.utils.DateTimeUtils;

public class ReputationItemViewHolder extends BaseHolderView<Reputation> {
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.change)
    TextView change;
    @BindView(R.id.createAt)
    TextView createAt;

    @BindView(R.id.postID)
    TextView postID;
    private View mRootView;

    public static BaseHolderView<Reputation> newInstance(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reputation, parent, false);
        return new ReputationItemViewHolder(v);
    }

    ReputationItemViewHolder(@NonNull final View itemView) {
        super(itemView);
        mRootView = itemView;
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void bindingView(@NonNull Reputation model, int position) {
        Resources resources = type.getResources();
        type.setText(resources.getString(R.string.type_,
                String.valueOf(model.getReputationHistoryType())));
        change.setText(resources.getString(R.string.change_,
                String.valueOf(model.getReputationChange())));
        createAt.setText(resources.getString(R.string.createAt_,
                DateTimeUtils.formatDate(model.getCreationDate())));
        postID.setText(resources.getString(R.string.posID_,
                String.valueOf(model.getPostId())));

        if (position % 2 == 0) {
            mRootView.setBackgroundColor(resources.getColor(R.color.colorLight));
        } else {
            mRootView.setBackgroundColor(resources.getColor(R.color.white));
        }
    }
}
