package com.school.management.util;



public class SearchCriteria {
    private String key;
    private String secondaryKey;
    private String secondSecondaryKey;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
    
    public SearchCriteria(String key, String secondaryKey, Object value, SearchOperation operation) {
        this.key = key;
        this.secondaryKey = secondaryKey;
        this.value = value;
        this.operation = operation;
    }
    
    public SearchCriteria(String key, String secondaryKey,String secondSecondaryKey, Object value, SearchOperation operation) {
        this.key = key;
        this.secondaryKey = secondaryKey;
        this.value = value;
        this.operation = operation;
        this.secondSecondaryKey=secondSecondaryKey;
    }


    
	public String getKey() {
		return key;
	}


	public Object getValue() {
		return value;
	}


	public SearchOperation getOperation() {
		return operation;
	}


	public String getSecondaryKey() {
		return secondaryKey;
	}

	public String getSecondSecondaryKey() {
		return secondSecondaryKey;
	}

	
}
