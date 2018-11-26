package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.StoreItem;

public class Director {
	private Builder builder = null;
	
	public Director (Builder builder) {
		this.builder = builder;
	}
	
	public void constructBuilder( StoreItem storeItem) {
		builder.setStoreItem(storeItem);
		builder.setStoreItemType();
		builder.setStoreObject();
		builder.setObjectProperties();
		System.out.println("Inside Director");
	}

}
