package com.su.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HammerResources implements Resources{
	private static Bitmap[] sHammer = new Bitmap[2];
	private static final int[] ID = {R.drawable.hammer0 , R.drawable.hammer1};
	
	public HammerResources(Context context){
		for(int i = 0 ; i < 2 ; i ++){
			sHammer[i] = BitmapFactory.decodeResource(context.getResources() ,  ID[i]);
		}
	}
	public Bitmap[] getHammer(){
		return sHammer;
	}	
	
	@Override
	public void recycle() {	
		for(int i = 0 ; i < 2 ; i ++){
			if(sHammer[i] != null && sHammer[i].isRecycled()){
				sHammer[i].recycle();
			}
		}
	}

}
