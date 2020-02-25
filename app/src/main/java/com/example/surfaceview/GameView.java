package com.example.surfaceview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }
    GameThread gameThread;

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
         gameThread=new GameThread(getHolder(),getContext());
         gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        gameThread.stopRun();
        boolean f=true;
        while (f){
            try {
                gameThread.join();
                f=false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
