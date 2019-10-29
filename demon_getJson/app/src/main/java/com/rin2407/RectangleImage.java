package com.rin2407;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class RectangleImage extends ImageView {
    public RectangleImage(Context context) {
        super(context);
    }

    public RectangleImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectangleImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,widthMeasureSpec);
    }
}
