package com.su.poke;

import java.util.HashSet;
import java.util.Set;

public class ThreadControl {
	public  boolean pause ;
	public boolean stop  ; 
	public  static Object sLockObject = new Object();	
	private Set<Thread> threadSet = new HashSet<Thread>();	
	
	public  ThreadControl(){
		pause = false ;
		stop = false ;
	}	
	public void  addThread(Thread thread){
		threadSet.add(thread);
	}
	public  void pause(){
		pause = true;
		for(Thread thread : threadSet){
			thread.interrupt();
		}	
	}
	
	public void shutDown(){
		stop = true;
		for(Thread thread : threadSet){
			thread.interrupt();
		}	
		threadSet.removeAll(threadSet);		
	}
	
	public void restart(){
		synchronized(sLockObject){
			sLockObject.notifyAll();
		}
	}
}
