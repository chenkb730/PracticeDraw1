package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点


        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(20, 20, mPaint);

        mPaint.reset();
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(100, 100, mPaint);


//        mPaint.reset();
//        mPaint.setStrokeWidth(20);
//        mPaint.setColor(Color.BLACK);
//        float[] pts = {50, 50, 100, 50, 150, 50, 50, 100, 100, 100, 150, 100, 50, 150, 100, 150, 150, 150};
//        canvas.drawPoints(pts, mPaint);


    }
}
