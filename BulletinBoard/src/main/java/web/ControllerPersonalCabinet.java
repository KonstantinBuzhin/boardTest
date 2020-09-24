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

import service.UserEngine;

@Controller
public class ControllerPersonalCabinet {


	@RequestMapping(value = "/personalCabinet", method = RequestMethod.GET)
	public String getGetPersonalCabinetPage(HttpSession session) {

		return "personalCabinet";
	}

	@RequestMapping(value = "/personalCabinet", method = RequestMethod.POST)
	public String getPostPersonalCabinetPage(HttpSession session) {

		return "personalCabinet";
	}


}
