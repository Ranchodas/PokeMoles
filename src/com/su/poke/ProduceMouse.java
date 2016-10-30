package com.su.poke;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ProduceMouse extends Thread{	
	public static Context context ;
	private  Set<Mouse> set = new HashSet<Mouse>();
	private Random random = new Random();
	private static  int[][] POSITION = new int[9][2];	
	private static final int[][] ID = {{R.dimen.left_00 , R.dimen.top_00} , {R.dimen.left_01 , R.dimen.top_01} ,{R.dimen.left_02 , R.dimen.top_02} , 
		                                                  {R.dimen.left_10 , R.dimen.top_10} ,  {R.dimen.left_11 , R.dimen.top_11} , {R.dimen.left_12 , R.dimen.top_12} , 
		                                                  {R.dimen.left_20 , R.dimen.top_20} , {R.dimen.left_21 ,  R.dimen.top_21} , {R.dimen.left_22 , R.dimen.top_22}};
	
	
	public ProduceMouse(Context context){
		 ProduceMouse.context = context;		
		 PlayActivity.threadControl.addThread(this);
		 for(int i = 0 ; i < 9 ; i ++){
			 POSITION[i][0] =  (int)context.getResources().getDimension(ID[i][0]);
			 POSITION[i][1] = (int)context.getResources().getDimension(ID[i][1]);
		 }
	}
	public static void addView(final View v){
		Activity activity = ((Activity)context);
		final RelativeLayout game = (RelativeLayout)activity.findViewById(R.id.game);
		activity.runOnUiThread(new Runnable(){
			@Override
			public void run() {				
				game.addView(v);
			}
			
		});
	}
	@Override
	public void run() {		
		while(!PlayActivity.threadControl.stop){
			try{
				if(PlayActivity.threadControl.pause){
					synchronized(ThreadControl.sLockObject){
						ThreadControl.sLockObject.wait();
						PlayActivity.threadControl.pause = false ;
					}
				}
				Thread.sleep(2000);
				int num = random.nextInt(2)+2;
				while(num-- > 0){		
					int n = random.nextInt(11);
					Mouse mouse  = new Mouse(context , MouseResources.CRAZEMOUSE);
					if(n < PlayActivity.gameLv.getP2()&& n >= PlayActivity.gameLv.getP1()){
						mouse = new Mouse(context , MouseResources.PRETTYMOUSE);
					}else if(n < PlayActivity.gameLv.getP3() && n >= PlayActivity.gameLv.getP2()){
						mouse = new Mouse(context , MouseResources.KINGMOUSE);
					}else if(n < PlayActivity.gameLv.getP4() && n >= PlayActivity.gameLv.getP3()){
						mouse = new Mouse(context , MouseResources.RABBIT);
					}else if(n < PlayActivity.gameLv.getP5() && n >= PlayActivity.gameLv.getP4()){
						mouse = new Mouse(context , MouseResources.ANGLEMOUSE);
					}
					
				    LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
				    int i = random.nextInt(9);
				    params.leftMargin = POSITION[i][0];
				    params.topMargin = POSITION[i][1];
				    mouse.setLayoutParams(params);
				    mouse.setOnClickListener(new Hit());				    
				    set.add(mouse);
				}
				Iterator<Mouse> iterator = set.iterator();
				while(iterator.hasNext()){		
					Mouse m = iterator.next();					
					if(m.isDead()){
						iterator.remove();
						continue;
					}					
					if(m.getParent() == null){						
						addView(m);
					}
					
				}				
				
			}catch(InterruptedException e){				
			}				
		}		
	}
}
