package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.StoreItem;

public class Director {
	private Builder builder = null;
	
	public Director (Builder builder) {
		this.builder = builder;
	}
	
	public void construct( StoreItem storeItem) {
		builder.buildPartStoreItem(storeItem);
		builder.buildPartStoreItemType();
		builder.buildPartStoreObject();
		builder.buildPartObjectProperties();
		System.out.println("Inside Director");
	}

}
