package xyz.tay.Harbor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/home")
public class Home {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String blankFan() {
	return "fans for nothing...";
	}
	
	@GET @Path("/userHomes/{fanUN}/{fanPass}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFanHome(@PathParam("fanUN") String userName,
			@PathParam("fanPass") String password) {
		DBConnection conn = new DBConnection();
		return conn.getFanHomes(userName, password);
	}
	@POST @Path("/addHome")
	@Produces(MediaType.TEXT_PLAIN)
	public String addHome(@QueryParam("userName") String userName, @QueryParam("password") String password,
			@QueryParam("homeName") String homeName, @QueryParam("homeAddress") String homeAddress,
			@QueryParam("homeAddressTwo") String homeAddressTwo, @QueryParam("homeZip") int homeZip,
			@QueryParam("homeCity") String homeCity, @QueryParam("homeState") String homeState,
			@QueryParam("homeCountry") String homeCountry, @QueryParam("homeLat") float homeLat,
			@QueryParam("homeLng") float homeLng, @QueryParam("homePhoto") String homePhoto) {
		DBConnection conn = new DBConnection();
		return conn.addHome(userName, password, homeName, homeAddress, homeAddressTwo, homeZip, 
				homeCity, homeState, homeCountry, homeLat, homeLng, homePhoto);
	}

}