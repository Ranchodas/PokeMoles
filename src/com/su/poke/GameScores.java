package com.su.poke;

import android.app.Activity;
import android.content.Context;

public class GameScores {		
	    public static int scores ;
		private  int goal ;	
		private  int score;		
		private MessageView message ;
		private GameOverView gameOver ;
		private GameNextView gameNext ;
		
		public GameScores(Context context){
			Activity activity = (Activity)context ;
			message = (MessageView)activity.findViewById(R.id.message);			
			gameOver = (GameOverView)activity.findViewById(R.id.game_over);
			gameNext = (GameNextView)activity.findViewById(R.id.game_next) ;		
			setScore(score);	
		}
		
		public void HitScore(String name){
			switch(name){
			case MouseResources.CRAZEMOUSE : 
				score += 100 ;
				scores += 100 ;
				break ;
			case MouseResources.KINGMOUSE : 
				score += 500 ;
				scores += 500 ;
				break;
			case MouseResources.ANGLEMOUSE :
				int add =(int) ((int) score*0.2) ;
				score += add ;
				scores += add ;				
				break ;
			case MouseResources.PRETTYMOUSE : 
				score -= 100 ;
				scores -= 100 ;
				break ;
			case MouseResources.RABBIT : 
				int m = score/2 ;
				scores += score - m ;
				score = m ;
				break ;
			default : break;
			}
			setScore(score);
			setScores(scores);
		}	
		public void  setScore(int score){
			NumView messageNumView = (NumView)message.findViewById(R.id.score);
			NumView nextNumView = (NumView)gameNext.findViewById(R.id.score);
			messageNumView.setNum(score);
			nextNumView.setNum(score);
			messageNumView.invalidate();
			nextNumView.invalidate();
			this.score = score ;
		}
		public void setScores(int scores){			
			NumView messageNumView = (NumView)message.findViewById(R.id.scores);
			NumView nextNumView = (NumView)gameNext.findViewById(R.id.scores);
			NumView overNumView = (NumView)gameOver.findViewById(R.id.scores);
			messageNumView.setNum(scores);
			nextNumView.setNum(scores);
			overNumView.setNum(scores);
			messageNumView.invalidate();
			nextNumView.invalidate();
			overNumView.invalidate() ;
			GameScores.scores = scores ;
		}
		
		public void setGoal(int goal){
			NumView numView = (NumView)message.findViewById(R.id.goal);
			NumView nextNumView = (NumView)gameNext.findViewById(R.id.goal);
			numView.setNum(goal);
			nextNumView.setNum(goal);
			this.goal = goal ;
	}
		
		public int getGoal(){
			return goal ;
		}
		public int getScore(){
			return score ;
		}
		public int getScores(){
			return scores ;
		}

}
