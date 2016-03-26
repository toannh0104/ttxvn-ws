/*
 * FILENAME
 *     UserRestController.java
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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsii.ttxvn.keywordsearching.domain.User;
import com.vsii.ttxvn.keywordsearching.utils.Constants;

/**
 * <p>
 * The service exposes info about User.
 * </p>
 * 
 * @version 1.0
 * @author phunv
 **/
@Controller
@RequestMapping(RestfulURIConstants.REST_USER)
public class UserRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserRestController.class);	
	
	// The dummy Map to store Users
	private static Map<Long, User> users = new HashMap<Long, User>();

	static {
		User user;

		user = new User();
		user.setId(13L);
		user.setFirstName("Viet Phu");
		user.setLastName("Nguyen");
		user.setBirthday(new Date());
		users.put(13L, user);
		
		user = new User();
		user.setId(12L);
		user.setFirstName("Van Bach");
		user.setLastName("Tran");
		user.setBirthday(new Date());
		users.put(12L, user);
		
		user = new User();
		user.setId(11L);
		user.setFirstName("Xuan Nam");
		user.setLastName("Do");
		user.setBirthday(new Date());
		users.put(11L, user);
	}

	@RequestMapping(value = RestfulURIConstants.REST_USER_GET, method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable(Constants.ID) Long id) {
		logger.info("get user. ID=" + id);
		return users.get(id);
	}

	@RequestMapping(value = RestfulURIConstants.REST_USER_GET_ALL, method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		logger.info("start get all users");
		List<User> listUsers = new ArrayList<User>();
		Set<Long> userIdKeys = users.keySet();

		for (Long key : userIdKeys) {
			listUsers.add(users.get(key));
		}

		return listUsers;
	}

	@RequestMapping(value = RestfulURIConstants.REST_USER_CREATE, method = RequestMethod.POST)
	@ResponseBody
	public User createUser(@RequestBody User user) {
		user.setBirthday(new Date());
		users.put(user.getId(), user);
		
		return user;
	}

	@RequestMapping(value = RestfulURIConstants.REST_USER_DELETE, method = RequestMethod.DELETE)
	@ResponseBody
	public User deleteUser(@PathVariable(Constants.ID) Long id) {
		User user = users.get(id);
		users.remove(id);
		
		return user;
	}
}
