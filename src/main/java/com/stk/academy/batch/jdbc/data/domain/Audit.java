package com.stk.academy.batch.jdbc.data.domain;

import java.sql.Date;

public abstract class Audit {
	
	protected String createUser;
	protected Date createDate;
	protected String updateUser;
	protected Date updateDate;
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date date) {
		this.createDate = date;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
