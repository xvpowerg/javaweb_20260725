package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/page1"},asyncSupported = true  )
public class Page1Servlet extends HttpServlet {
	private ExecutorService es;
	
	public void init() {
		es = Executors.newCachedThreadPool();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AsyncContext ctx = req.startAsync();
		
		es.execute(()->{
			try {
				System.out.println("page1 doGet.....");
				PrintWriter out =  ctx.getResponse().getWriter();
				out.println("page1 doGet");
			}catch(Exception ex) {
				System.out.println(ex);
			}finally {
				ctx.complete();
			}
		});
		
		
	}
	
}
