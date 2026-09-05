package tw.com.web;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private ExecutorService es;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//執行序池
		es = Executors.newCachedThreadPool();
	}
	
	private void testRun() {
		for (int i = 1; i<= 10;i++) {
			System.out.println("工作中:....."+i+":"+Thread.currentThread().getName());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}
		System.out.println("Email....");
	}
	
	private void testRun2(HttpServletResponse resp) throws IOException {
		resp.getWriter().println("開始工作!");
		for (int i = 1; i<= 10;i++) {
			System.out.println("工作中:....."+i+":"+Thread.currentThread().getName());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}
		resp.getWriter().println("完成了!");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, 
						HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//適合長時間模式
		es.execute(()->{
			//testRun();
			try{
				testRun2(resp);
			}catch(IOException ex) {
				
			}
			
		});
		
		
		
		resp.getWriter().println("Test Page1 Hello!");
	}
}
