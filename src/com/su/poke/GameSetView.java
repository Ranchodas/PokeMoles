package com.su.poke;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;


public class GameSetView extends GameSetDialog{
	protected ImageButton button_back;
	protected ImageButton button_keep;
	
	public GameSetView(Context context, AttributeSet attrs) {
		super(context, attrs);	
		button_back = (ImageButton)findViewById(R.id.button_back);
		button_keep = (ImageButton)findViewById(R.id.button_keep);
		button_keep.setVisibility(View.GONE);
		
		button_back.setOnTouchListener(new ButtonOnTouchListener());
	}
	
	class ButtonOnTouchListener implements OnTouchListener{
		@SuppressLint("ClickableViewAccessibility")
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction()){
			case MotionEvent.ACTION_DOWN :
                 button_back.setBackgroundResource(R.drawable.button_back_on);
                  break ;
			case MotionEvent.ACTION_UP : 
					button_back.setBackgroundResource(R.drawable .button);
					GameSetView.this.setVisibility(View.GONE);							
					break ;
			default : break ;
			}
			return true;
		}		
	}
}
