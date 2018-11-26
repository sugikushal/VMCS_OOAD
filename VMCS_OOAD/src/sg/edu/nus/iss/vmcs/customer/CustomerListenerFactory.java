package sg.edu.nus.iss.vmcs.customer;

import java.awt.event.ActionListener;

public class CustomerListenerFactory {
	public static ActionListener createListener(TransactionController txnCtrl, String type,int i) {
		ActionListener listen = null;
		switch(type) {
		case "Terminate Button Listener":
			listen =new TerminateButtonListener(txnCtrl);
			break;
		case "Coin Input Listener":
			listen = new CoinInputListener(txnCtrl.getCoinReceiver());
			break;
		case "Drink Selection Listener":
			listen = new DrinkSelectionListener(txnCtrl,i);
			break;
		default:
			//todo exception handling
			
		}
		return listen;
		
	}
}
