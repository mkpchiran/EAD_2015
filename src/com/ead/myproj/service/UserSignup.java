package com.ead.myproj.service;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Param;

import com.ead.myproj.constants.Params;
import com.ead.myproj.controller.SistercompanyJpaController;
import com.ead.myproj.controller.exceptions.PreexistingEntityException;
import com.ead.myproj.controller.exceptions.RollbackFailureException;
import com.ead.myproj.db.EMF;
import com.ead.myproj.entity.Sistercompany;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


public class UserSignup extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		authenticate(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		authenticate(req, resp);
	}

	private void authenticate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String username = request.getParameter(Params.REQUEST_PARAM_USERNAME);
		String password = request.getParameter(Params.REQUEST_PARAM_PASSWORD);
		String companyname = request.getParameter(Params.REQUEST_PARAM_EMAIL);
		String email = request.getParameter(Params.REQUEST_PARAM_COMPANY_NAME);
		String address = request.getParameter(Params.REQUEST_PARAM_ADDRESS);
		String phoneno = request.getParameter(Params.REQUEST_PARAM_PHONE_NO);

		if (username != "" && password != "" && companyname != ""
				&& email != "" && address != "" && phoneno != "") {
			
			
			Sistercompany company  =  new Sistercompany();
			company.setCompanyName(companyname);
			company.setUsername(username);
			company.setPassword(password);
			company.setEmail(email);
			company.setAddress(address);
			company.setPhone(phoneno);
			response.getWriter().println("user successfully registered"+ company.getCompanyId());
			SistercompanyJpaController controller = new SistercompanyJpaController(EMF.get());
			try {
				response.getWriter().println("user successfully registered"+ company.getCompanyId());
				controller.create(company);
				response.getWriter().println("user successfully registered" + company.getCompanyId());
			}catch (RollbackFailureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Key k = KeyFactory.createKey("Sistercompany", 4890627720347648L);
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();	
		 try {
			Entity entity = datastore.get(k);
			response.getWriter().println(entity.toString());
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		} else {
			response.setContentType("application/json");
			JSONObject object = new JSONObject();
			try {
				object.put("status", "failed");
				object.put("message", "username or password incorrect");
			} catch (JSONException e) {
				e.printStackTrace();
			}

			response.getWriter().println(object);
		}
	}

}
