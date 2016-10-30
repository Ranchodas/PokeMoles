package com.su.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class TimeRoller extends View implements Runnable {
    private Bitmap timeItem;
    private Paint paint;
    private Thread timeRollerThread;
    private  final int progress ;  

	public TimeRoller(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		paint = new Paint();
		timeItem = BitmapFactory.decodeResource(context.getResources(), R.drawable.time_item);	
		progress= timeItem.getWidth()/60;	
		timeRollerThread = new Thread(this);		
		PlayActivity.threadControl.addThread(timeRollerThread);
		timeRollerThread.start();
	}
	
	@Override
	public void run() {	

		while(!PlayActivity.threadControl.stop){
			if(PlayActivity.threadControl.pause) {
				try{
					synchronized(ThreadControl.sLockObject){
						ThreadControl.sLockObject.wait();
						PlayActivity.threadControl.pause = false ;
					}
					}catch(InterruptedException e){						
					}				
				continue ;
			}
		    if(timeItem.getWidth() > progress){			
		    	try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
				}			  
				timeItem = Bitmap.createBitmap(timeItem, 0 ,  0 , timeItem.getWidth()-progress, timeItem.getHeight());
			}else{
				PlayActivity.threadControl.stop = true;					
		    }			   
			  Message m = PlayActivity.mhandler.obtainMessage();
			  Bundle data = new Bundle();
			  data.putBoolean("endTime", PlayActivity.threadControl.stop);
			  m.what = 1 ;
			  m.setData(data);				 
			  PlayActivity.mhandler.sendMessage(m);
	    }  	
	}
	
	@Override
	protected void onDraw(Canvas canvas) {		
		super.onDraw(canvas);		
		canvas.drawBitmap(timeItem , 0 , getHeight()-17,  paint);	
	}	

}
