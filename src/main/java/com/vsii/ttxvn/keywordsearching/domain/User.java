/*
 * FILENAME
 *     User.java
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

package com.vsii.ttxvn.keywordsearching.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * <p>
 * The class for purpose of.
 * </p>
 * 
 * @version 1.0
 * @author phunv
 **/
public class User implements Serializable {
	private static final long serialVersionUID = 4281231703794033172L;

	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthday;

	/**
	 * <p>
	 * Getter for id.
	 * </p>
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <p>
	 * Setting value for id.
	 * </p>
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Getter for username.
	 * </p>
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <p>
	 * Setting value for username.
	 * </p>
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * <p>
	 * Getter for password.
	 * </p>
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>
	 * Setting value for password.
	 * </p>
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <p>
	 * Getter for firstName.
	 * </p>
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <p>
	 * Setting value for firstName.
	 * </p>
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * <p>
	 * Getter for lastName.
	 * </p>
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <p>
	 * Setting value for lastName.
	 * </p>
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * <p>
	 * Getter for birthDate.
	 * </p>
	 * 
	 * @return the birthDate
	 */
	@JsonSerialize(using = DateSerializer.class)
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * <p>
	 * Setting value for birthDate.
	 * </p>
	 * 
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
