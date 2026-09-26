package tw.com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleTagHandler extends SimpleTagSupport {
		private String url;
		private boolean showBoder = false;
		private boolean showUrl = false;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public void setShowBoder(boolean showBoder) {
			this.showBoder = showBoder;
		}
		public boolean isShowBoder() {
			return this.showBoder;
		}
		public boolean isShowUrl() {
			return this.showUrl;
		}
		
		public void setShowUrl(boolean showUrl) {
			this.showUrl = showUrl;  
		}
		
		
		
		@Override
		public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
			PageContext pcx = (PageContext)getJspContext();
			JspWriter out = pcx.getOut();
			StringBuffer sb = new StringBuffer();
			if (this.isShowUrl()) {
				sb.append("<h3>");
				sb.append(url);
				sb.append("</h3>");
			}
			
			sb.append("<img width='200px' height='200px'");
			if(this.isShowBoder()) {
				sb.append(" border='1' ");
			}
			sb.append(" src='");
			sb.append(url);
			sb.append("'/>");
			
			System.out.println(sb);
			out.println(sb);
			
			
		}
}
