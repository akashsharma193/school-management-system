package com.school.management.common;

import com.school.management.model.FilterParameter;
import com.school.management.model.PageAttribute;

public class CreatePagination {

	public static PageAttribute pagination(FilterParameter filterParameter, Long recordTotal, Integer recordToShowOnPage) {
		PageAttribute page = new PageAttribute();
		page.setPageIndex(filterParameter.getPageIndex());
		page.setPageTotal((int)Math.ceil(recordTotal.intValue() * 1.0 / recordToShowOnPage));
		page.setRecordFetched(recordTotal.intValue());
		page.setRecordTotal(recordTotal.intValue());
		page.setRecordToShowOnOnePage(recordToShowOnPage);
		return page;
	}
}
