package com.su.poke;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler{
	private GameLv gameLv ;
	private StringBuffer buffer = new StringBuffer() ;
	private List<GameLv> gameLvs = new ArrayList<GameLv>();
	
	public GameLv getGameLv(int lv){		 
			return gameLvs.get(lv-1);		
	}

	@Override
	public void startDocument() throws SAXException {		
			super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
			if(localName.equals("lv")){
				gameLv = new GameLv();
			}
			super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equals("lv")){
			gameLvs.add(gameLv);
		}else if(localName.equals("goal")){
			gameLv.setGoal(Integer.parseInt(buffer.toString().trim()));			
		}else if(localName.equals("probability-1")){
			gameLv.setP1(Integer.parseInt(buffer.toString().trim()));
		}else if(localName.equals("probability-2")){
			gameLv.setP2(Integer.parseInt(buffer.toString().trim()));
		}else if(localName.equals("probability-3")){
			gameLv.setP3(Integer.parseInt(buffer.toString().trim()));
		}else if(localName.equals("probability-4")){
			gameLv.setP4(Integer.parseInt(buffer.toString().trim()));
		}else if(localName.equals("probability-5")){
			gameLv.setP5(Integer.parseInt(buffer.toString().trim()));
		}
		buffer.setLength(0);
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		buffer.append(ch , start , length);
		super.characters(ch, start, length);
	}
	
}
