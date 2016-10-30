package com.su.poke;

import android.graphics.Bitmap;

public abstract  class Numbers {
	protected NumResources resources ;
	
	public Numbers(){
		BitmapResourcesFactory factory = new BitmapResourcesFactory();
		resources = (NumResources)factory.getResources(BitmapResourcesFactory.NR);
	}
	public  abstract Bitmap getNum(int i);

}
