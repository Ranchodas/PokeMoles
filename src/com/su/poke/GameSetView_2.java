package com.su.poke;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class GameSetView_2 extends GameSetDialog{
     private ImageButton button_keep ;
     private ImageButton button_back ;
     
	public GameSetView_2(Context context, AttributeSet attrs) {
		super(context, attrs);
		button_keep = (ImageButton)findViewById(R.id.button_keep);
		button_back = (ImageButton)findViewById(R.id.button_back);
		
		button_keep.setVisibility(View.VISIBLE);		
		button_keep.setOnTouchListener(new ButtonTouch());
		button_back.setOnTouchListener(new ButtonTouch());
	}
	class ButtonTouch implements OnTouchListener{

		@SuppressLint("ClickableViewAccessibility")
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction()){
			case MotionEvent.ACTION_DOWN : 
				if(v.getTag().toString().equals("button_keep")){
					v.setBackgroundResource(R.drawable.button_keep_on);
				}else{
					v.setBackgroundResource(R.drawable.button_back_on);
				}			
				break;
			case MotionEvent.ACTION_UP :
				if(v.getTag().toString().equals("button_keep")){
					v.setBackgroundResource(R.drawable.button_keep);
			        PlayActivity.threadControl.restart();					        
				}else{	
					PlayActivity.threadControl.shutDown();
					 Intent intent = new Intent(GameSetView_2.this.getContext() , MainActivity.class);					
				     GameSetView_2.this.getContext().startActivity(intent);					     
				  }			
				GameSetView_2.this.setVisibility(View.GONE);
				break;
			default : break ;
			}
			return true;
		}
		
	}

}
