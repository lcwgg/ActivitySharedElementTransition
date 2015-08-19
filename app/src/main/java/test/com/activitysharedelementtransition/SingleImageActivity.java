package test.com.activitysharedelementtransition;

import android.app.Activity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Transition;
import android.view.Window;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.intents.SingleImageIntent;

/**
 * Created by laetitia on 4/30/15.
 */
public class SingleImageActivity extends Activity {

    @InjectView(test.com.activitysharedelementtransition.R.id.view_dog_imageview)
    ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the shared element transition
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

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

        setContentView(R.layout.activity_single_image);
        ButterKnife.inject(this);

        SingleImageIntent intent = new SingleImageIntent(getIntent());
        // the image is originally from a listview, with no unique transition name specifically defined
        // Here, the transition names are generated on the fly
        // The transition name must be applied to the ImageView
        mImageView.setTransitionName(intent.getTransitionName());
        mImageView.setImageResource(intent.getImageId());
    }

}
