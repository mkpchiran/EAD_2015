package com.ead.myproj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ead.myproj.constants.EngineAttributes.*;
import com.ead.myproj.constants.EngineAttributes;
import com.ead.myproj.constants.Params;
import com.ead.myproj.controller.ItemJpaController;
import com.ead.myproj.controller.exceptions.PreexistingEntityException;
import com.ead.myproj.controller.exceptions.RollbackFailureException;
import com.ead.myproj.db.EMF;
import com.ead.myproj.entity.Item;
import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
public class NewItemServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		addItem(req, resp);
	}

	private void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String model = (String) req.getParameter(Params.REQUEST_PARAMS_MODEL);
		Integer manufacture = Integer.parseInt(req.getParameter(Params.REQUEST_PARAMS_MANUFACTURE));
		Integer capacity = Integer.parseInt(req.getParameter(Params.REQUEST_PARAMS_CAPACITY));
		Integer fueltype = Integer.parseInt(req.getParameter(Params.REQUEST_PARAMS_FULETYPE));
		Integer cylinders = Integer.parseInt(req.getParameter(Params.REQUEST_PARAMS_CYLINDERS));
		Integer mounting = Integer.parseInt(req.getParameter(Params.REQUEST_PARAMS_MOUNTING));
		Float price = Float.parseFloat(req.getParameter(Params.REQUEST_PARAMS_PRICE));
		Integer quantity = Integer.parseInt(req.getParameter(Params.REQUEST_PARAMS_QUANTITY));
		String description = (String) req.getParameter(Params.REQUEST_PARAMS_DISCRIPTION);
		
		
		resp.getWriter().println(model);
		resp.getWriter().println(manufacture);
		resp.getWriter().println(capacity);
		resp.getWriter().println(fueltype);
		resp.getWriter().println(cylinders);
		resp.getWriter().println(mounting);
		resp.getWriter().println(price);
		resp.getWriter().println(quantity);
		resp.getWriter().println(description);
		

		Item item = new Item();
		item.setModel(model);
		item.setManufacture(manufacture);
		item.setCapacity(capacity);
		item.setFuel(fueltype);
		item.setCylinders(cylinders);
		item.setMounting(mounting);
		item.setPrice(price);
		item.setStatus(1);
		item.setDescription(description);
		item.setPhoto("");
	

		ItemJpaController controller = new ItemJpaController(EMF.get());
		try {
			controller.create(item);
		} catch (PreexistingEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	/*	item.setModel(model);
		item.setManufacture(Integer.parseInt(manufacture));
		item.setCategory((Capacity.values()[Integer.parseInt(capacity)].toString());
		item.setFuletype(Fuletype.values()[Integer.parseInt(fueltype)].toString());
		item.setCylenders(Cylenders.values()[Integer.parseInt(cylinders)].toString());
		item.setMountingType(MountingType.values()[Integer.parseInt(mounting)].toString());
		item.setPrice(price);
		item.setQuantity(Integer.parseInt(quantity));
		item.setDiscription(discription);

		InventoryController controller = new InventoryController();
		controller.addItem(item);
		
		resp.getWriter().print("Successfully added");*/

	}

}
