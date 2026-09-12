package tw.com.web;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.tools.ImageTools;

@WebServlet("/view_images")
public class ViewImageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 List<String> list =  ImageTools.getImageFileNames();
		 req.setAttribute("image_list", list);
		 req.getRequestDispatcher("/view_image.jsp").forward(req, resp);
		//模組M 讀圖片資料
		//顯示圖片資料 V
		//ViewImageServlet 整合C M與V 
		
	}
}
