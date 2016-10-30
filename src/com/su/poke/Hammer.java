package com.su.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


public class Hammer extends View implements Life{
	private Paint paint ;	
	private int i = 0 ;
	private int m = 2 ;
	private boolean mDead = false ;
	private static Bitmap sHammer[] = new Bitmap[2];

	public Hammer(Context context ) {
		super(context);
		
		paint = new Paint();	
		BitmapResourcesFactory factory = new BitmapResourcesFactory();
		HammerResources hammer = (HammerResources)factory.getResources(BitmapResourcesFactory.HR);
		sHammer= hammer.getHammer();			
	}
	@Override
	protected void onDraw(Canvas canvas) {		
		super.onDraw(canvas);
		canvas.drawBitmap(sHammer[i], 0, 0, paint);
		if( i == 0 && --m <= 0){
			i ++  ;
		}	
		if(i == 1 && ++m >= 2 ){
			mDead = true ;
		}

	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = sHammer[0].getWidth();
		int height = sHammer[0].getHeight();
		setMeasuredDimension(width , height);
	}
	


	@Override
	public boolean isDead() {		
		return mDead;
	}

}
