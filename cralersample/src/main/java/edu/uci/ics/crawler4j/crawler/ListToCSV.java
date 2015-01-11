package edu.uci.ics.crawler4j.crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class ListToCSV {
/*    private static boolean writeCSVToConsole = false;
    private static boolean writeCSVToFile = true;
    
    private static boolean sortTheList = false;*/
 
/*    public static void main(String[] args) {
        ListToCSV util = new ListToCSV();
        List<String> sampleList = util.createSampleList();
        util.convertAndPrint(sampleList, writeCSVToConsole, writeCSVToFile, sortTheList);
 
    }*/
	private static String destinationCSVFile = "/Users/vikumar/crawler4j/output/HAdoopCSV.csv";

    public void convertAndPrint(List<String> sampleList,
            boolean writeToConsole, boolean writeToFile, boolean sortTheList) {
        String commaSeparatedValues = "";
 
        /** If the list is not null and the list size is not zero, do the processing**/
        if (sampleList != null) {
            /** Sort the list if sortTheList was passed as true**/
            if(sortTheList) {
                Collections.sort(sampleList);
            }
            /**Iterate through the list and append comma after each values**/
            Iterator<String> iter = sampleList.iterator();
            while (iter.hasNext()) {
                commaSeparatedValues += iter.next() + "||";
            }
            /**Remove the last comma**/
            if (commaSeparatedValues.endsWith("||")) {
                commaSeparatedValues = commaSeparatedValues.substring(0,
                        commaSeparatedValues.lastIndexOf("||"));
            }
        }
        /** If writeToConsole flag was passed as true, output to console**/
        if(writeToConsole) {
            System.out.println(commaSeparatedValues);
        }
        /** If writeToFile flag was passed as true, output to File**/      
        if(writeToFile) {
            try {
                FileWriter fstream = new FileWriter(destinationCSVFile, true);
                BufferedWriter out = new BufferedWriter(fstream);
                  
                if (sampleList != null && sampleList.size() > 0){
                	Pattern p = Pattern.compile("[a-zA-Z]");
                	Matcher m = p.matcher(commaSeparatedValues);
                if(commaSeparatedValues != null && commaSeparatedValues != "" 
                		&& m.find()){
                out.write(commaSeparatedValues);
                out.write("\n");
                out.write("\n");
                out.write("\n");
                System.out.println("*** Also wrote this information to file: " );
                }
                }
                out.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
    }
 
    /**
     * Creates a sample list to be used by the convertAndPrint method
     * and returns it to the calling method.
     */
    private List<String> createSampleList() {
        List<String> sampleList = new ArrayList<String>();
        sampleList.add("Nebraska");
        sampleList.add("Iowa");
        sampleList.add("Illinois");
        sampleList.add("Idaho");
        return sampleList;
    }
}
