package tw.com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag {
	private Tag parent;
	private PageContext pageContext;
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		try{
			out.println("<font size='5' color='blue'>我離開了</font>");
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		 JspWriter out = pageContext.getOut();
		 try{
			 
			 out.println("<font size='5' color='blue'> 我來了</font>");
			 
		 }catch(IOException ex) {
			 System.out.println(ex);
		 }
		return EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag tag) {
		// TODO Auto-generated method stub
		this.parent = tag;
	}

}
