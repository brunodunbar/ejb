package ejb.sandbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.sandbox.Salutation;

@WebServlet(urlPatterns = { "/SalutationJNDIServlet" })
public class SalutationJNDIServlet extends HttpServlet {

	private static final long serialVersionUID = -5034481483428435424L;

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
					+ getSalutation().getFormalSalutation("Sherlock Holmes")
					+ "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.flush();
			out.close();
		}
	}

	private Salutation getSalutation() {
		try {
			Context context = new InitialContext();
			return (Salutation) context
					.lookup("java:global/ejb-sandbox/Salutation");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
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