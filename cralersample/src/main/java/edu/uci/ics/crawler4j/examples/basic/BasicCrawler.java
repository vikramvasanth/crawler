package edu.uci.ics.crawler4j.examples.basic;

import edu.uci.ics.crawler4j.crawler.FieldExtractor;
import edu.uci.ics.crawler4j.crawler.HTMLParserHelper;
import edu.uci.ics.crawler4j.crawler.ListToCSV;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.*;
import java.util.regex.Pattern;

import org.apache.http.Header;

/**
 * @author Yasser Ganjisaffar <lastname at gmail dot com>
 */
public class BasicCrawler extends WebCrawler {

        private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4"
                        + "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

        /**
         * You should implement this function to specify whether the given url
         * should be crawled or not (based on your crawling logic).
         */
        @Override
        public boolean shouldVisit(WebURL url) {
                String href = url.getURL().toLowerCase();
                System.out.println("Boolean should visit");
                System.out.println(!FILTERS.matcher(href).matches() && !href.matches("/job/result/.*searchagain.*") && href.matches("/job/result/.*src=19.*"));
                //return !FILTERS.matcher(href).matches() && href.startsWith("http://www.ics.uci.edu/");
                return !FILTERS.matcher(href).matches() && !href.matches("/job/result/.*searchagain.*") ;
                
        }

        /**
         * This function is called when a page is fetched and ready to be processed
         * by your program.
         */
        @Override
        public void visit(Page page) {
        	
        	ArrayList <String> elements = FieldExtractor.getExtractedElements(page);
            boolean writeCSVToConsole = false;
            boolean writeCSVToFile = true;
            //String destinationCSVFile = "/Users/vikumar/crawler4j/output/convertedCSV.csv";
            boolean sortTheList = false;
                /*int docid = page.getWebURL().getDocid();
                String url = page.getWebURL().getURL();
                String domain = page.getWebURL().getDomain();
                String path = page.getWebURL().getPath();
                String subDomain = page.getWebURL().getSubDomain();
                String parentUrl = page.getWebURL().getParentUrl();
                String anchor = page.getWebURL().getAnchor();
                String jobDesc = null;
                System.out.println("Docid: " + docid);
                System.out.println("URL: " + url);
                System.out.println("Domain: '" + domain + "'");
                System.out.println("Sub-domain: '" + subDomain + "'");
                System.out.println("Path: '" + path + "'");
                System.out.println("Parent page: " + parentUrl);
                System.out.println("Anchor text: " + anchor);
                
                if (page.getParseData() instanceof HtmlParseData) {
                        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                        String text = htmlParseData.getText();
                        String html = htmlParseData.getHtml();
                        
                        HashSet<WebURL> links = (HashSet<WebURL>) htmlParseData.getOutgoingUrls();

                        System.out.println("Text length: " + text.length());
                        System.out.println("Html length: " + html.length());
                        System.out.println("Number of outgoing links: " + links.size());
                        jobDesc = HTMLParserHelper.extractContents(html, "Description");
                        System.out.println(jobDesc);
                }

                Header[] responseHeaders = page.getFetchResponseHeaders();
                if (responseHeaders != null) {
                        System.out.println("Response headers:");
                        for (Header header : responseHeaders) {
                                System.out.println("\t" + header.getName() + ": " + header.getValue());
                        }
                }*/
        		ListToCSV csvutil = new ListToCSV();
        		csvutil.convertAndPrint(elements, writeCSVToConsole, writeCSVToFile, sortTheList);
                System.out.println("=============");
        }
}