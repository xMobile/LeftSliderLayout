LeftSlideLayout
===========

LeftSlideLayout can slide from left. It is similar with SilderMenu. But It is only used in a FrameLayout. Also it is very simple to use. LeftSlideLayout has been used in many apps. It has two Listener Method to use. 

1、Listener of LeftSlideLayout ' State changed
public void OnSliderLayoutStateChanged(boolean bIsOpen);

2、Listener used for LeftSlideLayout to managing onInterceptTouchEvent.
LefeSliderLayout don't need to Intercept, when some subview need to use Left Gesture or Right Gesture.
public boolean OnSliderLayoutInterceptTouch(MotionEvent ev);
