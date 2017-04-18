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
@Path("/band")
public class Band {

	@GET @Path("/{bandID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getShow(@PathParam("bandID") int bandID) {
		DBConnection conn = new DBConnection();
		return conn.getBandByID(bandID);
	}
	@GET @Path("/bandFromShow/{showID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBandFromShow(@PathParam("showID") int showID) {
		DBConnection conn = new DBConnection();
		return conn.getBandByShowID(showID);
	}
	@GET @Path("/getOffers/{fanUN}/{fanPass}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFanLogin(@PathParam("fanUN") String userName,
			@PathParam("fanPass") String password) {
		DBConnection conn = new DBConnection();
		return conn.getOffers(userName, password, 1);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addBand(@QueryParam("userName") String userName, @QueryParam("password") String password, @QueryParam("bandName") String bandName, @QueryParam("bandPhoto") String bandPhoto ) {
		DBConnection conn = new DBConnection();
		
		System.out.println("Adding band! " + userName + ", " + password + ", " + bandName + ", " + bandPhoto);
		
		return conn.addBand(userName, password, bandName, bandPhoto);
	}
	
}
