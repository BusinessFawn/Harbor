package xyz.tay.Harbor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	
}
