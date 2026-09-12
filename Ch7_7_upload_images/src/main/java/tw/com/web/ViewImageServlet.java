package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view_images")
public class ViewImageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Path imageDir = Paths.get("C:","images"); 
		List<String> imagesList = Files.list(imageDir).
			map(p->p.getFileName().toString()).
			collect(Collectors.toList());
		PrintWriter out =  resp.getWriter();

		//作業顯示資料夾的2張圖片
		out.println("<html>");
		out.println("<body>");
		String imgStr = "<img width='30%%' height='30%%' src=/myimages/%s";
		for(var data : imagesList) {			
			out.println("<div>");
			System.out.println(data);
			out.println(String.format(imgStr, data));
			out.println("</div>");
		}		
		out.println("</body>");
		out.println("<html>");
		
	}
}
