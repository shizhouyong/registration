package com.wl.resp;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RespEnum {
	
	//成功
	SUCCESS(0,"success"),
	
	/*
	 * 公共错误码
	 */
	PARAMETER_NUMBER_ERR		(0x00001000, "parameter number is wrong"),	//参数数目不对
	PHONENUMBER_LENGTH_ERROR (0x00001001, "mobile phone number length is not 11"), 	//电话号码长度错误
	DATA_INSERT_ERROR	(0x00001002, "data insert error"),          //数据上传错误
	REQUST_TIMEOUT		(0x00001003, "request time out"),			//请求超时
	UNKNOWN_ERROR		(0x00001004, "unknown error"),				//未知错误

	END(0x7FFFFFFF, "end");	//最大错误码
	
	private Response response = new Response();

	/**
	 * @param code
	 * @param info
	 */
	private RespEnum(int code, String info) {
		response.setRetCode(code);
		response.setRetInfo(info);
	}

	public Response getResponse(){
		return response;
	}
	
	public int getRetCode() {
		return response.getRetCode();
	}
	
	public String getRetInfo() {
		return response.getRetInfo();
	}
	
	@JsonValue
    public Response toMap() {
        return response;
    }
	
	@Override
	public String toString(){
		return JSON.toJSONString(response);
	}
}
