/*
 * Created on Feb 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.odabasioglu.utility;

/**
 * @author Can
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PagerUtility {

	private static ResourceUtility resource =
		new ResourceUtility("application");
	public static final int DEFAULT_START_PAGE =
		Integer.parseInt(resource.getValue("startPaging"));
	public static final int DEFAULT_ITEMS_PER_PAGE =
		Integer.parseInt(resource.getValue("defaultPaging"));
	public static final int DEFAULT_ITEMS_LAST_VISIT =
		Integer.parseInt(resource.getValue("lastvisitSize"));

	public int totalItems; //Listeden 6
	public int totalPages; //Calculated
	public int itemsPerPage; //Set manually

	public int pageNumber;

	public int itemsStart;
	public int itemsEnd;

	/**
	 * @return
	 */
	public int getTotalPages() {
		return (int) Math.ceil(getTotalItems() / (double) getItemsPerPage());

	}

	public int setSelectedPageNumber(String selectedPageNumber) {

		this.pageNumber = DEFAULT_START_PAGE;
		if (selectedPageNumber != null) {

			try {
				this.pageNumber = Integer.parseInt(selectedPageNumber);
			} catch (NumberFormatException ignore) {

			}
		}
		setPageNumber(this.pageNumber);
		return this.pageNumber;
	}

	/**
	 * @return
	 */
	public int getItemsStart() {
		return ((getPageNumber() - 1) * getItemsPerPage());
	}

	/**
	 * @return
	 */
	public int getItemsEnd() {

		itemsEnd = getPageNumber() * getItemsPerPage();
		if (getTotalItems() < getPageNumber() * getItemsPerPage()) {
			itemsEnd = getTotalItems();
		}

		return itemsEnd;
	}

	/**
	 * @return
	 */
	public int getItemsPerPage() {

		if (itemsPerPage == 0) {
			itemsPerPage = DEFAULT_ITEMS_PER_PAGE;
		}

		return itemsPerPage;
	}

	/**
	 * @return
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @return
	 */
	public int getTotalItems() {
		return totalItems;
	}

	/**
	 * @param i
	 */
	public void setItemsEnd(int i) {
		itemsEnd = i;
	}

	/**
	 * @param i
	 */
	public void setItemsPerPage(int i) {

		itemsPerPage = i;

	}

	/**
	 * @param i
	 */
	public void setItemsStart(int i) {
		itemsStart = i;
	}

	/**
	 * @param i
	 */
	public void setPageNumber(int i) {
		pageNumber = i;
	}

	/**
	 * @param i
	 */
	public void setTotalItems(int i) {
		totalItems = i;
	}

	/**
	 * @return
	 */
	public static int getLastVisitSize(int size) {
		if (size > DEFAULT_ITEMS_LAST_VISIT) {
			return DEFAULT_ITEMS_LAST_VISIT;
		} else {
			return size;
		}

	}

}
