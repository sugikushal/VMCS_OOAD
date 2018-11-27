package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.DrinksStoreItem;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;

public class DrinkSelectionItemBuilder extends Builder {
	private StoreItem storeItem;
	private DrinksStoreItem drinkStoreItem;
	private StoreObject storeObject;
	private DrinksBrand drinkBrand;
	private int id;
	
	@Override
	public void buildPartStoreItem(StoreItem storeItem) {
		this.storeItem = storeItem;
		
	}
	
	@Override
	public void buildPartStoreItemType() {
		this.drinkStoreItem = (DrinksStoreItem)storeItem;
	}

	@Override
	public void buildPartStoreObject() {
		this.storeObject = drinkStoreItem.getContent();
		
	}

	@Override
	public void buildPartObjectProperties() {
		System.out.println("Inside Drink selection Builder");
		this.drinkBrand = (DrinksBrand)storeObject;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public DrinkSelectionItem getResult() {
		return new DrinkSelectionItem(id,drinkBrand.getName(),drinkBrand.getPrice(),drinkStoreItem.getQuantity(),true,false);
	}

}
