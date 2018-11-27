/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.system;


import java.io.IOException;

import sg.edu.nus.iss.vmcs.store.*;

/**
 * This control object manages the initialization of the DrinksStore
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */

public class DrinkPropertyLoader extends StoreProperty {

	private static final String NAME_LABEL     = "Name";
	private static final String PRICE_LABEL    = "Price";
	private static final String QUANTITY_LABEL = "Quantity";
	private static final String STORE_TYPE = "Drink";
	private String filename;

	/**
	 * This constructor creates an instance of the DrinkPropertyLoader object.
	 * @param filen the file name of the drink property file.
	 */
	public DrinkPropertyLoader(String filename) {
		super(filename);
		this.filename=filename;
	}

	public void setPropertyType(int type) {
		switch(type) {
		case 0:
			setPropertyLoader(new FilePropertyLoader(filename));
			break;
		default:
			setPropertyLoader(new FilePropertyLoader(filename));
		}
	}

	/**
	 * This method reads the data from the hash table and creates a DrinkStoreItem.
	 * @param index the index of the store item.
	 * @return StoreItem the store item of the given index.
	 */
	public StoreItem getItem(int index) {
		int idx = index + 1;
		DrinksBrand brand = new DrinksBrand();

		String name = new String(NAME_LABEL + idx);
		String value = getPropertyLoader().getValue(name);
		brand.setName(value);

		name = new String(PRICE_LABEL + idx);
		value = getPropertyLoader().getValue(name);
		brand.setPrice(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = getPropertyLoader().getValue(name);
		int qty = Integer.parseInt(value);

		DrinksStoreItem item = new DrinksStoreItem(brand, qty);
		return item;

	}

	/**
	 * This method updates the hash table with the data from the DrinkStoreItem.
	 * @param index the index of the store item.
	 * @param drinksItem the store item of the given index.
	 */
	public void setItem(int index, StoreItem drinksItem) {
		int idx = index + 1;

		DrinksStoreItem item = (DrinksStoreItem) drinksItem;
		DrinksBrand brand = (DrinksBrand) item.getContent();
		String itn = new String(NAME_LABEL + idx);
		getPropertyLoader().setValue(itn, brand.getName());

		itn = new String(PRICE_LABEL + idx);
		getPropertyLoader().setValue(itn, String.valueOf(brand.getPrice()));

		itn = new String(QUANTITY_LABEL + idx);
		getPropertyLoader().setValue(itn, String.valueOf(item.getQuantity()));

	}
	

	public void setNumOfItems(int numItems) {
		getPropertyLoader().setNumOfItems(numItems);
		
	}

	
	public int getNumOfItems() {
		return getPropertyLoader().getNumOfItems();
	}
	
	public void saveProperty() throws IOException {
		getPropertyLoader().saveProperty();
		
	}

	
	public void initialize() throws IOException {
		getPropertyLoader().initialize();
		
	}
	
}//End of class DrinkPropertyLoader