package com.su.poke;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class Mouse extends View implements Life{			
	private int h = 10;	
	private int n = 4 ;
	private int m = 4 ;
	private Paint paint ;
	private Bitmap mStar ;	
	private Bitmap[] mouse  = new Bitmap[2];	
	private MouseResources mouseResources ;	
	private String name ;
	private boolean mHit = false ;	
	private boolean dead = false;
	private static float denisty;	
	
	public Mouse(Context context , String name) {
		super(context);	
		this.name = name ;
		paint = new Paint();	
		denisty = context.getResources().getDisplayMetrics().density;	
		BitmapResourcesFactory factory = new BitmapResourcesFactory();
		mouseResources = (MouseResources)factory.getResources(BitmapResourcesFactory.MR);
		mouse = mouseResources.getMouse(name);
		mStar = mouseResources.getStar();
	
	}
	
	@Override	
	public boolean isDead(){
		return dead;
	}
	
    public void setHit(){
    	mHit = true;
    }    
    
    public String getName(){
    	return name ;
    }

	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Mouse){
			LayoutParams thisParams = (RelativeLayout.LayoutParams)this.getLayoutParams();
			LayoutParams otherParams = (RelativeLayout.LayoutParams)((Mouse)o).getLayoutParams();
			if(thisParams.leftMargin == otherParams.leftMargin && thisParams.topMargin == otherParams.topMargin){
	     			return true ;			
			}
		}	
		return false;
	}	
	@Override
	public int hashCode() {
		LayoutParams thisParams = (RelativeLayout.LayoutParams)this.getLayoutParams();
		return thisParams.leftMargin*thisParams.topMargin;
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = mouse[0].getWidth();
		int height = mouse[0].getHeight();
		setMeasuredDimension(width , height);
		
	}

	@Override
	protected void onDraw(Canvas canvas) {		
		super.onDraw(canvas);
		if(!mHit){			
		canvas.drawBitmap(mouse[0], 0, mouse[0].getHeight()-h*denisty, paint);		
		}else{
			canvas.drawBitmap(mouse[1], 0 ,  37*denisty , paint);
			canvas.drawBitmap(mStar, 0 ,  37*denisty , paint);				
			if(--n < 0) dead = true;			
		}		
	
		if(h < 85 && m == 4){
			h += 15;		
		}else if(h <= 85 && --m >= 0){			
            return ;
		}else if(h > 10){
			h -= 15 ;
		}else{
			dead = true ;
		}			  		
		}	

}
