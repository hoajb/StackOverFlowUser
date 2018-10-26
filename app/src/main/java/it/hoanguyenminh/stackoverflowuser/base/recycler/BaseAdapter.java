package it.hoanguyenminh.stackoverflowuser.base.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import it.hoanguyenminh.stackoverflowuser.model.BaseModel;
import it.hoanguyenminh.stackoverflowuser.utils.CollectionUtils;

public abstract class BaseAdapter<M extends BaseModel> extends RecyclerView.Adapter<BaseHolderView<M>> {
    public interface ItemClickListener<M> {
        void onItemClick(View itemView, M itemData, int position, int typeClick);
    }

    private ArrayList<M> mArrayList = new ArrayList<>();
    private ItemClickListener mItemClickListener;

    public void setItemClickListener(ItemClickListener l) {
        this.mItemClickListener = l;
    }

    public void updateData(ArrayList<M> arrayList) {
        setData(arrayList);
        notifyDataSetChanged();
    }

    public void setData(ArrayList<M> arrayList) {
        mArrayList.clear();

        if (CollectionUtils.isNotEmpty(arrayList)) {
            mArrayList.addAll(arrayList);
        }
    }

    @Override
    public int getItemCount() {
        return CollectionUtils.getSize(mArrayList);
    }

    public M getItem(int position) {
        return CollectionUtils.isNotEmpty(mArrayList) ? mArrayList.get(position) : null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolderView<M> holderView, int position) {
        holderView.setItemClickListener(mItemClickListener);
        M item = getItem(position);
        holderView.setModel(item);
        holderView.bindingView(item, position);
    }
}
