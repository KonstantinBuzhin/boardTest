package web;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Ad;
import service.AdEngine;

@Controller
public class ControllerHome {

	@Autowired
	private AdEngine adDB;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getGetHomePage(HttpSession session, ModelMap model) {
		List<Ad> listAds = adDB.getAds();

		if (listAds.size() > 10) {
			List<Ad> currentListAds = new ArrayList<Ad>();
			Iterator<Ad> iterator = listAds.iterator();
			while (iterator.hasNext() && currentListAds.size() < 10) {
				currentListAds.add(iterator.next());
			}

			model.addAttribute("listAds", currentListAds);
			session.setAttribute("listAds", listAds);
			List<String> listPages = new ArrayList<String>();
			listPages.add("1");
			int k = 1;

			int existedIndex = 10;
			int counter = 10;
			try {
				while (iterator.hasNext()) {
					listAds.get(existedIndex);
					k++;
					listPages.add("" + k);
					existedIndex = counter * k;
					iterator.next();
				}
			} catch (IndexOutOfBoundsException e) {
				model.addAttribute("quantityPages", listPages);
			}
			model.addAttribute("currentPage", "1");
			model.addAttribute("quantityPages", listPages);
		} else {
			List<String> listPages = new ArrayList<String>();
			listPages.add("1");
			model.addAttribute("lastPage", "lastPage");
			model.addAttribute("quantityPages", listPages);
			model.addAttribute("listAds", listAds);

		}
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String getPostHomePage(HttpSession session, ModelMap model) {
		List<Ad> listAds = adDB.getAds();

		if (listAds.size() > 10) {
			List<Ad> currentListAds = new ArrayList<Ad>();
			Iterator<Ad> iterator = listAds.iterator();
			while (iterator.hasNext() && currentListAds.size() < 10) {
				currentListAds.add(iterator.next());
			}
			model.addAttribute("listAds", currentListAds);
			session.setAttribute("listAds", listAds);
			List<String> listPages = new ArrayList<String>();
			listPages.add("1");
			int k = 1;

			int existedIndex = 10;
			int counter = 10;
			try {
				while (iterator.hasNext()) {
					listAds.get(existedIndex);
					k++;
					listPages.add("" + k);
					existedIndex = counter * k;
					iterator.next();
				}
			} catch (IndexOutOfBoundsException e) {
				model.addAttribute("quantityPages", listPages);
			}
			model.addAttribute("currentPage", "1");
			model.addAttribute("quantityPages", listPages);
		} else {
			List<String> listPages = new ArrayList<String>();
			listPages.add("1");
			model.addAttribute("lastPage", "lastPage");
			model.addAttribute("quantityPages", listPages);
			model.addAttribute("listAds", listAds);

		}
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, params = { "page" })
	public String getGetReviewsPageNumber(@RequestParam("page") String numberPage, HttpSession session,
			ModelMap model) {
		if (numberPage != null) {
			if (session.getAttribute("listAds") != null) {
				model.addAttribute("currentPage", numberPage);
				List<Ad> listAds = (List<Ad>) session.getAttribute("listAds");

				List<Ad> currentListAds = new ArrayList<Ad>(10);
				Iterator<Ad> iterator = listAds.iterator();

				int existedIndex = 10 * Integer.valueOf(numberPage);
				int counter = 10;

				while (iterator.hasNext() && currentListAds.size() <= 10) {
					try {
						currentListAds.add(listAds.get(existedIndex - counter));
						counter = counter - 1;
						iterator.next();

					} catch (IndexOutOfBoundsException e) {

						if (currentListAds.size() < 10) {
							model.addAttribute("lastPage", "lastPage");
						}
						break;
					}
				}
				model.addAttribute("listAds", currentListAds);

				if (listAds.size() > 10) {

					List<String> listPages = new ArrayList<String>();
					listPages.add("1");
					int k = 1;

					int existedIndexProd = 10;
					int counterPage = 10;
					try {
						while (iterator.hasNext()) {
							listAds.get(existedIndexProd);
							k++;
							listPages.add("" + k);
							existedIndexProd = counterPage * k;
							iterator.next();
						}
					} catch (IndexOutOfBoundsException e) {
						model.addAttribute("quantityPages", listPages);
					}

				} else {
					List<String> listPages = new ArrayList<String>();
					listPages.add("1");
					model.addAttribute("quantityPages", listPages);

				}
			} else {
				System.out.println("Something is wrong");
			}

		}

		return "index";
	}

	@RequestMapping(value = "/imageOut", method = RequestMethod.GET, params = { "number" })
	public String getImage(HttpServletResponse resp, @RequestParam("number") int number) {
		java.io.OutputStream out = null;

		java.io.InputStream stream = new ByteArrayInputStream(adDB.getAdById((long) number).getImage());
		try {
			out = resp.getOutputStream();
			resp.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			byte[] buffer = new byte[4048];

			int c;

			while ((c = stream.read(buffer)) > 0) {
				out.write(buffer, 0, c);
			}
			out.close();
			stream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

}
