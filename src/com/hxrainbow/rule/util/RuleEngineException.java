package com.hxrainbow.rule.util;

/**
 * 
 * 规则引擎异常类
 *
 * @author guolei
 * @version 1.0
 * @created 2013-04-19 上午11:00:56
 * @history 
 * @see
 */
public class RuleEngineException extends Exception {
	
	private static final long serialVersionUID = 1037494946679958128L;
	private int errorCode;
	private String errorMsg;
	
	public RuleEngineException() {
		super();
	}
	
	public RuleEngineException(String messgae) {
		this.errorMsg = messgae;
	}
	
	public RuleEngineException(int errorCode,String messgae) {
		this.errorCode = errorCode;
		this.errorMsg = messgae;
	}
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
