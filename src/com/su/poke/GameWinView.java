package com.su.poke;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class GameWinView extends RelativeLayout{
	private ImageButton button_back ;
	private ImageButton button_restart;
	
	public GameWinView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.game_win, this);
		button_back = (ImageButton)findViewById(R.id.button_back);
		button_restart = (ImageButton)findViewById(R.id.button_restart);
		
		button_back.setOnTouchListener(new TouchListener());
		button_restart.setOnTouchListener(new TouchListener());
	}
	class TouchListener implements OnTouchListener{
		@SuppressLint("ClickableViewAccessibility")
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction()){
			case  MotionEvent.ACTION_DOWN: 
				if(v.getTag().toString().equals("button_back")){
					v.setBackgroundResource(R.drawable .button_back_on );
				}else{
					v.setBackgroundResource(R.drawable .button_restart_on );					
				}
				break;
			case  MotionEvent.ACTION_UP : 
				if(v.getTag().toString().equals("button_back")){
					v.setBackgroundResource(R.drawable.button);				
					getContext().startActivity(new Intent(getContext() , MainActivity.class));
					((Activity)getContext()).finish();	
				}else{
					PlayActivity.threadControl.shutDown();					
					
					v.setBackgroundResource(R.drawable .button_restart);	
					Intent intent = new Intent(getContext(), PlayActivity.class);					
					getContext().startActivity(intent);	
					((PlayActivity)getContext()).finish();
						
				}
				GameWinView.this.setVisibility(View.GONE);
				break ;
			default : break ;
			}		
			return true;
		}
		
	}

}
