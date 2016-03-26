/*
 * FILENAME
 *     RestfulURIConstants.java
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

/**
 * <p>
 * The class for purpose of holding all Restful URL Constants of Application.
 * </p>
 * 
 * @version 1.0
 * @author phunv
 **/
public class RestfulURIConstants {
	public static final String REST_USER = "/restful/user";
	public static final String REST_USER_GET = "/{id}";
	public static final String REST_USER_GET_ALL = "/getAll";
	public static final String REST_USER_CREATE = "/create";
	public static final String REST_USER_DELETE = "/delete/{id}";
	public static final String REST_CRAWLING = "/restful/crawling";
	public static final String REST_CRAWLING_CRAW = "crawl";
}
