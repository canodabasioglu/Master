package com.odabasioglu.utility;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.odabasioglu.data.TbCategory;
import com.odabasioglu.data.TbProduct;
import com.odabasioglu.manager.CategoryManager;
import com.odabasioglu.manager.ProductManager;

/**
 * Servlet implementation class for Servlet: ImageServlet
 * 
 */
public class ImageServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ImageServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// gelen deger hep product Id parametre ismine göre degisiyor
		String id = request.getParameter("id");
		// thumbnail , category yada picture gelir
		String type = request.getParameter("type");

		// rgb: blob resim verisi
		byte[] rgb = null;
		TbProduct product = null;
		TbCategory category = null;

		if (id != null) {			

			if (type.equals("thumbnail")) {
				ProductManager productManager = new ProductManager();
				product = productManager.getProduct(Integer.valueOf(id));
				rgb = product.getThumbnailSmall();
			} else if (type.equals("picture")) {
				ProductManager productManager = new ProductManager();
				product = productManager.getProduct(Integer.valueOf(id));
				rgb = product.getThumbnail();
			} else if (type.equals("category")) {
				CategoryManager categoryManager = new CategoryManager();
				category = categoryManager.getCategoryById(Integer.valueOf(id));
				rgb = category.getThumbnail();
			}

		}

		if (rgb != null) {
			response.setContentType("image/jpeg");
			OutputStream stream = response.getOutputStream();
			stream.write(rgb);
			stream.flush();
		} else {
			response.setContentType("text");
			response.getWriter().write("attribute byArr not found");
		}
	}

}