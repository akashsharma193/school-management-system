package com.school.management.model;

import javax.ws.rs.QueryParam;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilterParameter {
	
	private @QueryParam("pageIndex") Integer pageIndex=0;
	private @QueryParam("recordToShowOnOnePage") Integer recordToShowOnOnePage=25;
	private @QueryParam("recordTotal") Long recordTotal;
	private @QueryParam("arcFlag") String arcFlag="";

	private @QueryParam("id") String id="";
	private @QueryParam("firstName") String firstName="";
	private @QueryParam("lastName") String lastName="";
	private @QueryParam("isActive") String isActive="";
	private @QueryParam("roleId") String roleId="";
	private @QueryParam("subjectName") String subjectName="";
	private @QueryParam("className") String className="";
	
	
}
