/*
 * FILENAME
 *     DateUtils.java
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

package com.vsii.ttxvn.keywordsearching.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * The utility of Date.
 * </p>
 * 
 * @version 1.0
 * @author phunv
 **/
public class DateUtils {
	public static final String DD_MM_YYYY = "dd-MM-yyyy";
	public static final String DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
	
	public static String format(Date date, String pattern) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(date);
	}
}
