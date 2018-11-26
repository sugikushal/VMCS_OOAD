package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.DrinksStoreItem;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;

public class DrinkSelectionItemBuilder implements Builder {
	private StoreItem storeItem;
	private DrinksStoreItem drinkStoreItem;
	private StoreObject storeObject;
	private DrinksBrand drinkBrand;
	private String drinkName;
	private int price;
	private int quantity;
	private int id;
	
	@Override
	public void setStoreItem(StoreItem storeItem) {
		this.storeItem = storeItem;
		
	}
	
	@Override
	public void setStoreItemType() {
		this.drinkStoreItem = (DrinksStoreItem)storeItem;
	}

	@Override
	public void setStoreObject() {
		this.storeObject = drinkStoreItem.getContent();
		
	}

	@Override
	public void setObjectProperties() {
		System.out.println("Inside Drink selection Builder");
		this.drinkBrand = (DrinksBrand)storeObject;
		this.drinkName = drinkBrand.getName();
		this.price = drinkBrand.getPrice();
		this.quantity = drinkStoreItem.getQuantity();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public DrinkSelectionItem getResult() {
		return new DrinkSelectionItem(id,drinkName,price,quantity,true,false);
	}

}
