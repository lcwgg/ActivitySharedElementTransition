# ActivitySharedElementTransition
Examples of shared element transitions between activities (minimum version : Lollipop)

All examples are done with the explode activity transition. More details about activity transitions [here](https://github.com/lcwgg/ActivityTransition).

More about shared elements transition on [Android developers website](https://developer.android.com/training/material/animations.html#Transitions).


All examples can be done in xml or in java code. However, if you decide to define the transitions in java, all code concerning the transition must be present in both parent activity and target activity. To enabled the transition, add:

```xml
<item name="android:windowActivityTransitions">true</item>
<item name="android:windowContentTransitions">true</item>
```
Or programmatically in both parent activity and target activity : 

```java
getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
```

To set up a transition, Android provides these shared element transition:

* `changeBounds` - Animates the changes in layout bounds of target views.
* `changeClipBounds` - Animates the changes in clip bounds of target views.
* `changeTransform` - Animates the changes in scale and rotation of target views.
* `changeImageTransform` - Animates changes in size and scale of target images.

When using xml, all these transition must be added in a *transition* folder created inside the *res* folder.
Example of `changeBound`
```xml
<?xml version="1.0" encoding="utf-8"?>
<transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
    <targets>
	<!-- Exclude the status bar and the navigation bar from the animation -->
        <target android:excludeId="@android:id/statusBarBackground" />
        <target android:excludeId="@android:id/navigationBarBackground" />
    </targets>
    <changeBounds>
	<!-- Combine the change bound effect with an arc movement -->
	<!-- the animation will follow a circle arc path -->
        <arcMotion
            android:maximumAngle="90"
            android:minimumHorizontalAngle="15"
            android:minimumVerticalAngle="0" />
    </changeBounds>
</transitionSet>
```

## Scaling transition
This transition is the default one. you don't need to define anything.
This transition can also be achieved by combining `changeBound` and `changeImageTransform` effect :
```xml
<changeBounds/>
<changeImageTransform />
```
Simple image | With a fragment
------------ |  -------------
![Demo](images/githubactivitysharedtransitionscale.gif) | ![Demo](images/githubactivitysharedtransitionsscalefragment.gif)

`changeImageTransform` is coupled with `changeBound` to have the correct bound animation or all animation starts from top left corner of the screen, which is not wanted in a list. Of course, `changeBound` is not needed if the transition is a single animation that needs to start from the top left cornerof the screen.

## Sliding transition
This effect can be achieved like that:
```xml
<changeBounds/>
<changeTransform />
```
or by defining the `autoTransition`:
```xml
<autoTransition/>
```
Simple image | With a fragment
------------ |  -------------
![Demo](images/githubactivitysharedtransitionslide.gif) | ![Demo](images/githubactivitysharedtransitionslidefragment.gif)

`changeTransform` is coupled with `changeBound` to have the correct bound animation or the image only appears as if it was a mere fade transition. 

## Custom transition
You can customized the transition with all the predefined option like `arcMotion`, `pathMotion`, `recolor`.
Here is an example with `arcMotion`

Simple image | With a fragment
------------ |  -------------
![Demo](images/githubactivitysharedtransitioncustom.gif) | ![Demo](images/githubactivitysharedtransitioncustomfragment.gif)

## Unknown bug
I was forced to set the fragment transaction inside a `postDelayed()` method, it seems the transacion timing is not right which prevent the fragment entre transition not to appear correctly.

