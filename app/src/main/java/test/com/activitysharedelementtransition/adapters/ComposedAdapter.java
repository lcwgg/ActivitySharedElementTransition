package test.com.activitysharedelementtransition.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.R;

/**
 * Created by laetitia on 4/30/15.
 */
public class ComposedAdapter extends RecyclerView.Adapter<ComposedAdapter.ViewHolder> {

    private OnItemCLickListener mItemClickListener;
    private List<Integer> mImages;

    public ComposedAdapter(List<Integer> images) {
        mImages = images;
    }

    public int getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_element_composed, viewGroup, false);

        return new ViewHolder(v);
    }

    public String getImageTransitionName(Context context, int position) {
        return context.getString(R.string.transition_name) + position;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mImageView.setImageResource(getItem(i));
        viewHolder.mTextView.setText(String.format("Dog # %1$d", i));
        viewHolder.mImageView.setTransitionName(
                getImageTransitionName(viewHolder.mImageView.getContext(), i)
        );
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @InjectView(R.id.imageview)
        ImageView mImageView;
        @InjectView(R.id.textview)
        TextView mTextView;

        public ViewHolder(final View view) {
            super(view);
            ButterKnife.inject(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {

                mItemClickListener.onItemClick(
                        mImageView,
                        mTextView,
                        getItem(getLayoutPosition()),
                        getImageTransitionName(mImageView.getContext(), getLayoutPosition())
                );
            }
        }
    }

    public interface OnItemCLickListener {
        void onItemClick(View imageView, View textView, int imageRefId, String imageTransitionName);
    }

    public void setOnItemClickListener(final OnItemCLickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

}
