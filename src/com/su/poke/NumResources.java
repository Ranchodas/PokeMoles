package com.su.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class NumResources implements Resources{
	private static Bitmap[] sNum = new Bitmap[10];
	private static Bitmap[] sNumPass = new Bitmap[10];
	private static Bitmap[] sNumLv = new Bitmap[10];
	private static Bitmap[] sNumLvPass = new Bitmap[10];
	
	private static final int[] NUM = {R.drawable.n0 , R.drawable.n1 , R.drawable.n2 , R.drawable.n3 , R.drawable.n4 , 
		                                                     R.drawable.n5 , R.drawable.n6 , R.drawable.n7 , R.drawable.n8 , R.drawable.n9};
	private static final int[] NUMPASS = {R.drawable.n_pass0 , R.drawable.n_pass1 , R.drawable.n_pass2 , R.drawable.n_pass3 , R.drawable.n_pass4 ,
		                                                             R.drawable.n_pass5 ,  R.drawable.n_pass6 ,  R.drawable.n_pass7,  R.drawable.n_pass8 ,  R.drawable.n_pass9 ,};
	private static final int[] NUMLV = {R.drawable.lv0 , R.drawable.lv1 , R.drawable.lv2 , R.drawable.lv3 , R.drawable.lv4 , 
		                                                         R.drawable.lv5 , R.drawable.lv6 , R.drawable.lv7 , R.drawable.lv8 , R.drawable.lv9 , };
	private static final int[] NUMLVPASS = {R.drawable.lv_pass0 , R.drawable.lv_pass1 , R.drawable.lv_pass2 , R.drawable.lv_pass3 , R.drawable.lv_pass4 , 
		                                                                  R.drawable.lv_pass5 , R.drawable.lv_pass6 , R.drawable.lv_pass7 , R.drawable.lv_pass8 , R.drawable.lv_pass9 , };
	
	public NumResources(Context context){
		for(int i = 0 ; i < 10 ; i ++){
			sNum[i] = BitmapFactory.decodeResource(context.getResources(), NUM[i]);
			sNumPass[i] = BitmapFactory.decodeResource(context.getResources(), NUMPASS[i]);
			sNumLv[i] = BitmapFactory.decodeResource(context.getResources(), NUMLV[i]);
			sNumLvPass[i] = BitmapFactory.decodeResource(context.getResources(), NUMLVPASS[i]);
		}
	}
	public Bitmap getNum(int i){
		return sNum[i];
	}
	public Bitmap getNumPass(int i){
		return sNumPass[i];
	}
	public Bitmap getNumLv(int i){
		return sNumLv[i];
	}
	public Bitmap getNumLvPass(int i){
		return sNumLvPass[i];
	}
	@Override
	public void recycle(){
		for(int i = 0 ; i < 10 ; i ++){
			if(sNum[i].isRecycled()){
				sNum[i].recycle();
			}
			if(sNumPass[i].isRecycled()){
				sNumPass[i].recycle();
			}
			if(sNumLv[i].isRecycled()){
				sNum[i].recycle();
			}
			if(sNumLvPass[i].isRecycled()){
				sNumLvPass[i].recycle();
			}
		}
	}
}
