package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.event.ActionListener;

public class MaintenanceListenerFactory {
	public static ActionListener createListener(String type, MaintenanceController mainCtrl) {
		ActionListener listener = null;
		switch(type) {
		case "Password Listener":
			listener = new PasswordListener(mainCtrl.getAccessManager());
			break;
		case "Total Cash Button Listener":
			listener = new TotalCashButtonListener(mainCtrl);
			break;
		case "Transfer Cash Button Listener":
			listener = new TransferCashButtonListener(mainCtrl);
			break;
		case "Exit Button Listener":
			listener = new ExitButtonListener(mainCtrl);
			break;
		case "Coin Display Listener":
			listener = new CoinDisplayListener(mainCtrl);
			break;
		case "Drink Display Listener":
			listener = new DrinkDisplayListener(mainCtrl);
			break;
		case "Price Display Listener":
			listener = new PriceDisplayListener(mainCtrl);
			break;
		default:
			//todo exception handling

		}
		return listener;
	}
}
