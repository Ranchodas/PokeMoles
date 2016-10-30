package com.su.poke;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class Game extends RelativeLayout implements Runnable{	
	private Thread gameThread;
	
	public Game(Context context, AttributeSet attrs) {
		super(context, attrs);
	    gameThread = new Thread(this);
	    gameThread.start();
	    PlayActivity.threadControl.addThread(gameThread);		
	}
    
	@Override
	public void run() {		
	   Activity activity = (Activity)getContext();
	   while(!PlayActivity.threadControl.stop){
		   try{
		   if(PlayActivity.threadControl.pause) {
			   synchronized(ThreadControl.sLockObject){
				   ThreadControl.sLockObject.wait();
				   PlayActivity.threadControl.pause = false ;
			   }
		   }			
			   Thread.sleep(100);
		   }catch(InterruptedException e){}
		   activity.runOnUiThread(new Runnable(){
			@Override
			public void run() {			   
			     	int num = Game.this.getChildCount();
			     	for(int i = num-1 ; i >= 0 ; i --){
			     		View view = (View)Game.this.getChildAt(i);
			     		if(!((Life)view).isDead()){
			     			view.invalidate();
			     		}else{
			     			Game.this.removeViewAt(i);
			     		}			     		
			     	}			     
			     }   
		   });
	   }
	}
}
