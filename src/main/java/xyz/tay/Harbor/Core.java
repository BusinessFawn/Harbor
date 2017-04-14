package xyz.tay.Harbor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Core {
@GET
@Produces(MediaType.TEXT_PLAIN)
public String sayHtmlHello() {
return "Hello from Jersey";
}
}