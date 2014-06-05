package ejb.sandbox.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ejb.sandbox.TipBean;

/**
 * Serviço RESTFul, o endereço é http://localhost:8080/ejb-sandbox/rest/tipoftheday
 * 
 * @author Bruno
 *
 */

@Path("/tipoftheday")
@Stateless
public class TipOfTheDay {
	
	@EJB
	TipBean tips;

	@GET
	@Produces("text/html")
	public String processGet() {
		return getTip();
	}

	@POST
	@Produces("text/html")
	public String processPost() {
		return getTip();
	}

	private String getTip() {
		return tips.getTip();
	}
}