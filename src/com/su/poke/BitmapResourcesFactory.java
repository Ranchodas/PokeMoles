package com.su.poke;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BitmapResourcesFactory {
	private static Map<String,  Resources> resources = new HashMap< String , Resources>();	
	public static final String MR = "MouseResources";
	public static final String NR = "NumResources" ;
	public static final String HR= "Hammer" ;	
	
	static{				
			resources.put(MR, new MouseResources(MainActivity.context));	
			resources.put(NR , new NumResources(MainActivity.context));
			resources.put(HR ,  new HammerResources(MainActivity.context));			
	}
	
	public  Resources getResources(String string){
		return resources.get(string);
	}
	
	public static void recycleAll(){
		Iterator<Map.Entry<String , Resources>> iterator = resources.entrySet().iterator();
	    while(iterator.hasNext()){
	    	Map.Entry<String , Resources> entry = iterator.next() ;
	    	entry.getValue().recycle();
	    	iterator.remove();	    	
	    }
	}
}
