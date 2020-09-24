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
public class ControllerRegistration {

	@Autowired
	private User user;

	@Autowired
	private UserEngine userDB;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getGetRegisterPage(HttpSession session) {

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, params = { "firstName", "lastName", "email",
			"password" })
	public String getPostRegisterPage(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session, ModelMap model) {

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);

		model.addAttribute("checkLogin", userDB.getCheckEmail(user));

		model.addAttribute("registration", userDB.getRegistration(user));

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String getPostRegisterPage(HttpSession session) {

		return "registration";
	}

}
