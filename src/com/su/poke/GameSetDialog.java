package com.su.poke;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameSetDialog extends RelativeLayout{
	protected static ImageView audio ;
	protected static ImageView backgroundAudio;
	
	public GameSetDialog(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.game_set, this);
		audio = (ImageView)findViewById(R.id.audio);
		backgroundAudio = (ImageView)findViewById(R.id.background_audio);		

		audio.setOnClickListener(new BoxCheckedListener());
		backgroundAudio.setOnClickListener(new BoxCheckedListener());
	}
	class BoxCheckedListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			
			if(v.getContentDescription().toString().equals("on")){			
				((ImageView)v).setImageResource(R.drawable .off);
				v.setContentDescription("off");
			}else{
				((ImageView)v).setImageResource(R.drawable .on);		
				v.setContentDescription("on");
			}
		
			switch(v.getTag().toString()){
			case "audio" : 			
				break ;
			case "background_audio" : 
				break ;
			default : break ;
			}
			
		}
		
	}
}
