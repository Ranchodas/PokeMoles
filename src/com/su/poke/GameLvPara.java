package com.su.poke;

import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.SAXException;
import android.util.Xml;

public class GameLvPara {
	private static XMLHandler xmlHandler ;
	public static GameLvPara gameLvPara = new GameLvPara();
	
	private GameLvPara(){};
	
	
	static{
		try {
			 xmlHandler = new XMLHandler();
			InputStream is = MainActivity.context.getResources().getAssets().open("game_lv.xml");		
			android.util.Xml.parse(is, Xml.Encoding.UTF_8, xmlHandler);
		} catch (IOException e) {		
			e.printStackTrace();
			} catch (SAXException e) {			
			e.printStackTrace();
		}
	}
	public  GameLv getGameLvPara(int lv){
		return  xmlHandler.getGameLv(lv);
	}
	
}
