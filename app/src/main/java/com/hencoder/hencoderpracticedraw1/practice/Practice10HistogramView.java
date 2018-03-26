package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图


        Paint paint = new Paint();
        Path path = new Path();

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);


        path.moveTo(100, 100);
        path.lineTo(100, 500);
        path.lineTo(1000, 500);
        canvas.drawPath(path, paint);


        path = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        path.addRect(125, 475, 225, 500, Path.Direction.CCW);
        path.addRect(250, 400, 350, 500, Path.Direction.CCW);
        path.addRect(375, 400, 475, 500, Path.Direction.CCW);
        path.addRect(500, 300, 600, 500, Path.Direction.CCW);
        path.addRect(625, 200, 725, 500, Path.Direction.CCW);
        path.addRect(750, 100, 850, 500, Path.Direction.CCW);
        canvas.drawPath(path, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(15);
        canvas.drawText("1", 175, 520, paint);
        canvas.drawText("2", 300, 520, paint);
        canvas.drawText("3", 425, 520, paint);
        canvas.drawText("4", 550, 520, paint);
        canvas.drawText("5", 675, 520, paint);
        canvas.drawText("6", 800, 520, paint);

    }
}
