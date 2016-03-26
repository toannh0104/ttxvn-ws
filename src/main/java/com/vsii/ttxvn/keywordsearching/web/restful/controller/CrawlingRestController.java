/*
 * FILENAME
 *     CrawlingRestController.java
 *
 * FILE LOCATION
 *     $Source$
 *
 * VERSION
 *     $Id$
 *         @version       $Revision$
 *         Check-Out Tag: $Name$
 *         Locked By:     $Lockers$
 *
 * FORMATTING NOTES
 *     * Lines should be limited to 78 characters.
 *     * Files should contain no tabs.
 *     * Indent code using four-character increments.
 *
 * COPYRIGHT
 *     Copyright (C) 2005 vietsoftware international Inc. All rights reserved.
 *     This software is the confidential and proprietary information of
 *     VSII ("Confidential Information"). You shall not
 *     disclose such Confidential Information and shall use it only in
 *     accordance with the terms of the license agreement you entered into
 *     with VSII.
 */

package com.vsii.ttxvn.keywordsearching.web.restful.controller;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsii.ttxvn.crawling.Crawler;
import com.vsii.ttxvn.crawling.SourceUrl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * <p>
 * The class for implementation of Crawling webservice.
 * </p>
 * 
 * @version 1.0
 * @author namdx
 **/
@Controller
@RequestMapping(RestfulURIConstants.REST_CRAWLING)
public class CrawlingRestController {
    private static Logger logger = LoggerFactory.getLogger(CrawlingRestController.class);
    
	@RequestMapping(value = RestfulURIConstants.REST_CRAWLING_CRAW, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SourceUrl> crawlSourceUrl(@RequestBody List<SourceUrl> sourceUrls) {
	    /*
	    Map<String, SourceUrl> urls = new HashMap<String, SourceUrl>();
        urls.put("www.doisongphapluat.com", new SourceUrl("doisongphapluat.com", "en", 80));
        */
	    
	    Map<String, SourceUrl> urls = new HashMap<String, SourceUrl>();
	    
	    if (CollectionUtils.isNotEmpty(sourceUrls)) {
	        for (SourceUrl sourceUrl : sourceUrls) {
	            urls.put(sourceUrl.getUrl(), sourceUrl);
	        }
	        
	        Iterator<String> iterator = urls.keySet().iterator();
	        
	        while (iterator.hasNext()) {
	            logger.info(" + " + iterator.next());
	        }
	    } else {
	        logger.info("------------> sourceUrls is EMPTY");
	    }
	    
        try
        {
        	File exceptionFile = new File(Crawler.CRAWLING_EXCEPTION_FILE_PATH);
        	if (exceptionFile != null) {
	        	List<String> exceptionOccurence = FileUtils.readLines(exceptionFile);
	        	if (CollectionUtils.isNotEmpty(exceptionOccurence) && "1".equals(exceptionOccurence.get(0)))
	        	{
	        		logger.info("------------> Exception occured in last crawling session. Could not crawl data. Try again after a while");
	        	} 
	        	else 
	        	{	
		            logger.info("------------> sourceUrls is START");
		            if (Crawler.crawl(urls) == -1) {
						List<String> lines = new ArrayList<String>();
						lines.add("1");
						lines.add(System.lineSeparator());
						FileUtils.writeLines(new File(Crawler.CRAWLING_EXCEPTION_FILE_PATH), lines);
		            };
		            logger.info("------------> sourceUrls is END"); 
		        }
        	}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return new ArrayList<SourceUrl>(urls.values());
	}
}
