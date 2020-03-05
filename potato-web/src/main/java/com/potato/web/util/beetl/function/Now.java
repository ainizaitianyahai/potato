package com.potato.web.util.beetl.function;

import java.io.IOException;
import java.util.Date;

import org.beetl.core.Context;
import org.beetl.core.Function;

import com.potato.utils.DateFormatter;

public class Now implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		try{
			ctx.byteWriter.write(DateFormatter.formatEsc(new Date()).getBytes());
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		return "";
	}

}