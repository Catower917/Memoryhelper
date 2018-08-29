package com.example.user.memoryhelper;


import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;

public class Paint extends Activity implements OnClickListener{

    Button draw_btn;
    Button end_btn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        draw_btn = (Button) findViewById(R.id.draw_btn);
        end_btn = (Button) findViewById(R.id.end_btn);
        draw_btn.setOnClickListener(this);
        end_btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent i = null;

        switch(v.getId()) {
            case R.id.draw_btn:
                i = new Intent(this, DrawActivity.class);
                finish();
                startActivity(i);
                break;
            case R.id.end_btn:
                finish();
                break;
        }
    }
}



