package tw.com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.BodyContent;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

public class MyBodyTagSupport extends BodyTagSupport{
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		BodyContent bodyContent = this.getBodyContent();
		String body = bodyContent.getString();
		JspWriter out = bodyContent.getEnclosingWriter();
		if (body != null) {
			try {
				out.println(body.toUpperCase());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return SKIP_BODY;
	}

}
