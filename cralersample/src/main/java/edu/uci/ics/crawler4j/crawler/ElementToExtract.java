package edu.uci.ics.crawler4j.crawler;
import java.util.*;

public class ElementToExtract {
	
	HashMap<String,String[]> elementsToExtract;
	
	public ElementToExtract(){
		
		String[] jobDescription = new String[] { "Description", "Desc" };
		elementsToExtract = new HashMap<String, String[]>();		
		elementsToExtract.put("JobDescription", jobDescription);
		
	}

	public HashMap<String,String[]> getElementsToExtract() {
		return elementsToExtract;
	}

	public void setElementsToExtract(HashMap<String,String[]> elementsToExtract ) {
		this.elementsToExtract = elementsToExtract;
	}
	

}
