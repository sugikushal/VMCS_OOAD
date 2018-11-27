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
 * This control object manages the initialization of the CashStore&#46;
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class CashPropertyLoader extends StoreProperty {

	private static final String NAME_LABEL     = "Name";
	private static final String WEIGHT_LABEL   = "Weight";
	private static final String VALUE_LABEL    = "Value";
	private static final String QUANTITY_LABEL = "Quantity";
	private static final String STORE_TYPE = "Cash";
	private String filename;
	

	/**
	 * This constructor creates an instance of CashPropertyLoader object.
	 * @param filen the name of the cash property file.
	 */
	public CashPropertyLoader(String filename) {
		
		super(filename);
		this.filename=filename;
		
	}
	
	public void setPropertyType(int type) throws IOException {
		switch(type) {
		case 0:
			setPropertyLoader(new FilePropertyLoader(filename));
			getPropertyLoader().initialize();
			break;
		default:
			setPropertyLoader(new FilePropertyLoader(filename));
		}
	}

	/**
	 * This method reads the data from the hash table and creates a CashStoreItem.
	 * @param index the index of the StoreItem.
	 * @return StoreItem the store item of the given index.
	 */
	public StoreItem getItem (int index) {
		int idx = index + 1;
		Coin coin = new Coin();

		String name = new String(NAME_LABEL + idx);
		String value = getPropertyLoader().getValue(name);
		coin.setName(value);

		name = new String(WEIGHT_LABEL + idx);
		value = getPropertyLoader().getValue(name);
		coin.setWeight(Double.parseDouble(value));

		name = new String(VALUE_LABEL + idx);
		value = getPropertyLoader().getValue(name);
		coin.setValue(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = getPropertyLoader().getValue(name);
		int qty = Integer.parseInt(value);

		CashStoreItem item = new CashStoreItem(coin, qty);
		return item;
	}

	/**
	 * This method updates the hash table with the data from the CashStoreItem.
	 * @param index the index of the item.
	 * @param cashItem the cash store item.
	 */
	public void setItem(int index, StoreItem cashItem) {
		int idx = index + 1;

		CashStoreItem item = (CashStoreItem) cashItem;
		Coin cn = (Coin) item.getContent();
		String itn = new String(NAME_LABEL + idx);

		getPropertyLoader().setValue(itn, cn.getName());

		itn = new String(WEIGHT_LABEL + idx);
		getPropertyLoader().setValue(itn, String.valueOf(cn.getWeight()));

		itn = new String(VALUE_LABEL + idx);
		getPropertyLoader().setValue(itn, String.valueOf(cn.getValue()));

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
}//End of class CashPropertyLoader