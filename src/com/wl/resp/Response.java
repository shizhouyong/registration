package com.wl.resp;

public class Response {
	protected int retCode = 0;
	protected String retInfo;
	
	public String getRetInfo() {
		return retInfo;
	}
	public void setRetInfo(String retInfo) {
		this.retInfo = retInfo;
	}
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retcode) {
		this.retCode = retcode;
	}
}
