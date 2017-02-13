package com.amaker.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{

	
	private PageContext pageContext;
	
	private Tag tag;
	//标签结束时执行
	public int doEndTag() throws JspException {
		
		String str = "hello JSP Tag!";
		JspWriter out = pageContext.getOut();
		
		try {
			out.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		
		return SKIP_BODY;
	}

	public Tag getParent() {
		
		return tag;
	}

	public void release() {
		
		
	}
//执行标签时，会自动把页面的PageContext传给下面的setPageContext方法
	public void setPageContext(PageContext arg0) {
		
		this.pageContext = arg0;
	}
//判断此标签是否含有父标签，如果有父标签，则把父标签传递下来（一般不用）
	public void setParent(Tag arg0) {
		
		this.tag = arg0;
	}

}
