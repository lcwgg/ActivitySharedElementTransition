package test.com.activitysharedelementtransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.adapters.SingleImageAdapter;
import test.com.activitysharedelementtransition.intents.SingleImageIntent;

public class SharedElementTransitionActivity extends Activity implements SingleImageAdapter.OnItemCLickListener {

    @InjectView(test.com.activitysharedelementtransition.R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the shared element transition
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_transition);
        ButterKnife.inject(this);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot1);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot2);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot3);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot4);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot5);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot6);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot7);
        images.add(test.com.activitysharedelementtransition.R.drawable.chiot8);

        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        final SingleImageAdapter adapter = new SingleImageAdapter(images);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(View imageView, int imageRefId, String imageTransitionName) {
        SingleImageIntent intent = new SingleImageIntent(this, imageRefId, imageTransitionName);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, imageView, imageTransitionName);

        // Examples of transition
//        getWindow().setSharedElementEnterTransition(new ChangeBounds());
//        getWindow().setSharedElementExitTransition(new ChangeBounds());

//        getWindow().setSharedElementEnterTransition(new ChangeClipBounds());
//        getWindow().setSharedElementExitTransition(new ChangeClipBounds());

//        getWindow().setSharedElementEnterTransition(new ChangeTransform());
//        getWindow().setSharedElementExitTransition(new ChangeTransform());

//        getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
//        getWindow().setSharedElementExitTransition(new ChangeImageTransform());

//        getWindow().setSharedElementEnterTransition(new AutoTransition());
//        getWindow().setSharedElementExitTransition(new AutoTransition());

        startActivity(intent, options.toBundle());

    }
}
