package sg.edu.nus.iss.vmcs.maintenance;

import sg.edu.nus.iss.vmcs.store.Store;

public class CoinDisplay extends Display {

	private static final long serialVersionUID = 1L;

	public String TITLE = "Quantity of Coins Available";

	public CoinDisplay(MaintenanceController maintenanceController) {
		super(maintenanceController);
		populateLengthAnStoreItem(Store.CASH);
		setTITLE(TITLE);
		populateButtonItemDisplay();
		addListener("Coin Display Listener", maintenanceController);
	}

}
