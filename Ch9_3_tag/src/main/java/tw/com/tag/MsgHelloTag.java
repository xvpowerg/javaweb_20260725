package tw.com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.TagSupport;

public class MsgHelloTag extends TagSupport {
	private String message;
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		PageContext pageContext = this.pageContext;
		 JspWriter out =  pageContext.getOut();
		 String msg = String.
				 format("<font size='6' color='red'>%s你好</font>", getMessage());
		 
		try {
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return EVAL_PAGE;
	}
	
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
