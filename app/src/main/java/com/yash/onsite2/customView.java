package com.yash.onsite2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class customView extends View {
    Paint p;
    public customView(Context context) {
        super(context);
        init();
    }

    private void init() {
        p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.YELLOW);
    }

    public customView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public customView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
    }
}
