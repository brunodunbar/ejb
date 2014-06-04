package ejb.sandbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.sandbox.Salutation;

@WebServlet(urlPatterns = { "/SalutationServlet" })
public class SalutationServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5034481483428435424L;

	@EJB
	private Salutation salutation;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet SalutationServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>"
					+ salutation.getFormalSalutation("Sherlock Holmes")
					+ "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.flush();
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}