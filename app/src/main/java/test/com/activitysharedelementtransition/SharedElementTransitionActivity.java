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
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.adapters.ComposedAdapter;
import test.com.activitysharedelementtransition.adapters.SingleImageAdapter;
import test.com.activitysharedelementtransition.intents.ComposedIntent;
import test.com.activitysharedelementtransition.intents.SharedElementTransitionIntent;
import test.com.activitysharedelementtransition.intents.SingleImageIntent;

public class SharedElementTransitionActivity extends Activity
        implements SingleImageAdapter.OnItemCLickListener,
        ComposedAdapter.OnItemCLickListener {

    @InjectView(test.com.activitysharedelementtransition.R.id.recyclerview)
    RecyclerView mRecyclerView;

    public enum Choice {SINGLE, FRAGMENT}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the shared element transition (only if theme different from Theme.Material)
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

//        getWindow().setEnterTransition(new Fade());
//        getWindow().setExitTransition(new Fade());

        setContentView(R.layout.activity_transition);
        ButterKnife.inject(this);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.chiot1);
        images.add(R.drawable.chiot2);
        images.add(R.drawable.chiot3);
        images.add(R.drawable.chiot4);
        images.add(R.drawable.chiot5);
        images.add(R.drawable.chiot6);
        images.add(R.drawable.chiot7);
        images.add(R.drawable.chiot8);

        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        SharedElementTransitionIntent intent = new SharedElementTransitionIntent(getIntent());

        final Choice choice = intent.getChoice();

        if (choice == Choice.SINGLE) {
            final SingleImageAdapter adapter = new SingleImageAdapter(images);
            mRecyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(this);
        } else {
            final ComposedAdapter adapter = new ComposedAdapter(images);
            mRecyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(this);
        }

    }

    @Override
    public void onItemClick(View imageView, int imageRefId, String imageTransitionName) {
        final SingleImageIntent intent = new SingleImageIntent(this, imageRefId, imageTransitionName);
        final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, imageView, imageTransitionName);

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

    @Override
    public void onItemClick(View imageView, View textView, int imageRefId, String imageTransitionName) {
        final String textViewContent = ((TextView)textView).getText().toString();
        final ComposedIntent intent = new ComposedIntent(this, imageRefId, imageTransitionName, textViewContent);

        final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                new Pair<>(imageView, imageTransitionName),
                new Pair<>(textView, textViewContent)
        );
        startActivity(intent, options.toBundle());
    }
}
