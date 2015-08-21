package test.com.activitysharedelementtransition;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitysharedelementtransition.fragments.DogFragment;
import test.com.activitysharedelementtransition.intents.ComposedIntent;

/**
 * Created by laetitia on 4/30/15.
 */
public class ComposedActivity extends Activity {

    @InjectView(R.id.view_imageview)
    ImageView mImageView;

    @InjectView(R.id.view_name)
    TextView mTextView;

    private DogFragment mDogFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the transition (only if theme different from Theme.Material)
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

//        getWindow().setEnterTransition(new Fade());
//        getWindow().setExitTransition(new Fade());

        ComposedIntent intent = new ComposedIntent(getIntent());

        setContentView(R.layout.activity_composed);
        ButterKnife.inject(this);

        mImageView.setImageResource(intent.getImageId());
        mTextView.setText(intent.getTextViewContent());

        mTextView.setTransitionName(intent.getTextViewContent());
        mImageView.setTransitionName(intent.getTransitionName());

        mDogFragment = new DogFragment();

        mImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDogFragment.setEnterTransition(TransitionInflater.from(ComposedActivity.this).inflateTransition(R.transition.slide_bottom));
                mDogFragment.setExitTransition(new Slide());

                getFragmentManager().beginTransaction()
                        .add(R.id.container, mDogFragment, DogFragment.TAG)
                        .commit();

            }
        }, 400);



    }


    @Override
    public void onBackPressed() {
        if (mDogFragment.isVisible()) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new Fragment())
                    .commit();
        }
        super.onBackPressed();
    }

}
