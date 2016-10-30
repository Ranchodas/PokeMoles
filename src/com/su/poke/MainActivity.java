package com.su.poke;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView button_new = null ;
    private ImageView button_set= null ;
    private ImageView button_help = null ;
    private ImageView button_exit = null ;
    private View dialog = null;
    private View dialog_help = null ;      

   static Context context ; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		context = this.getApplicationContext();
		
		setContentView(R.layout.activity_main);
		button_new = (ImageView)findViewById(R.id.button_new);
		button_set = (ImageView)findViewById(R.id.button_set);
		button_help = (ImageView)findViewById(R.id.button_help);
		button_exit = (ImageView)findViewById(R.id.button_exit);	
		dialog = findViewById(R.id.dialog);
		dialog_help = findViewById(R.id.dialog_help);
		
		button_new.setOnTouchListener(new TouchListener());
		button_set.setOnTouchListener(new TouchListener());
		button_help.setOnTouchListener(new TouchListener());
		button_exit.setOnTouchListener(new TouchListener());			
	}
	
@Override
	protected void onDestroy() {
	    BitmapResourcesFactory.recycleAll();
		super.onDestroy();
	}

class TouchListener implements View.OnTouchListener{
	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			switch(v.getTag().toString()){
			case "button_new" :
				v.setBackgroundResource(R.drawable.button_new_on);					
				break ;
			case "button_set" : 
				v.setBackgroundResource(R.drawable.button_set_on);			
				break;
			case "button_help" : 
				v.setBackgroundResource(R.drawable.button_help_on);
				break;
			case "button_exit" : 	
				v.setBackgroundResource(R.drawable.button_exit_on);			
				break;
			default : break;
			}	
			
		}else if(event.getAction() == MotionEvent.ACTION_UP){
			switch(v.getTag().toString()){
			case "button_new" :
				v.setBackgroundResource(R.drawable.button_new);
				Intent intent = new Intent(MainActivity.this , PlayActivity.class);
				intent.putExtra("game_lv", 1);
				MainActivity.this.startActivity(intent);	
				overridePendingTransition(android.R.anim.fade_in , android.R.anim.fade_out);
				break ;
			case "button_set" : 
				v.setBackgroundResource(R.drawable.button_set);
				dialog.setVisibility(View.VISIBLE);							
				break;
			case "button_help" : 
				v.setBackgroundResource(R.drawable.button_help);
				dialog_help.setVisibility(View.VISIBLE);				
				break;
			case "button_exit" : 	
				v.setBackgroundResource(R.drawable.button_exit);
				MainActivity.this.finish();
				break;
			default : break;
			}	
			
		}
		return true;
	}
	
}

}
