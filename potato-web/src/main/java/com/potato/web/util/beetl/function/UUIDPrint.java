package com.potato.web.util.beetl.function;

import java.io.IOException;
import java.util.UUID;

import org.beetl.core.Context;
import org.beetl.core.Function;

public class UUIDPrint implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		try{
			ctx.byteWriter.write(UUID.randomUUID().toString().getBytes());
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		return "";
	}

}