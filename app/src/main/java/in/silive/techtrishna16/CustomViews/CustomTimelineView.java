package in.silive.techtrishna16.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import in.silive.techtrishna16.R;

/**
 * Created by AKG002 on 27-01-2016.
 */
public class CustomTimelineView extends View {
    private static final float RATIO = 6f / 4.5f;
    Paint threadPaint1, threadPaint2, circlePaint, squarePaint;
    int direction = 0;
    Context c;

    public CustomTimelineView(Context context) {
        super(context);
        c = context;
        init();
    }

    public CustomTimelineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        c = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTimelineView, 0, 0);
        try {
            direction = a.getInteger(R.styleable.CustomTimelineView_direction, 0);
        } finally {
            a.recycle();
        }
        init();
    }

    public CustomTimelineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTimelineView, 0, 0);
        c = context;
        try {
            direction = a.getInteger(R.styleable.CustomTimelineView_direction, 0);
        } finally {
            a.recycle();
        }
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width < height)
            height = (int) (width * 4.5 / 6);
        else
            width = (int) (height * 6 / 4.5);

        Path square = new Path();
        Path thread = new Path();

        if (direction == 1) {
            square.moveTo(0, 0);
            square.lineTo(width * 1.25f / 6f, 0);
            square.lineTo(width * 3.5f / 6f, height * 2.25f / 4.5f);
            square.lineTo(width * 1.25f / 6f, height);
            square.lineTo(0, height);
            square.lineTo(0, 0);
            square.close();
            square.moveTo(width * 4.75f / 6f, 0);
            square.lineTo(width, 0);
            square.lineTo(width, height * 1.25f / 4.5f);
            square.lineTo(width * 4.75f / 6f, 0);
            square.close();
            square.moveTo(width * 4.75f / 6f, height);
            square.lineTo(width, height);
            square.lineTo(width, height * 3.25f / 4.5f);
            square.lineTo(width * 4.75f / 6f, height);
            square.close();

            thread.moveTo(width / 2, 0);
            thread.lineTo(width * 3.5f / 6f, height * 0.75f / 4.5f);
            thread.lineTo(width * 3.5f / 6f, height * 3.75f / 4.5f);
            thread.lineTo(width / 2, height);
        } else {
            square.moveTo(width, 0);
            square.lineTo(width * 4.75f / 6f, 0);
            square.lineTo(width * 2.5f / 6f, height * 2.25f / 4.5f);
            square.lineTo(width * 4.75f / 6f, height);
            square.lineTo(width, height);
            square.lineTo(width, 0);
            square.close();
            square.moveTo(width - width * 4.75f / 6f, 0);
            square.lineTo(0, 0);
            square.lineTo(0, height * 1.25f / 4.5f);
            square.lineTo(width - width * 4.75f / 6f, 0);
            square.close();
            square.moveTo(width - width * 4.75f / 6f, height);
            square.lineTo(0, height);
            square.lineTo(0, height * 3.25f / 4.5f);
            square.lineTo(width - width * 4.75f / 6f, height);
            square.close();

            thread.moveTo(width / 2, 0);
            thread.lineTo(width * 2.5f / 6f, height * 0.75f / 4.5f);
            thread.lineTo(width * 2.5f / 6f, height * 3.75f / 4.5f);
            thread.lineTo(width / 2, height);
        }

        canvas.drawPath(square, squarePaint);
        canvas.drawPath(thread, threadPaint2);
        canvas.drawPath(thread, threadPaint1);
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        if (width == 0)
            width = 720;
        int height = getMeasuredHeight();
        if (height == 0)
            height = 540;
        int widthWithoutPadding = width - getPaddingLeft() - getPaddingRight();
        int heigthWithoutPadding = height - getPaddingTop() - getPaddingBottom();

        int maxWidth = (int) (heigthWithoutPadding * RATIO);
        int maxHeight = (int) (widthWithoutPadding / RATIO);

        if (widthWithoutPadding > maxWidth) {
            width = maxWidth + getPaddingLeft() + getPaddingRight();
        } else {
            height = maxHeight + getPaddingTop() + getPaddingBottom();
        }

        setMeasuredDimension(width, height);
    }

    void init() {
        Log.d("CustomTimelineView", "View init");

        threadPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        threadPaint1.setColor(Color.parseColor("#66c2ff"));
        threadPaint1.setStyle(Paint.Style.STROKE);
        threadPaint1.setStrokeWidth(6);

        threadPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        threadPaint2.setColor(Color.parseColor("#0099ff"));
        threadPaint2.setStyle(Paint.Style.STROKE);
        threadPaint2.setStrokeWidth(9);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.parseColor("#007acc"));

        squarePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        squarePaint.setColor(Color.parseColor("#1a1a1a"));
        squarePaint.setColor(Color.parseColor("#404040"));

    }


}
