package test.com.activitysharedelementtransition.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.R;

/**
 * Created by laetitia on 4/30/15.
 */
public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {

    private List<Integer> mImages;

    public DogAdapter(List<Integer> images) {
        mImages = images;
    }

    public int getItem(int position) {
        return mImages.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gridview_element_dog, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mImageView.setImageResource(getItem(i));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.imageview)
        ImageView mImageView;

        public ViewHolder(final View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

    }
}
