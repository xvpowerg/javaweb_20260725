package tw.com.web;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
@WebServlet("/page1")
public class PageServlet1 extends  HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)throws IOException {
		PrintWriter out = resp.getWriter();
		out.print("Page1");
		//實現一個page5
		//可顯示1 ~ 100
		
	}
}
