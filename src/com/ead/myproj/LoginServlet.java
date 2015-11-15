package com.ead.myproj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ead.myproj.controller.UserJpaController;
import com.ead.myproj.db.EMF;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		userAuthenticate(req, resp);
	}

	private void userAuthenticate(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		String username, password;

		username = req.getParameter("username");
		password = req.getParameter("password");

		UserJpaController controller = new UserJpaController(EMF.get());

		if (controller.findUser(username, password).isEmpty()) {
			req.setAttribute("message_error", "Wrong username or password!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			return;
		} else {
			req.getSession().setAttribute("user", username);
			resp.sendRedirect("home.jsp");
		}

	}

}
