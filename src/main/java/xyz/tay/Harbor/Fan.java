package xyz.tay.Harbor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/fan")
public class Fan {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String blankFan() {
	return "fans for nothing...";
	}
	
@GET @Path("/login/{fanUN}/{fanPass}")
@Produces(MediaType.TEXT_PLAIN)
public String getFanLogin(@PathParam("fanUN") String userName,
		@PathParam("fanPass") String password) {
	DBConnection conn = new DBConnection();
	return conn.getLogin(userName, password);
}


}