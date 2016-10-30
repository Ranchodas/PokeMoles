package com.su.poke;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;



@SuppressLint("HandlerLeak")
public class PlayActivity extends Activity{
	private View game_set ;	
	private View time_roller;
	private View game_over;	
	private View game_next ;
	private View game_winner ;
	private ImageView levelPass ;
	private ImageView level ;
	private Thread produceMouse ;	
	private final static int[] SNUM ={R.drawable.lv1 , R.drawable.lv2 , R.drawable.lv3 , R.drawable.lv4 , R.drawable.lv5 , R.drawable.lv6}; 
	private final static int[] LNUM = {R.drawable.lv_pass1 , R.drawable.lv_pass2 ,  R.drawable.lv_pass3 , R.drawable.lv_pass4 , R.drawable.lv_pass5 , R.drawable.lv_pass6};
	
	static Handler mhandler;   
    static ThreadControl threadControl ; 
    static GameScores gameScores;  
    static GameLv gameLv ;
    static int lv ;
    
	@Override
	public void onBackPressed() {		
		game_set.setVisibility(View.VISIBLE);
		threadControl.pause();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);	
		threadControl = new ThreadControl();			
		
		setContentView(R.layout .game);	 		
		game_set = findViewById(R.id.game_set);
		time_roller = findViewById(R.id.time_item);	
		game_over = findViewById(R.id.game_over);	
		game_next = findViewById(R.id.game_next);
		game_winner =findViewById(R.id.game_winner);
		levelPass = (ImageView)game_next.findViewById(R.id.lv_pass);
		level = (ImageView)findViewById(R.id.lv);
		
		mhandler = new MyHandler();		
		gameScores = new GameScores(this);
		produceMouse = new ProduceMouse(this);	
		
		lv = getIntent().getIntExtra("game_lv", 1);	
		levelPass.setBackgroundResource(LNUM[lv-1]);
		level.setBackgroundResource(SNUM[lv-1]);
		GameLvPara gameLvPara = GameLvPara.gameLvPara ;
		gameLv = gameLvPara.getGameLvPara(lv);
	   gameScores.setGoal(gameLv.getGoal());
	   if(lv == 1) {
		   gameScores.setScores(0);
	   }else{
		   gameScores.setScores(GameScores.scores);
	   }
	}

	
	@Override
	protected void onStart() {
		produceMouse.start();
		super.onStart();		
	}

	@Override
	protected void onDestroy() {		
		super.onDestroy();		
	}

	
	 class MyHandler extends Handler{	
		 boolean endTime = false;
		@Override
		public void handleMessage(Message msg) {		
			super.handleMessage(msg);			 
			switch(msg.what){		
			case 1 :
					endTime = msg.getData().getBoolean("endTime");				
					if(!endTime){
						time_roller.invalidate();
					}else{
						if(gameScores.getScore() >= gameScores.getGoal()){
							if(lv < 6){
								game_next.setVisibility(View.VISIBLE);	
							}else{
								NumView num = (NumView)game_winner.findViewById(R.id.scores);
								num.setNum(gameScores.getScores());
								num.invalidate();
								game_winner.setVisibility(View.VISIBLE);
								
							}
						}else{
							 game_over.setVisibility(View.VISIBLE);		
						  }
					}
					break;
			default : break ;
			}			
		}		
	}	 
	
}
