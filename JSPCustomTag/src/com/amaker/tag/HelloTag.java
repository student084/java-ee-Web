package com.amaker.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{

	
	private PageContext pageContext;
	
	private Tag tag;
	//��ǩ����ʱִ��
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
//ִ�б�ǩʱ�����Զ���ҳ���PageContext���������setPageContext����
	public void setPageContext(PageContext arg0) {
		
		this.pageContext = arg0;
	}
//�жϴ˱�ǩ�Ƿ��и���ǩ������и���ǩ����Ѹ���ǩ����������һ�㲻�ã�
	public void setParent(Tag arg0) {
		
		this.tag = arg0;
	}

}
