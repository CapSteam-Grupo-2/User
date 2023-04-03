package com.capgeticket.user.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String lastname;
	private String mail;
	private String password;
	private String date;

}
