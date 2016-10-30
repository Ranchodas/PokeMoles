package com.su.poke;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class GameHelpView extends RelativeLayout{
	private ImageButton button_back ;
	
	public GameHelpView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout .game_help, this);
		button_back = (ImageButton)findViewById(R.id.button_back);
		button_back.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN : 
					v.setBackgroundResource(R.drawable .button_back_on);
					break;
				case MotionEvent.ACTION_UP : 
					v.setBackgroundResource(R.drawable .button);
					GameHelpView.this.setVisibility(View.GONE);
					break ;
				default : break ;
				}
				return true;
			}
			
		});
	}

}
