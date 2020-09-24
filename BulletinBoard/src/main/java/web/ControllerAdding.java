package web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import model.Ad;
import model.User;
import service.AdEngine;
import service.UserEngine;

@Controller
@Scope("request")
public class ControllerAdding {

	@Autowired
	private Ad ad;

	@Autowired
	private AdEngine adDB;

	@RequestMapping(value = "/adding", method = RequestMethod.GET)
	public String getGetAddingnPage(HttpSession session, ModelMap model) {

		return "adding";
	}

	@RequestMapping(value = "/adding", method = RequestMethod.POST)
	public String getPostAddingPage(HttpSession session, ModelMap model) {

		return "adding";
	}

	@RequestMapping(value = "/adding", method = RequestMethod.POST, params = { "title", "textDescription", "lastName" })
	public String getPostAddingPage(@RequestParam("title") String title,
			@RequestParam("textDescription") String textDescription, @RequestParam("lastName") String lastName,
			HttpSession session, @RequestParam("file") CommonsMultipartFile file, ModelMap model) {
		System.out.println("Starting");
		ad.setTitle(title);
		ad.setTextDescription(textDescription);
		ad.setIdUser((User) session.getAttribute("currentUser"));

		byte[] contents = file.getBytes();
		ad.setImage(contents);

		adDB.createAd(ad);

		model.addAttribute("creation", "made");

		return "adding";
	}

}
