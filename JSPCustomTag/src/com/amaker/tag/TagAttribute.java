package com.amaker.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagAttribute extends TagSupport{

	private int count;
	
	public void setCount(int count){
		this.count = count;
	}
	@Override
	public int doEndTag() throws JspException {
		
		String str = "hello";
		for(int i = 0; i < count; i ++){
			try {
				pageContext.getOut().print(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}

}
