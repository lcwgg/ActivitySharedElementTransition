package test.com.activitysharedelementtransition.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.R;
import test.com.activitysharedelementtransition.adapters.DogAdapter;

/**
 * Created by laetitia on 4/30/15.
 */
public class DogFragment extends Fragment {

    public static final String TAG = DogFragment.class.getSimpleName();

    @InjectView(R.id.recyclerview_dog)
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View v = inflater.inflate(R.layout.fragment_dog, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final List<Integer> images = new ArrayList<>();
        images.add(R.drawable.dog1);
        images.add(R.drawable.dog2);
        images.add(R.drawable.dog3);

        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        final DogAdapter dogAdapter = new DogAdapter(images);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(dogAdapter);
    }

}
