package com.su.poke;

import android.graphics.Bitmap;

public class DialogNumbers extends Numbers{	

	public DialogNumbers() {
		super();		
	}
	@Override
	public Bitmap getNum(int i) {		
		return resources.getNumPass(i);
	}

}
