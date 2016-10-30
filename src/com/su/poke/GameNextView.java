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

public class GameNextView extends RelativeLayout{
	private ImageButton button_next;
	
	public GameNextView(Context context, AttributeSet attrs) {
		super(context, attrs);	
		LayoutInflater.from(context).inflate(R.layout.game_next, this);	
		button_next = (ImageButton)findViewById(R.id.button_next);
		button_next.setOnTouchListener(new View.OnTouchListener() {
			
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN : 
					v.setBackgroundResource(R.drawable.button_next_on);
					break ;
				case MotionEvent.ACTION_UP : 					
					v.setBackgroundResource(R.drawable.button_next) ;
					PlayActivity.threadControl.shutDown();
					Intent intent = new Intent(v.getContext() , PlayActivity.class) ;
					intent.putExtra("game_lv", PlayActivity.lv+1);
					v.getContext().startActivity(intent);
					((Activity)v.getContext()).finish();
					break ;
				default : break ;
				}
				return true;
			}
		});
	}

}
