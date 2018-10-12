package com.testinfra.csvloader;

public class DataTest {
	private String accountId;
	private String accountType;
	private String accountStatus;
	private String creationDate;
	private String id;
	private String description;
	private Data data;
	private String numOfTrans;
	public String getNumOfTrans() {
		return numOfTrans;
	}
	public void setNumOfTrans(String numOfTrans) {
		this.numOfTrans = numOfTrans;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	private String sequence;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String toString(){
		return accountId+":"+accountType+":"+accountStatus+":"+creationDate+":"+id+":"+description+":";
	}
	public Data getDataModel(){
		Data data = new Data();
		data.setAccountId(accountId);
		data.setAccountStatus(accountStatus);
		data.setAccountType(accountType);
		data.setCreationDate(creationDate);
		return data;
	}
}
