package it.hoanguyenminh.stackoverflowuser.base.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import it.hoanguyenminh.stackoverflowuser.model.BaseModel;

public abstract class BaseHolderView<M extends BaseModel> extends RecyclerView.ViewHolder {
    private BaseAdapter.ItemClickListener<M> mItemClickListener;
    private M mModel;

    public BaseAdapter.ItemClickListener<M> getItemClickListener() {
        return mItemClickListener;
    }

    public void setItemClickListener(BaseAdapter.ItemClickListener<M> l) {
        this.mItemClickListener = l;
    }

    public BaseHolderView(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseAdapter.ItemClickListener<M> itemClickListener = getItemClickListener();
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, getModel(), getAdapterPosition(), 0/*whole item*/);
                }
            }
        });
    }

    public M getModel() {
        return mModel;
    }

    public void setModel(M mModel) {
        this.mModel = mModel;
    }

    public abstract void bindingView(M model, int position);
}
