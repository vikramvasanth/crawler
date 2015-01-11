package edu.uci.ics.crawler4j.crawler;

import java.util.ArrayList;


import edu.uci.ics.crawler4j.parser.HtmlParseData;

public class FieldExtractor {
	
	
	public static ArrayList<String> getExtractedElements( 
		Page page){
		
		ArrayList<String> extractedElements = new ArrayList<String>();
/*		String url = page.getWebURL().getURL();
		extractedElements.add(url);
        String domain = page.getWebURL().getDomain();
        extractedElements.add(domain);
        String path = page.getWebURL().getPath();
        extractedElements.add(path);
        String subDomain = page.getWebURL().getSubDomain();
        extractedElements.add(subDomain);
        String parentUrl = page.getWebURL().getParentUrl();
        extractedElements.add(parentUrl);
        String anchor = page.getWebURL().getAnchor();
        extractedElements.add(anchor);*/
        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
        String text = htmlParseData.getText();
        String html = htmlParseData.getHtml();
        String jobDesc = HTMLParserHelper.extractContents(html, "Description");
        if(jobDesc != null || jobDesc != " "){
        String textOnly = jobDesc.replaceAll("\\<[^>]*>","");
        if(textOnly != null || textOnly != " ")
        extractedElements.add(textOnly);
        }
        //extractedElements.add(domain);
		return extractedElements;
		
	}

}
