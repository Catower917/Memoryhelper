

package com.example.user.memoryhelper;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Drawable drawable = getResources().getDrawable(R.drawable.sample4);

        ImageView imageView = (ImageView) findViewById(R.id.ivp);
        imageView.setImageDrawable(drawable);


    }

    public void oncc(View v) {
        Intent intent001 = new Intent(this, Help.class);
        startActivity(intent001);
    }//팁으로가는거

}
