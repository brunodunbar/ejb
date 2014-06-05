package ejb.sandbox.webservice;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ejb.sandbox.TimeOfDayBean;

@WebService
public class Time {
	@EJB
	private TimeOfDayBean timeOfDay;

	@WebMethod(operationName = "timeOfDay")
	public String timeOfDay() {
		return timeOfDay.timeOfDay();
	}
}