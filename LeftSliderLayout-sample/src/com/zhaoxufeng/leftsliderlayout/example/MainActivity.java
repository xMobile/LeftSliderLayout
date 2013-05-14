package com.zhaoxufeng.leftsliderlayout.example;

import com.zhaoxufeng.leftsliderlayout.R;
import com.zhaoxufeng.leftsliderlayout.lib.LeftSliderLayout;
import com.zhaoxufeng.leftsliderlayout.lib.LeftSliderLayout.OnLeftSliderLayoutStateListener;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity implements OnLeftSliderLayoutStateListener, OnClickListener {

	LeftSliderLayout leftSliderLayout;
	View horizontalScrollView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        horizontalScrollView = (View) findViewById(R.id.main_horizontal_scroll_view);
        leftSliderLayout = (LeftSliderLayout) findViewById(R.id.main_slider_layout);
        leftSliderLayout.setOnLeftSliderLayoutListener(this);
    }

	@Override
	public void OnLeftSliderLayoutStateChanged(boolean bIsOpen) {
		if (bIsOpen) {
			Toast.makeText(this, "LeftSliderLayout is open!", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "LeftSliderLayout is close!", Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public boolean OnLeftSliderLayoutInterceptTouch(MotionEvent ev) {
		if (isViewTouched(horizontalScrollView, ev.getRawX(), ev.getRawY())) {
			return false;
		}
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_btn_enable: {
			leftSliderLayout.enableSlide(true);
			break;
		}
		
		case R.id.main_btn_disable: {
			leftSliderLayout.enableSlide(false);
			break;
		}

		case R.id.main_btn_open: {
			leftSliderLayout.open();
			break;
		}

		case R.id.main_btn_close: {
			leftSliderLayout.close();
			break;
		}
		
		case R.id.main_btn_below: {
			Toast.makeText(this, "btnBelow is clicked!", Toast.LENGTH_SHORT).show();
			break;
		}

		default:
			break;
		}
	}
	
	private boolean isViewTouched(View view, float fX, float fY) {
		int location[] = new int[2];
		view.getLocationOnScreen(location);

		int nStartY = location[1];
		int nEndY = location[1] + view.getHeight();

		int nStartX = location[0];
		int nEndX = location[0] + view.getWidth();

		if ((fY >= nStartY && fY < nEndY) && (fX > nStartX && fX < nEndX)) {
			return true;
		}

		return false;
	}
    
}
