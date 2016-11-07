package com.product.yuwei.bean.localbean;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.product.yuwei.R;


/**
 * Created by huwei on 15-1-31.
 */
public class FadingScrollView extends ScrollView {
    private static String TAG = "FadingScrollView";

    private ActionBar mActionBar;
    private Drawable mBgDrawable;

    private RelativeLayout fadingBar;

    private int fadingHeight;   //�����صĿؼ��߶�
    private int oldY;
    private int fadingOffset;

    public static final int ALPHA_START=20;
    public static final int ALPHA_END=255;

    public FadingScrollView(Context context) {
        this(context, null);
    }

    public FadingScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FadingScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

//        setOrientation(VERTICAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        fadingBar = (RelativeLayout) findViewById(R.id.global);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        fadingHeight = fadingBar.getMeasuredHeight()-fadingOffset;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int scrollY = getScrollY();

                Log.i(TAG, "scrollY:" + scrollY + " ;-fadingHeight" + fadingHeight);
                int y = (int) ev.getY();
                int deltaY = y - oldY;

                int willScrollY = scrollY - deltaY;

                if (willScrollY > fadingHeight) {
                    willScrollY = fadingHeight;
                }

                if (willScrollY < 0) {
                    willScrollY = 0;
                }

                scrollTo(0, willScrollY);
                updateActionBarAlpha(willScrollY*(ALPHA_END-ALPHA_START)/fadingHeight+ALPHA_START);
                oldY = y;

                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

    public void bindingActionBar(ActionBar actionBar) {
        mActionBar = actionBar;
    }

    public void setActionBarBgDrawable(Drawable bgDrawable) throws Exception{
        if(mActionBar==null){
            throw new Exception("Please try to binding the actionBar before set it's background.");
        }

        mBgDrawable = bgDrawable;
        mBgDrawable.setAlpha(ALPHA_START);
        mActionBar.setBackgroundDrawable(mBgDrawable);
    }
    
    public void setActionBarAlpha(int alpha) throws Exception{
        if(mActionBar==null||mBgDrawable==null){
            throw new Exception("acitonBar is not binding or bgDrawable is not set.");
        }
        mBgDrawable.setAlpha(alpha);
        mActionBar.setBackgroundDrawable(mBgDrawable);
    }
    
    void updateActionBarAlpha(int alpha){
        try {
            setActionBarAlpha(alpha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void setFadingOffset(int height){
        fadingOffset=height;
    }
}
