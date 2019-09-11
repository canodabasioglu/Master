package com.odabasioglu.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.odabasioglu.data.TbAddress;
import com.odabasioglu.data.dao.TbAddressDAO;

public class AddressManager {

	private static Logger loggingManager =
		Logger.getLogger(AddressManager.class.getName());
	private static TbAddressDAO addressDAO;

	public List listAddress(Integer userId) {
		List listAddress = null;
		try {
			listAddress =
				TbAddressDAO.getInstance().find(
					"from TbAddress address where address.Users.Id = "
						+ userId
						+ " order by address.Id desc");

			if (listAddress == null) {
				listAddress = new ArrayList();
			}
			loggingManager.debug("Address Manager Info : List Address ");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Address Manager Exception : List Address : " + e);
		}

		return listAddress;
	}

	public static String getAddressDisplay(Integer addressId) {
		String address = "";
		try {
			List addressList =
				TbAddressDAO.getInstance().find(
					"from TbAddress address where address.Id="
						+ addressId
						+ "");
			if (addressList != null) {
				TbAddress add = ((TbAddress) addressList.get(0));
				address= ""+add.getLine1()+" "+add.getLine2()+" "+add.getState()+" "+add.getCity()+" "+add.getPostalCode();
			}

			loggingManager.debug("Category Manager Info : Get Category ");
		} catch (Exception e)  {
			LogManager.logError(e.getMessage());
			loggingManager.error(
				"Category Manager Exception : Get Category : " + e);
		}
		return address;
	}

	/*public String getOrderAddress(Integer addressId) {
		TbAddress address = null;
		try {
			address = addressDAO.getAddress(addressId);
			loggingManager.debug("Address Manager Info : Get Address ");
		} catch (Exception e) {
			loggingManager.error(
				"Address Manager Exception : Get Address : " + e);
		}
	
		return address.getLine1()
			+ " "
			+ address.getLine2()
			+ " "
			+ address.getState()
			+ " "
			+ address.getCity()
			+ " "
			+ address.getCountry()
			+ " "
			+ address.getPostalCode();
	}
	*/
}
