package edu.uci.ics.crawler4j.crawler;


import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

public class HTMLParserHelper {
	
	public static String extractContents (String html, String element){
		System.out.println("Inside extractContents ");
	
		//System.out.println(html);
		//File input = new File("/Users/vikumar/crawler4j/page.htm");
		System.out.println(element);
		 Document doc = Jsoup.parse(html);
		 Elements desc=doc.select("[id~="+element+"]");

		// System.out.println(desc.html());
		
		return desc.html();
		
	}

//	public static void main(String args[]){
//		try {
//			HTMLParserHelper.extractContents("Des", "Desc");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	

}
