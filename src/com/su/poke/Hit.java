package com.su.poke;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;

public class Hit implements OnClickListener{

	@Override
	public void onClick(View v) {
		if(PlayActivity.threadControl.pause || PlayActivity.threadControl.stop) return ;
		Mouse mouse = (Mouse)v ;
		if(!mouse.isDead()){
			mouse.setHit() ;
			Hammer hammer = new Hammer(ProduceMouse.context);	
			HitScore score = new HitScore(ProduceMouse.context , mouse.getName());			
			 
		    LayoutParams param_1 = new LayoutParams(LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		    param_1.leftMargin = (int)(mouse.getLeft() + mouse.getWidth()/2);
		    param_1.topMargin = (int)(mouse.getTop());	
		    hammer.setLayoutParams(param_1);		
		    
		    LayoutParams param_2 = new LayoutParams(LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		    param_2.leftMargin = (int)(mouse.getLeft() + mouse.getWidth()/2);
		    param_2.topMargin = (int)(mouse.getTop() - mouse.getWidth()/8);	
		    score.setLayoutParams(param_2);
		    
		    ProduceMouse.addView(hammer);				    
		    ProduceMouse.addView(score);
		    
		    PlayActivity.gameScores.HitScore(mouse.getName());
		}
		
	}

}
