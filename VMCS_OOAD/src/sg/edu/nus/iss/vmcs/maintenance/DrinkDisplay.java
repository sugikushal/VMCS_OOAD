package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class DrinkDisplay extends Display {

	public String TITLE = "Quantity of Drinks Available";
	private static final long serialVersionUID = 1L;

	private LabelledDisplay price;

	public DrinkDisplay(MaintenanceController maintenanceController) {
		super(maintenanceController);

		this.setLayout(new BorderLayout());

		populateLengthAnStoreItem(Store.DRINK);
		setTITLE(TITLE);

		populateButtonItemDisplay();

		addListener("Drink Display Listener", maintenanceController);

		price = new LabelledDisplay("Brand Price", 4, LabelledDisplay.FLOW);

		ActionListener priceDisplayListen = MaintenanceListenerFactory.createListener("Price Display Listener",
				maintenanceController);
		price.addListener(priceDisplayListen);

		Panel tp = new Panel();
		tp.setLayout(new FlowLayout(FlowLayout.CENTER));
		tp.add(getBi());
		setCurIdx(0);
		this.add("Center", tp);
		this.add("South", price);
		price.setEnabled(false);

	}

	/**
	 * This method returns the LabelledDisplay of the price.
	 * 
	 * @return LabelledDisplay of the price.
	 */
	public LabelledDisplay getPriceDisplay() {
		return price;
	}

	public void setActive(boolean st) {
		super.setActive(st);
		price.setActive(st);
	}

	public void displayQty(int idx, int qty) throws VMCSException {
		super.displayQty(idx, qty);
		price.setEnabled(true);
	}

}
