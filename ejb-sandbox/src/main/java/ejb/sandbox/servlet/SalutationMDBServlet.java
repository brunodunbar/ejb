package ejb.sandbox.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/SalutationMDBServlet" })
public class SalutationMDBServlet extends HttpServlet {

	private static final long serialVersionUID = -5034481483428435424L;

	@Resource(mappedName = "java:/ConnectionFactory")
	private QueueConnectionFactory queueConnectionFactory;

	@Resource(mappedName = "java:/queue/salutationQueue")
	private Queue queue;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			sendMessage();
			out.println("OK");
		} finally {
			out.flush();
			out.close();
		}
	}

	private void sendMessage() {
		try {
			String message = "Salutation generated";
			Connection connection = queueConnectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = (MessageProducer) session
					.createProducer(queue);
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText(message);
			messageProducer.send(textMessage);
			Logger.getLogger("SalutationLog").log(Level.WARNING,
					"Message sent successfully", "Message sent successfully2");
		} catch (JMSException ex) {
			Logger.getLogger("SalutationLog").log(Level.WARNING,
					"JMSException in SalutationServlet",
					"JMSException in SalutationServlet");
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