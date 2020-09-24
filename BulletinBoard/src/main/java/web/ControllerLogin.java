package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.UserEngine;

@Controller
@Scope("request")
public class ControllerLogin {

	@Autowired
	private User user;

	@Autowired
	private UserEngine userDB;

	private boolean showForm;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getGetLoginPage(HttpSession session, HttpServletResponse httpServletResponse) {
		if (session.getAttribute("keyUser") == null) {
			showForm = true;
			session.setAttribute("showForm", showForm);
			return "login";
		} else {
			showForm = false;
			try {
				httpServletResponse.sendRedirect("/BulletinBoard/personalCabinet");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "personalCabinet";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getPostLoginPage(HttpSession session, HttpServletResponse httpServletResponse) {
		if (session.getAttribute("keyUser") == null) {
			showForm = true;
			session.setAttribute("showForm", showForm);
			return "login";
		} else {
			showForm = false;
			try {
				httpServletResponse.sendRedirect("/BulletinBoard/personalCabinet");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "personalCabinet";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "logout" })
	public String getPostLoginPage(@RequestParam("logout") String logout, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		if (logout != null) {
			session.invalidate();
			session = request.getSession(true);
			showForm = false;

			session.removeAttribute("access");
			session.removeAttribute("currentUser");

		}

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "email", "password" })
	public String getPostLoginPage(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, HttpServletResponse httpServletResponse) {

		if (email != null || password != null) {

			user.setEmail(email);
			user.setPassword(password);

			if (userDB.getAccess(user).equals("Successfully logged")) {

				session.setAttribute("keyUser", "active");

				session.setAttribute("access", userDB.getAccess(user));
				User currentUser = userDB.getUserByLogin(user.getEmail());
				System.out.println("Start " + currentUser);
				session.setAttribute("currentUser", currentUser);
				try {
					httpServletResponse.sendRedirect("/BulletinBoard/personalCabinet");
					return "personalCabinet";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else {

			try {
				httpServletResponse.sendRedirect("/BulletinBoard/login");
				return "personalCabinet";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "login";
	}

}
