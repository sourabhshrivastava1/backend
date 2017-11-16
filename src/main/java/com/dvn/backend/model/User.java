package com.dvn.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")  
@Component

public class User extends BaseDomain {

	@Id
	private String id;
	
	@Column
	private String password;
	
	/*@Column
	@NotFound
	private boolean jsonFlag;*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public boolean getJsonFlag() {
		return jsonFlag;
	}

	public void setJsonFlag(boolean jsonFlag) {
		this.jsonFlag = jsonFlag;
	}
	*/
	}
