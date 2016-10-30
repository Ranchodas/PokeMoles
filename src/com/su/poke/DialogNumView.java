package com.su.poke;

import android.content.Context;
import android.util.AttributeSet;

public class DialogNumView extends NumView{

	public DialogNumView(Context context, AttributeSet attrs) {
		super(context, attrs);		
	}

	@Override
	protected void setNumResources() {
		numbers = new DialogNumbers();		
	}

}
