package tw.com.ws;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestRestful {
	@GET
	public String testHello() {
		return "{\"value\":\"hello\"}";
	}
	@GET
	@Path("add")
	public String add(@QueryParam("a") int a,@QueryParam("b")int b) {
		
		return "{\"result\":"+(a+b)+"}";
		
	}
	
	@POST
	@Path("login")
	public String login(@FormParam("account") String account,
						@FormParam("password") String password) {
		
		String result = account+":"+password;
		return "{\"result\":\"" +result+"\"}";
		
	}

	
	@PUT
	@Path("update/{id}")
	public String update(@PathParam("id")  int id) {
		return "{\"id\":,"+id+"}";
		
	}
}
