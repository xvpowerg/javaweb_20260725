package tw.com.web;

import java.io.IOException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.tools.MaskNetTools;

@WebServlet(urlPatterns="/mask",asyncSupported = true)
public class MaskServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsyncContext context = req.startAsync();		
		
		MaskNetTools.dowloadMaskJson((list)->{
		    ServletRequest newReq = context.getRequest();
		    ServletResponse newResp = context.getResponse();
			req.setAttribute("maskList", list);
			try {
				req.getRequestDispatcher("mask.jsp").forward(newReq, newResp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}finally {
				context.complete();
			}
			
		});
		
		
	}
}
