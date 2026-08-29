package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		String action_type = req.getParameter("action_type");
		resp.getWriter().println("action_type:"+action_type);
		HttpSession session= req.getSession();
		int sessionCount = 0;			
		Integer sessionCountTmp = 
				(Integer)session.getAttribute("session_count");
		if (sessionCountTmp != null) {
			sessionCount = sessionCountTmp;
		}
		switch(action_type) {
			case "+" -> ++sessionCount;				
			case "-" -> --sessionCount;				
		}
		session.setAttribute("session_count", sessionCount);
		//session_count
		resp.getWriter().println("<a href='view.jsp'>顯示</a>");
		
	}
}
//+ -

//由session取值
//再決定加減
//有session 取出session的數值
//無session 預設0做計算
//做完放回session
