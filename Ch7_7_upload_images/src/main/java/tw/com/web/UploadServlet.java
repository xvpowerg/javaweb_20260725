package tw.com.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part =  req.getPart("photo");	
		String fileName = part.getSubmittedFileName();
		//System.out.println("fileName:"+fileName);
	 	Path path =  Paths.get("C:","images",fileName);
	 	File file =  path.toFile();
	 	
	 	try(InputStream inputStr = part.getInputStream();
	 		FileOutputStream out = new FileOutputStream(file)){
	 		byte[] cache = new byte[1024];
	 		int index = -1;
	 		
	 		while( (index = inputStr.read(cache)) != -1) {
	 			
	 			out.write(cache,0,index);
	 		}
	 		
	 	}
	 	
	 	resp.sendRedirect("view_images");
	}
}
