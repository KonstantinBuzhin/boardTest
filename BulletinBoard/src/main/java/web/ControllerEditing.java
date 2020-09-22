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

import service.ClientEngine;

@Controller
@Scope("request")
public class ControllerEditing {

//	@Autowired
//	private Client client;
//
//	@Autowired
//	private ClientEngine clientDB;

	private boolean showForm;

	@RequestMapping(value = "/editing", method = RequestMethod.GET)
	public String getGetLoginPage(HttpSession session) {
//		if (session.getAttribute("keyUser") == null) {
//			showForm = false;
//		} else {
//			showForm = true;
//		}
//		session.setAttribute("showForm", showForm);
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
		return "editing";
	}

	@RequestMapping(value = "/editing", method = RequestMethod.POST)
	public String getPostLoginPage(HttpSession session) {
//		if (session.getAttribute("keyUser") == null) {
//			showForm = false;
//		} else {
//			showForm = true;
//		}
//		session.setAttribute("showForm", showForm);
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
		return "editing";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "loginOut" })
//	public void doLogOut(@RequestParam("loginOut") String loginOut, HttpSession session, HttpServletRequest request,
//			HttpServletResponse response) {
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
//		if (loginOut != null) {
//			session.invalidate();
//			session = request.getSession(true);
//			showForm = false;
//			session.setAttribute("showForm", showForm);
//			session.removeAttribute("keyUser");
//			session.removeAttribute("currentUserName");
//
//			if (session.getAttribute("CART_VALUE") == null) {
//				session.setAttribute("CART_VALUE", 0);
//			}
//			PrintWriter out;
//			try {
//				out = response.getWriter();
//				out.write("SIGN IN");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "logOut" })
//	public String getPostLoginPage(@RequestParam("logOut") String logOut, HttpSession session,
//			HttpServletRequest request, HttpServletResponse response) {
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
//		if (logOut != null) {
//			session.invalidate();
//			session = request.getSession(true);
//			showForm = false;
//			session.setAttribute("showForm", showForm);
//			session.removeAttribute("access");
//			session.removeAttribute("keyUser");
//			session.removeAttribute("currentUserName");
//
//			if (session.getAttribute("CART_VALUE") == null) {
//				session.setAttribute("CART_VALUE", 0);
//			}
//			return "login";
//		}
//
//		return "login";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "login", "password" })
//	public String getPostLoginPage(@RequestParam("login") String login, @RequestParam("password") String password,
//			HttpSession session, HttpServletRequest request) {
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
//
//		if (login != null || password != null) {
//			client = new Client();
//			client.setLogin(login);
//			client.setPassword(password);
//			request.setAttribute("currentUser", client);
//			session.setAttribute("access", clientDB.getAccess(client));
//			if (clientDB.getAccess(client).equals("Successfully logged")) {
//
//				session.setAttribute("keyUser", "sessionCheck");
//				showForm = false;
//				session.setAttribute("showForm", showForm);
//				session.setAttribute("access", clientDB.getAccess(client));
//			}
//			if (session.getAttribute("keyUser") != null) {
//				session.setAttribute("currentUserName",
//						"" + clientDB.getClientByLogin(client.getLogin()).getNameClient());
//				session.setAttribute("currentUserLogin", "" + client.getLogin());
//				showForm = (session.getAttribute("keyUser") != null) ? true : false;
//				session.setAttribute("showForm", showForm);
//			}
//
//			return "login";
//		} else {
//
//			getGetLoginPage(session);
//		}
//
//		return "login";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String getPostLoginPage(HttpSession session, HttpServletRequest request) {
//		if (session.getAttribute("keyUser") == null) {
//			showForm = false;
//		}
//		session.setAttribute("showForm", showForm);
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
//
//		return "login";
//	}

}
