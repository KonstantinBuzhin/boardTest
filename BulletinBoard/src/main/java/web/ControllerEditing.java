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
@Scope("session")
public class ControllerEditing {

	@Autowired
	private User user;

	@Autowired
	private UserEngine userDB;

	@RequestMapping(value = "/editing", method = RequestMethod.GET)
	public String getGetEditingPage(HttpSession session, ModelMap model) {
		if (session.getAttribute("currentUser") != null) {
			User user = (User) session.getAttribute("currentUser");
			System.out.println(user);
			model.addAttribute("firstName", user.getFirstName());
			model.addAttribute("lastName", user.getLastName());
			model.addAttribute("email", user.getEmail());
			if (session.getAttribute("updating") != null) {
				model.addAttribute("updating", session.getAttribute("updating"));
				session.removeAttribute("updating");
			}

		}
		return "editing";
	}

	@RequestMapping(value = "/editing", method = RequestMethod.POST)
	public String getPostEditingPage(HttpSession session, ModelMap model) {
		if (session.getAttribute("currentUser") != null) {
			User user = (User) session.getAttribute("currentUser");
			System.out.println(user);
			model.addAttribute("firstName", user.getFirstName());
			model.addAttribute("lastName", user.getLastName());
			model.addAttribute("email", user.getEmail());
		}
		return "editing";
	}

	@RequestMapping(value = "/editing", method = RequestMethod.POST, params = { "firstName", "email", "password" })
	public String getPostEditingPage(@RequestParam("firstName") String firstName, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, HttpServletRequest request,
			ModelMap model) {

		if (firstName != null && email != null && password != null) {
			user = (User) session.getAttribute("currentUser");

			userDB.updateClient(user, firstName, email, password);
			session.setAttribute("currentUser", userDB.getUserById(user.getIdUser()));
			session.setAttribute("updating", "active");

		}

		return "editing";
	}

}
