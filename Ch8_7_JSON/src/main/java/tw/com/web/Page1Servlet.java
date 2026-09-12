package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	
	private String getJson() {
		String json ="""
					{
				     "firstName": "John",
				     "lastName": "Smith",
				     "sex": "male",
				     "age": 25,
				     "address": 
				     {
				         "streetAddress": "21 2nd Street",
				         "city": "New York",
				         "state": "NY",
				         "postalCode": "10021"
				     },
				     "phoneNumber": 
				     [
				         {
				           "type": "home",
				           "number": "212 555-1234"
				         },
				         {
				           "type": "fax",
				           "number": "646 555-4567"
				         }
				     ]
				 }
				""";
		return json;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = getJson();
		System.out.println(json);
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,Object> addrMap = 
				objMapper.readValue(json,Map.class);
		System.out.println(addrMap);
		Map<String,Object> johnAddrMap = (Map)addrMap.get("address");
		String  city = (String) johnAddrMap.get("city");
		PrintWriter out =  resp.getWriter();
		out.println("City:"+city);
		List<Map<String,Object>> photpList = 
				(List) addrMap.get("phoneNumber");
		for (Map<String,Object>phoneMap : photpList) {
			System.out.println(phoneMap);
		}
		
	}
}
