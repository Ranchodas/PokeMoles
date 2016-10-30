package com.su.poke;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public abstract class NumView extends View{
	protected Paint paint ;	
	protected int num ;
	protected int length ;
	protected int[] sArray = new int[10];
	protected Numbers numbers;	
	
	public NumView(Context context, AttributeSet attrs) {
		super(context, attrs);	
		paint = new Paint();		
		setNumResources();
	}
	
	public void setNum(int num){
		if(num < 0) return ;
		this.num = num ;
		toArray();
	}
	
	protected abstract void setNumResources();
	
	protected void toArray(){	
	      int i = 0 ;		     
	      do{
	    	  sArray[i++] = num%10 ;
	    	  num = (num - num%10)/10 ;
	      }while(num != 0);
	      
	      length = i ;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);	
		int n = 0;
		for(int i = length -1 ; i >= 0 ; i-- ){
			canvas.drawBitmap(numbers.getNum(sArray[i]), 18*(n++), 0, paint);
		}		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(numbers.getNum(1).getWidth()*10 , numbers.getNum(1).getHeight());		
	}

}
