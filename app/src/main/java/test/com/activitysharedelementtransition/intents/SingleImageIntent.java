package test.com.activitysharedelementtransition.intents;

import android.content.Context;
import android.content.Intent;

import test.com.activitysharedelementtransition.SingleImageActivity;

/**
 * Created by laetitia on 4/30/15.
 */
public class SingleImageIntent extends Intent {

    public static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";
    public static final String ARG_TRANSITION_IMAGE = "ARG_TRANSITION_IMAGE";

    public SingleImageIntent(Intent o) {
        super(o);
    }

    public SingleImageIntent(Context packageContext, int imageId, String transitionName) {
        super(packageContext, SingleImageActivity.class);
        putExtra(ARG_IMAGE_ID, imageId);
        putExtra(ARG_TRANSITION_IMAGE, transitionName);
    }

    public int getImageId() {
        return getIntExtra(ARG_IMAGE_ID, -1);
    }

    public String getTransitionName() {
        return getStringExtra(ARG_TRANSITION_IMAGE);
    }
}
