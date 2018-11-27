package sg.edu.nus.iss.vmcs.system;

import java.io.IOException;

import sg.edu.nus.iss.vmcs.store.PropertyLoader;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public abstract class StoreProperty {
	
	private static final String NAME_LABEL     = "Name";
	private static final String QUANTITY_LABEL = "Quantity";
	private PropertyLoader property=null;
	private String storeType;
	
	public StoreProperty(String storeType) {
		//this.property=property;
		this.storeType=storeType;
	}
	
	public void setPropertyLoader(PropertyLoader property) {
		this.property=property;	
		
	}
	public PropertyLoader getPropertyLoader() {
		return property;
	}


}
