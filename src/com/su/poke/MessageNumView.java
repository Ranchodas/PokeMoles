package com.su.poke;

import android.content.Context;
import android.util.AttributeSet;

public class MessageNumView extends NumView{

	public MessageNumView(Context context, AttributeSet attrs) {
		super(context, attrs);
	
	}
	@Override
	protected void setNumResources() {
		numbers = new MessageNumbers();		
	}

}
