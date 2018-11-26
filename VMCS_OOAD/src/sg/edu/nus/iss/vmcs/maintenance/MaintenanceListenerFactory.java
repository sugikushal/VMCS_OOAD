package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.event.ActionListener;

public class MaintenanceListenerFactory {
	public static ActionListener createListener(String type, MaintenanceController maintanenceControl) {
		ActionListener listener = null;
		switch (type) {
		case "Password Listener":
			listener = new PasswordListener(maintanenceControl.getAccessManager());
			break;
		case "Total Cash Button Listener":
			listener = new TotalCashButtonListener(maintanenceControl);
			break;
		case "Transfer Cash Button Listener":
			listener = new TransferCashButtonListener(maintanenceControl);
			break;
		case "Exit Button Listener":
			listener = new ExitButtonListener(maintanenceControl);
			break;
		case "Coin Display Listener":
			listener = new CoinDisplayListener(maintanenceControl);
			break;
		case "Drink Display Listener":
			listener = new DrinkDisplayListener(maintanenceControl);
			break;
		case "Price Display Listener":
			listener = new PriceDisplayListener(maintanenceControl);
			break;
		default:
			// todo exception handling

		}
		return listener;
	}
}
