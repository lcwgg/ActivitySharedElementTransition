package test.com.activitysharedelementtransition;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import test.com.activitysharedelementtransition.intents.SharedElementTransitionIntent;

/**
 * Created by laetitia on 8/19/15.
 */
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.single_image)
    public void onSingleImageClick(){
        SharedElementTransitionIntent intent = new SharedElementTransitionIntent(this, SharedElementTransitionActivity.Choice.SINGLE);
        startActivity(intent);
    }


    @OnClick(R.id.fragment)
    public void onFargmentClick(){
        SharedElementTransitionIntent intent = new SharedElementTransitionIntent(this, SharedElementTransitionActivity.Choice.FRAGMENT);
        startActivity(intent);
    }
}
