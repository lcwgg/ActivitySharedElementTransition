package test.com.activitysharedelementtransition.intents;

import android.content.Context;
import android.content.Intent;

import test.com.activitysharedelementtransition.ComposedActivity;

/**
 * Created by laetitia on 4/30/15.
 */
public class ComposedIntent extends Intent {

    public static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";
    public static final String ARG_IMAGE_TRANSITION_NAME = "ARG_IMAGE_TRANSITION_NAME";
    public static final String ARG_TEXTVIEW_CONTENT = "ARG_TEXTVIEW_CONTENT";

    public ComposedIntent(Intent o) {
        super(o);
    }

    public ComposedIntent(Context packageContext, int imageId, String transitionName, String textViewContent) {
        super(packageContext, ComposedActivity.class);
        putExtra(ARG_IMAGE_ID, imageId);
        putExtra(ARG_IMAGE_TRANSITION_NAME, transitionName);
        putExtra(ARG_TEXTVIEW_CONTENT, textViewContent);
    }

    public int getImageId() {
        return getIntExtra(ARG_IMAGE_ID, -1);
    }

    public String getTransitionName() {
        return getStringExtra(ARG_IMAGE_TRANSITION_NAME);
    }

    public String getTextViewContent(){
        return getStringExtra(ARG_TEXTVIEW_CONTENT);
    }

}
