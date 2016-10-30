 package com.su.poke;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MouseResources implements Resources{
   public static final String KINGMOUSE = "king_mouse";
   public static final String PRETTYMOUSE = "pretty_mouse";
   public static final String CRAZEMOUSE = "craze_mouse";
   public static final String ANGLEMOUSE  = "angle_mouse";
   public static final String RABBIT = "rabbit";
    
	private static Bitmap[][] sMouse = new Bitmap[5][2];	
	private static Bitmap[] sMouseScore = new Bitmap[5];
	private static Bitmap sMouseStar ;	
	private static Map<String , Bitmap[]> sMap = new HashMap<String , Bitmap[]>();
	private static Map<String , Bitmap> sMapScore = new HashMap<String , Bitmap>();
	private static final String[] name = {CRAZEMOUSE , ANGLEMOUSE , PRETTYMOUSE , KINGMOUSE , RABBIT};
	private static final int[][] MOUSEID = {
		                                                                  {R.drawable.craze_mouse , R.drawable.hit_craze_mouse}, 
		                                                                  {R.drawable.angle_mouse , R.drawable.hit_angle_mouse},
		                                                                  {R.drawable.pretty_mouse , R.drawable.hit_pretty_mouse} , 
		                                                                  {R.drawable.king_mouse , R.drawable.hit_king_mouse},
		                                                                  {R.drawable.rabbit , R.drawable.hit_rabbit}
	                                                                     };
	private static final int[] MOUSESCORE = {R.drawable.plus_100  , R.drawable.multiply_2 , R.drawable.minus_100 , R.drawable.plus_500,   R.drawable.divide_2 };
	

	
	public MouseResources(Context context){
		for(int i = 0 ; i < 5 ; i ++){
			sMouse[i][0] = BitmapFactory.decodeResource(context.getResources(), MOUSEID[i][0]);
			sMouse[i][1] = BitmapFactory.decodeResource(context.getResources(), MOUSEID[i][1]);	
			sMouseScore[i] = BitmapFactory.decodeResource(context.getResources() ,  MOUSESCORE[i]);
			sMap.put(name[i], sMouse[i]);
			sMapScore.put(name[i] ,  sMouseScore[i]);
		}			
		sMouseStar = BitmapFactory.decodeResource(context.getResources() ,  R.drawable.star6);
	}
	
	public Bitmap[] getMouse(String name){
		return sMap.get(name);
	}
	
	public Bitmap getStar(){
		return sMouseStar ;
	}
	
	public Bitmap getScore(String name){
		return sMapScore.get(name);
	}
	@Override
	public void recycle(){
		for(int i = 0 ; i < 5 ; i ++){
			for(int j = 0 ; j < 2 ; j ++){
				if(sMouse[i][j] != null && sMouse[i][j].isRecycled()){
					sMouse[i][j].recycle();
				}				
			}
			if(sMouseScore[i] != null && sMouseScore[i].isRecycled()){
				sMouseScore[i].recycle();
			}
		}
		if(sMouseStar != null && sMouseStar.isRecycled()){
			sMouseStar.recycle();
		}
	}
}
