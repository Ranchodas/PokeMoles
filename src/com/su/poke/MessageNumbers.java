package com.su.poke;

import android.graphics.Bitmap;

public class MessageNumbers extends Numbers{
	
	public MessageNumbers() {
		super();		
	}

	@Override
	public  Bitmap getNum(int i) {
		return resources.getNum(i);
	}

}
