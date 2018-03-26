package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形


        Paint paint = new Paint();

        Path path = new Path();

        paint.setStyle(Paint.Style.STROKE);
//        RectF rectF = new RectF();
//        rectF.set(200, 200, 400, 400);
//        path.addArc(rectF, -225, 225);
//
//        rectF.set(400, 200, 600, 400);
//        path.arcTo(rectF, -180, 225, false);
//        path.lineTo(400, 542);
//
//        path.close();


//        RectF rectF = new RectF();
//        paint.setStyle(Paint.Style.FILL);
//        rectF.set(200, 200, 400, 400);
//        path.addCircle(200, 200, 200, Path.Direction.CW);
//        path.addCircle(400, 200, 200, Path.Direction.CW);
//        path.setFillType(Path.FillType.EVEN_ODD);
//        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(200, 100);
        path.lineTo(75, 500);
        path.lineTo(400, 225);
        path.lineTo(0, 225);
        path.lineTo(375, 500);
        path.close();

        canvas.drawPath(path, paint);


    }
}
