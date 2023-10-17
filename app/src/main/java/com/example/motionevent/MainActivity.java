package com.example.motionevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = findViewById(R.id.activity_main);
        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                handleTouch(motionEvent);
                return true;
            }
        });
    }

    private void handleTouch(MotionEvent motionEvent){

        TextView textView1=findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);

        int pointerCount= motionEvent.getPointerCount();

        for (int i=0; i <pointerCount; i++){
            int x= (int) motionEvent.getX(i);
            int y= (int) motionEvent.getY(i);
            int id =motionEvent.getPointerId(i);
            int action =motionEvent.getActionMasked();
            int actionIndex= motionEvent.getActionIndex();
            String actionString;

            switch (action){
                case MotionEvent.ACTION_DOWN:
                    actionString = "Down";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "Up";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "Pointer Down";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "Pointer up";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "Move";
                    break;
                default:
                    actionString="";
            }
            String touchStatus ="Action: "+actionString+"\nIndex: "+actionIndex+"\n ID: "+id+"\nX:"+x+"\nY: "+y;

            if (id==0){
                textView1.setText(touchStatus);
            } else {
                textView2.setText(touchStatus);
            }


        }
    }
}