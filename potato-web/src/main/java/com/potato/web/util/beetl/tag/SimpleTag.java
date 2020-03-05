package com.potato.web.util.beetl.tag;

import java.io.IOException;

import org.beetl.core.tag.Tag;

public class SimpleTag extends Tag {

	@Override
	public void render() {
		try {
			ctx.byteWriter.write("被删除了，付费可以看。".getBytes());
			this.doBodyRender(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
