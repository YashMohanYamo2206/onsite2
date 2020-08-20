package com.yash.onsite2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;


import androidx.annotation.Nullable;

public class customView extends View {
    Paint p;
    public RectF rectF;
    RelativeLayout relativeLayout;
    float height = 500f, width = 600f;
    int corner = 5, side = 0;

    public customView(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.relativeLayout = relativeLayout;
        init();
    }

    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(rectF, p);
        postInvalidate();
    }

    private void init() {
        p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.BLACK);
        rectF = new RectF();
        rectF.left = 1000 / 3f;
        rectF.top = 2000 / 3f;
        rectF.bottom = rectF.top + height;
        rectF.right = rectF.left + width;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (corner == 5) {
                    rectF.left = event.getX() - width / 2;
                    rectF.right = event.getX() + width / 2;
                    rectF.top = event.getY() - height / 2;
                    rectF.bottom = event.getY() + height / 2;
                    postInvalidate();
                } else if (corner == 1) {
                    rectF.top = event.getY();
                    rectF.left = event.getX();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (corner == 2) {
                    rectF.top = event.getY();
                    rectF.right = event.getX();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (corner == 3) {
                    rectF.bottom = event.getY();
                    rectF.right = event.getX();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (corner == 4) {
                    rectF.bottom = event.getY();
                    rectF.left = event.getX();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (side == 1) {
                    rectF.top = event.getY();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (side == 2) {
                    rectF.left = event.getX();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (side == 3) {
                    rectF.bottom = event.getY();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                } else if (side == 4) {
                    rectF.right = event.getX();
                    width = Math.abs((rectF.right - rectF.left));
                    height = Math.abs((rectF.bottom - rectF.top));
                    postInvalidate();
                }
                return true;
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                if (x > rectF.left + 150f && x < rectF.right - 150f && y > rectF.top + 150f && y < rectF.bottom - 150f) {
                    corner = 5;
                    return true;
                } else if (x > rectF.left && x < rectF.left + 150f && y > rectF.top && y < rectF.top + 150f) {
                    corner = 1;
                    return true;
                } else if (x > rectF.right - 150f && x < rectF.right && y > rectF.top && y < rectF.top + 150f) {
                    corner = 2;
                    return true;
                } else if (x > rectF.right - 150f && x < rectF.right && y > rectF.bottom - 150f && y < rectF.bottom) {
                    corner = 3;
                    return true;
                } else if (x > rectF.left && x < rectF.left + 150f && y > rectF.bottom - 150f && y < rectF.bottom) {
                    corner = 4;
                    return true;
                } else if (x > rectF.left + 150f && x < rectF.right - 150f && y > rectF.top && y < rectF.top + 150f) {
                    side = 1;
                    return true;
                } else if (x > rectF.right - 150f && x < rectF.right && y > rectF.top + 150f && y < rectF.bottom - 150f) {
                    side = 2;
                    return true;
                } else if (x > rectF.left + 150f && x < rectF.right - 150f && y > rectF.bottom - 150f && y < rectF.bottom) {
                    side = 3;
                    return true;
                } else if (x > rectF.left && x < rectF.left + 150f && y > rectF.top + 150f && y < rectF.bottom - 150f) {
                    side = 4;
                    return true;
                }
        }
        return value;
    }
}
