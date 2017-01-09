package com.maxi.waterpurifier.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.maxi.waterpurifier.R;

public class ImageRadioButton extends RadioButton {

    public static final int LEFT = 1, TOP = 2, RIGHT = 3, BOTTOM = 4;

    private int mHeight, mWidth;

    private Drawable mDrawable;

    private int mLocation;

    public ImageRadioButton(Context context) {
        this(context, null);
    }

    public ImageRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageTextView);
        mWidth = a.getDimensionPixelSize(R.styleable.ImageTextView_drawable_width, 0);
        mHeight = a.getDimensionPixelSize(R.styleable.ImageTextView_drawable_height, 0);
        mDrawable = a.getDrawable(R.styleable.ImageTextView_drawable_src);
        mLocation = a.getInt(R.styleable.ImageTextView_drawable_location, LEFT);
        a.recycle();
        drawDrawable();
    }

    public void drawDrawable() {

        if (mDrawable != null) {
            Bitmap bitmap = ((BitmapDrawable) mDrawable).getBitmap();
            Drawable drawable;
            if (mWidth != 0 && mHeight != 0) {
                drawable = new BitmapDrawable(getResources(), getBitmap(bitmap, mWidth, mHeight));
            } else {
                drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true));
            }
            switch (mLocation) {
                case LEFT:
                    this.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                    break;
                case TOP:
                    this.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                    break;
                case RIGHT:
                    this.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    break;
                case BOTTOM:
                    this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                    break;
            }
        }
    }

    public Bitmap getBitmap(Bitmap bm, int newWidth, int newHeight) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = (float) newWidth / width;
        float scaleHeight = (float) newHeight / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }
}
