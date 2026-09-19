package tw.com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.BodyContent;
import jakarta.servlet.jsp.tagext.BodyTag;
import jakarta.servlet.jsp.tagext.Tag;

public class MyBodyTagHandler implements BodyTag {
	private PageContext pageContext;
	private Tag parent;
	private String message;
	private int count = 1;
	
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if (count > 3) {
			return SKIP_BODY;
		}
		count ++;
		return EVAL_BODY_AGAIN;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out =   pageContext.getOut();
		try {
			out.print("<h1>doEndTag </h1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out =   pageContext.getOut();
		try {
			out.print(String.format("<h1>%s標籤開始了</h1>", this.getMessage()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return EVAL_BODY_INCLUDE;
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
	public void setPageContext(PageContext pc) {
		// TODO Auto-generated method stub
		this.pageContext = pc;
	}
	@Override
	public void setParent(Tag t) {
		// TODO Auto-generated method stub
		this.parent = t;
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		
	}

}
