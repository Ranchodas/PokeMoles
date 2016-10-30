package com.su.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class HitScore extends View implements Life{
	private Paint paint ;	
	private Bitmap score ;
	private int m = 4 ; 
	private boolean mDead = false ;
	
	public HitScore(Context context , String name) {
		super(context);
		paint = new Paint();
		BitmapResourcesFactory factory = new BitmapResourcesFactory();
		MouseResources resoures = (MouseResources)factory.getResources(BitmapResourcesFactory.MR);
		score = resoures.getScore(name);
	}
	@Override
	public boolean isDead() {
		return mDead;
	}

	@Override
	protected void onDraw(Canvas canvas) {		
		super.onDraw(canvas);
		canvas.drawBitmap(score, 0, 0, paint);
		if(--m <= 0){
			mDead =true;
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(score.getWidth() , score.getHeight());
	}



}
