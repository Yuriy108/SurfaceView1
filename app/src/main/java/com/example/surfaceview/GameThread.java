package com.example.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameThread extends Thread {
    private boolean runing=true;
    private SurfaceHolder surfaceHolder;
    Paint background=new Paint();
    Paint paint= new Paint();
    float x=100;
    float y=100;
    {background.setColor(Color.GREEN);
    background.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);

    }

    public GameThread(SurfaceHolder surfaceHolder,Context context) {
        this.surfaceHolder = surfaceHolder;
    }

    public void stopRun(){
        runing=false;
    }
    @Override
    public void run() {
        float vx=10;
        float vy=10;
        super.run();
        while (runing){
            x+=vx;
            y+=vy;
            
            Canvas canvas=surfaceHolder.lockCanvas();
            try{

            canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),background);
            canvas.drawCircle(x,y,100,paint);}

            finally { if(canvas!=null)
            {surfaceHolder.unlockCanvasAndPost(canvas);}

            }
        }


    }
}
