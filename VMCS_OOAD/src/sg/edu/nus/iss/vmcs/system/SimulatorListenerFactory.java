package sg.edu.nus.iss.vmcs.system;

import java.awt.event.ActionListener;

public class SimulatorListenerFactory {
	
	public static ActionListener createListener(String type,SimulationController simulationCtrl) {
		ActionListener listen = null;
		switch(type) {
		case "Begin Simulation":
			listen = new BeginSimulationButtonListener(simulationCtrl);
			break;
		case "End Simulation":
			listen = new EndSimulationButtonListener(simulationCtrl.getMainController());
			break;
		case "Activate Maintainer Panel":
			listen = new ActivateMaintainerPanelButtonListener(simulationCtrl);
			break;
		case "Activate Machinery Panel":
			listen = new ActivateMachineryPanelButtonListener(simulationCtrl);
			break;
		case "Activate Customer Panel":
			listen = new ActivateCustomerPanelButtonListener(simulationCtrl);
			break;
		default:
			//todo exception handling
			
		}
		return listen;
		
	}

}
