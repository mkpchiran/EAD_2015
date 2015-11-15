package com.ead.myproj;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ead.myproj.controller.UserJpaController;
import com.ead.myproj.db.EMF;
import com.ead.myproj.entity.User;

@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet {
	@Resource
	UserTransaction userTransaction;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		registerUser(req, resp);

	}

	private void registerUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String password = req.getParameter("password1");
		String email = req.getParameter("email");
		String phoneno = req.getParameter("phoneno");
		String address = req.getParameter("address");

		User newUser = new User(fullname, username, password, email, address,
				phoneno, "Admin");

		UserJpaController userJpaController = new UserJpaController(EMF.get());
		if (userJpaController.findUser(username).isEmpty()) {
			userJpaController.create(newUser);
			System.out.println("User Creataed");
			req.setAttribute("message_success", "Account successfully created. Plaease login.");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			req.setAttribute("message_error", "Username exist, Please choose another username!");
			req.getRequestDispatcher("signup.jsp").forward(req, resp);
		}

	}

}
