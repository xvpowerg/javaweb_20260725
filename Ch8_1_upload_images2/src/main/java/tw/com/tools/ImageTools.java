package tw.com.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class ImageTools {
	
	public static List<String>getImageFileNames()throws IOException{
		Path imageDir = Paths.get("C:","images");
		List<String> imagesList =  Files.list(imageDir).
				map(p->p.getFileName().toString()).
				collect(Collectors.toList());
		return imagesList;
	}
	
	public static void updateFile(InputStream inputStream,String fileName)
			throws FileNotFoundException,IOException{
			Path imagePath = Paths.get("C:","images",fileName);
			Files.copy(inputStream, imagePath,
					StandardCopyOption.REPLACE_EXISTING);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("C:\\MyFile\\onlineclass\\upload_images\\Donut.png");
		
		updateFile(fin,"Test.png");
		
		System.out.println("Hello!");
		try {
			List<String> imageList =  getImageFileNames();
			System.out.println(imageList);
		}catch(IOException ex) {
			System.out.println("ex"+ex);
		}
		
	}
	
	
	
}
