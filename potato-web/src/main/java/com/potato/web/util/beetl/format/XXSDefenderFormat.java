package com.potato.web.util.beetl.format;

import org.beetl.core.Format;

public class XXSDefenderFormat implements Format {

	@Override
	public Object format(Object data, String pattern) {
		if(data instanceof String) {
			String js = (String)data;
			String str = org.apache.commons.lang.StringEscapeUtils.escapeHtml(js);
			return str;
		}else{
			return data;
		}
	}

}
