package com.example.user.memoryhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DrawActivity extends Activity{
    private RelativeLayout mla;


    Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw);

        Drawable alpha = ((ImageView)findViewById(R.id.ivp1)).getDrawable();
        alpha.setAlpha(250);
// 투명도 설정


        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DrawActivity.this, com.example.user.memoryhelper.Paint.class);
                finish();
                startActivity(i);
            }
        });
    }


    public void onea(View v) {
        Intent intent003 = new Intent(this, DrawActivity.class);
        startActivity(intent003);
    }//지우기


    public void onbb(View v) {

        mla = (RelativeLayout) findViewById(R.id.mla);

        mla.setBackgroundColor(Color.rgb(255,0,0));


    }//지우기
}



class Paper extends View {

    Paint paint = new Paint();
    Path path = new Path();

    float y;
    float x;

    public Paper(Context context) {
        super(context);
    }

    public Paper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        paint.setStrokeWidth(40);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawPath(path, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();

        return true;
    }


}