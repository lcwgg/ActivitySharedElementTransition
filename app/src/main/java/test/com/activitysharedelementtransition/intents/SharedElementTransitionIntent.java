package test.com.activitysharedelementtransition.intents;

import android.content.Context;
import android.content.Intent;

import test.com.activitysharedelementtransition.SharedElementTransitionActivity;

/**
 * Created by laetitia on 8/19/15.
 */
public class SharedElementTransitionIntent extends Intent {

    public static final String ARG_CHOICE = "ARG_CHOICE";

    public SharedElementTransitionIntent(Context context, SharedElementTransitionActivity.Choice choice) {
        super(context, SharedElementTransitionActivity.class);
        putExtra(ARG_CHOICE, choice);
    }

    public SharedElementTransitionIntent(Intent o) {
        super(o);
    }

    public SharedElementTransitionActivity.Choice getChoice() {
        return (SharedElementTransitionActivity.Choice) getExtras().get(ARG_CHOICE);
    }
}
