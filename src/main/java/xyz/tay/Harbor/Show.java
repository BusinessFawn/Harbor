package xyz.tay.Harbor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/show")
public class Show {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String blankFan() {
	return "fans for nothing...";
	}
	
	@GET @Path("/inTownWithoutConfirmation/{fanUN}/{fanPass}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFanLogin(@PathParam("fanUN") String userName,
			@PathParam("fanPass") String password) {
		DBConnection conn = new DBConnection();
		return conn.showsInTownWithoutHome(userName, password);
	}

	@GET @Path("/{showID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getShow(@PathParam("showID") int showID) {
		DBConnection conn = new DBConnection();
		return conn.getShowByID(showID);
	}

	@POST @Path("/offerHome")
	@Produces(MediaType.TEXT_PLAIN)
	public String offerHome(@QueryParam("userName") String userName, @QueryParam("password") String password,
			@QueryParam("homeID") int homeID, @QueryParam("bandID") int bandID, @QueryParam("showID") int showID) {
		
		System.out.println(userName + " " + password);
		DBConnection conn = new DBConnection();
		return conn.offerHomeConfirmation(userName, password, homeID, bandID, showID);
	}



}