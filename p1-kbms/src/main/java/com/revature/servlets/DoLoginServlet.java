package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;

@WebServlet(urlPatterns = { "/dashboard" })
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 4645721142572801102L;
	private UserDao userDao = (UserDao) new UserDaoImpl();
	public static String userName;
	
	public DoLoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		userName = request.getParameter("userName");
		String password = request.getParameter("password");

		User user = null;
		boolean hasError = false;
		String errorString = null;

		if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			

			user = userDao.findUser(userName, password);
			if (user == null) {
				hasError = true;
				errorString = "User Name or password invalid";
			}

		}
		// If error, forward to /WEB-INF/views/_login.jsp
		if (hasError) {
			user = new User();
			user.setLoginId(userName);
			user.setPassword(password);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);

			// Forward to /WEB-INF/views/_login.jsp
			getServletContext().getRequestDispatcher("/WEB-INF/views/_login.jsp").forward(request, response);
		}

		// If no error
		// Store user information in Session
		// And redirect to correct home page.
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("userIs", user);
			getServletContext().getRequestDispatcher("/WEB-INF/views/_dashboard.jsp").forward(request, response);
			}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}