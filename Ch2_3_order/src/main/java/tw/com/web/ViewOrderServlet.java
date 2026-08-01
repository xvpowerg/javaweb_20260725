package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view_order")
public class ViewOrderServlet extends HttpServlet {
	
	private String getHtml(String order) {
		String html = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>訂單</title>\r\n"
				+ "<style>\r\n"
				+ "	table{\r\n"
				+ "		width:100%;\r\n"
				+ "		border-collapse:collapse;\r\n"
				+ "	}\r\n"
				+ "	th,\r\n"
				+ "	td {\r\n"
				+ "		padding:12px;\r\n"
				+ "		text-align:center;\r\n"
				+ "		border: 1px solid #b0bec5;\r\n"
				+ "	\r\n"
				+ "	}\r\n"
				+ "	th{\r\n"
				+ "		color:white;\r\n"
				+ "		background-color: #1976d2;		\r\n"
				+ "	}\r\n"
				+ "	/*偶數變色*/\r\n"
				+ "	tr:nth-child(even){\r\n"
				+ "		background-color: #e3f2fd;	\r\n"
				+ "	}\r\n"
				+ "	/*滑鼠移動到變色*/\r\n"
				+ "	tbody tr:hover{\r\n"
				+ "		background-color:#fff9c4;\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "</style>\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>我的訂單</h1>\r\n"
				+ "	<table border=\"1\">\r\n"
				+ "		<caption>訂單內容</caption>\r\n"
				+ "		<thead>\r\n"
				+ "			<tr>\r\n"
				+ "				<th>名稱</th>\r\n"
				+ "				<th>金額</th>\r\n"
				+ "				<th>時間</th>\r\n"
				+ "			</tr>		\r\n"
				+ "		</thead>\r\n"
				+ "		<tbody>\r\n"
				+ order
				+ "		</tbody>	\r\n"
				+ "	\r\n"
				+ "	</table>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		
		return html;
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		ArrayList<String>foodList= new ArrayList<String>();
		
		String order = "<tr>\r\n"
				+ "			<td>%s</td>\r\n"
				+ "			<td>%s</td>\r\n"
				+ "			<td>19:00-20:00</td>\r\n"
				+ "		</tr>";
		foodList.add("蘋果");
		foodList.add("香蕉");
		foodList.add("奇異果");
		foodList.add("鳳梨");
		String trhtml = "";
		for (int i = 0; i <foodList.size();i++) {
			trhtml += order.formatted(foodList.get(i),"25x6");
		}
		//作業利用table 寫一個99乘法表
		
		out.println(getHtml(trhtml));
	}
}
