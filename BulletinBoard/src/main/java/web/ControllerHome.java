package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import service.ClientEngine;

@Controller
public class ControllerHome {

//	@Autowired
//	private ProductEngine productDB;

	private static final String CART = "CART";
	private static final String CART_VALUE = "CART_VALUE";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getGetHomePage(HttpSession session, ModelMap model) {

//		List<Product> listProduct = productDB.getProducts();
//		List<Product> startlistProduct = new ArrayList<Product>();
//		if (session.getAttribute("productsQnt") == null) {
//			
//			Iterator<Product> listProductIterator = listProduct.iterator();
//			int index = 0;
//			while (listProductIterator.hasNext()) {
//				Product product = listProductIterator.next();
//				if (index <= 9) {
//					startlistProduct.add(listProduct.get(index));
//				}
//				index++;
//			}
//		} else {
//			Iterator<Product> listProductIterator = listProduct.iterator();
//			while (listProductIterator.hasNext()) {
//				Product product = listProductIterator.next();
//				
//				if (product.getIdProduct() <= (Integer) (session.getAttribute("productsQnt"))) {
//					
//					startlistProduct.add(product);
//				}
//			}
//		}
//		if (session.getAttribute("listProducts") != null) {
//			session.removeAttribute("listProducts");
//			
//		}
//		model.addAttribute("listProducts", startlistProduct);
//		Map<Product, Integer> listСartProducts;
//		if (session.getAttribute(CART_VALUE) == null) {
//			session.setAttribute(CART_VALUE, 0);
//		}
//		if (session.getAttribute(CART) != null) {
//			listСartProducts = (Map) session.getAttribute(CART);
//			model.addAttribute("listСartProducts", listСartProducts);
//		} else {
//			listСartProducts = new HashMap<Product, Integer>();
//			model.addAttribute("listСartProducts", listСartProducts);
//
//		}
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}
//
//		return "index";
//	}
//
//	@RequestMapping(value = "/", method = RequestMethod.POST, params = { "quantityProducts" })
//	public String getPostHomePage(HttpSession session, ModelMap model,
//			@RequestParam("quantityProducts") String quantityProducts) {
//
//		List<Product> listProduct = productDB.getProducts();
//		List<Product> startlistProduct = new ArrayList<Product>();
//		Iterator<Product> listProductIterator = listProduct.iterator();
//		int qntProducts = Integer.valueOf(quantityProducts) + 10;
//		int index = 0;
//		while (listProductIterator.hasNext()) {
//			Product product = listProductIterator.next();
//			
//			if (index <= (qntProducts-1)) {
//				startlistProduct.add(listProduct.get(index));
//			}
//			index++;
//		}
//
//		model.addAttribute("listProducts", startlistProduct);
//
//		if (session.getAttribute("CART_VALUE") == null) {
//			session.setAttribute("CART_VALUE", 0);
//		}

		return "index";
	}

}
