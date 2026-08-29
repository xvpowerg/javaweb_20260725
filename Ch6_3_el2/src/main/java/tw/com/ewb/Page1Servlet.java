package tw.com.ewb;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String canShow = req.getParameter("canShow");
			String action = req.getParameter("action");
			req.setAttribute("canShow",
					Boolean.parseBoolean(canShow));
			req.setAttribute("action",action == null?0:Integer.parseInt(action));
			
			req.getRequestDispatcher("page1.jsp").forward(req, resp);
			
		}
}
