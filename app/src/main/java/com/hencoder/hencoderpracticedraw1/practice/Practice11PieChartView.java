package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice11PieChartView extends View {

    private final List<Integer> list = new ArrayList<>();
    private Paint paint;
    private Paint linePaint;
    private Paint textPaint;
    private Paint titlePaint;
    private RectF rectF;
    private RectF rectF2;
    private int[] colors = {Color.BLUE, Color.BLACK, Color.WHITE, Color.RED, Color.GREEN, Color.YELLOW, Color.CYAN};
    private float count;
    private float maxNum;
    private Path path = new Path();

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        Random random = new Random();
        int c = 8;
        for (int i = 1; i < c; i++) {
            int r = random.nextInt(c) + 1;
            maxNum = maxNum > r ? maxNum : r;
            count += r;
            list.add(r);//[1,8)
        }

        paint = new Paint();
        paint.setAntiAlias(true);

        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth(3);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.WHITE);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(24);
        textPaint.setColor(Color.WHITE);

        titlePaint = new Paint();
        titlePaint.setAntiAlias(true);
        titlePaint.setTextSize(36);
        titlePaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        int width = getWidth();
        int height = getHeight();
        int x = width / 2;
        int y = height / 2;
        //半径
        int radius = 300;
        //最大扇形rect偏移量
        int off = 20;


        //1.确定普通扇形区域
        //这边画出的区域是一个圆，半径为600
        if (rectF == null) {
            rectF = new RectF(x - radius, y - radius, x + radius, y + radius);
        }

        //画扇形
        float percent;
        float startAngle = 0;
        float sweepAngle = 0;
        float halfAngel = 0;
        int intervalAngle = 2;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            percent = list.get(i) / count;
            startAngle += sweepAngle + intervalAngle;
            sweepAngle = (360 - intervalAngle * size) * percent;
            halfAngel = (startAngle * 2 + sweepAngle) / 2;
            String text = String.valueOf(list.get(i));

            paint.setColor(colors[i]);

            //计算普通扇形中间点的坐标
            float pointStartX = (float) (x + radius * Math.cos(halfAngel * Math.PI / 180));
            float pointStartY = (float) (y + radius * Math.sin(halfAngel * Math.PI / 180));
            float pointStopX = (float) (x + (radius + 50) * Math.cos(halfAngel * Math.PI / 180));
            float pointStopY = (float) (y + (radius + 50) * Math.sin(halfAngel * Math.PI / 180));

            //计算最大扇形的圆心点
            float maxCenterX = (float) (x + off * Math.cos(halfAngel * Math.PI / 180));
            float maxCenterY = (float) (y + off * Math.sin(halfAngel * Math.PI / 180));
            //计算最大扇形的中心点
            float maxPointStartX = (float) (x + (radius + off) * Math.cos(halfAngel * Math.PI / 180));
            float maxPointStartY = (float) (y + (radius + off) * Math.sin(halfAngel * Math.PI / 180));
            float maxPointStopX = (float) (x + (radius + off + 50) * Math.cos(halfAngel * Math.PI / 180));
            float maxPointStopY = (float) (y + (radius + off + 50) * Math.sin(halfAngel * Math.PI / 180));

            //确定最大扇形的区域
            if (rectF2 == null && maxNum == list.get(i)) {
                rectF2 = new RectF(maxCenterX - radius, maxCenterY - radius, maxCenterX + radius, maxCenterY + radius);
                canvas.drawArc(rectF2, startAngle, sweepAngle, true, paint);
                //画最大扇形的标线
                drawLineAndText(canvas, text, halfAngel, maxPointStartX, maxPointStartY, maxPointStopX, maxPointStopY);
                continue;
            }

            //画扇形的标线
            drawLineAndText(canvas, text, halfAngel, pointStartX, pointStartY, pointStopX, pointStopY);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
        }

        //画title
        String title = "饼图";
        float titleSize = titlePaint.measureText(title);
        canvas.drawText(title, x - titleSize / 2, height - 10, titlePaint);
    }

    private void drawLineAndText(Canvas canvas, String text, float halfAngel, float startX,
                                 float startY, float stopX, float stopY) {
        int offset;
        int off;
        path.moveTo(startX, startY);
        path.lineTo(stopX, stopY);
        if (halfAngel < 90 || halfAngel > 270) {
            offset = 20;
            off = 50;
            textPaint.setTextAlign(Paint.Align.RIGHT);
        } else {
            offset = -20;
            off = -50;
            textPaint.setTextAlign(Paint.Align.LEFT);
        }
        path.rLineTo(offset, 0);
        canvas.drawPath(path, linePaint);
        canvas.drawText(text, stopX + offset + off, stopY, textPaint);
    }
}
