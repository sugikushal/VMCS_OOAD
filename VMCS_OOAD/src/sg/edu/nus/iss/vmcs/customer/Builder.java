package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.StoreItem;

public interface Builder {
	
	public void buildPartStoreItem(StoreItem storeItem);
	public void buildPartStoreItemType();
	public void buildPartStoreObject();
	public void buildPartObjectProperties();
	
}
