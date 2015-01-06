package com.RLA;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String strId;
	@Persistent
	private String name;
	@Persistent
	private String image;

	public Long getId() {
		return id;
	}

	public String getStrId() {
		return strId;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = image;
	}
}