package com.school.management.model;

public class ResponseOperationResult<T> {

	private T response;
	private Boolean success;
	private ErrorParameter errorParameter;
	private PageAttribute pageAttribute;
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public ErrorParameter getErrorParameter() {
		return errorParameter;
	}
	public void setErrorParameter(ErrorParameter errorParameter) {
		this.errorParameter = errorParameter;
	}
	public PageAttribute getPageAttribute() {
		return pageAttribute;
	}
	public void setPageAttribute(PageAttribute pageAttribute) {
		this.pageAttribute = pageAttribute;
	}
	
	
}
