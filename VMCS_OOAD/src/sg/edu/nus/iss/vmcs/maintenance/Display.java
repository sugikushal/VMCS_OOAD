package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.Panel;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class Display extends Panel {

	private StoreController storeCtrl;
	private MaintenanceController maintanenceController;
	private ButtonItemDisplay buttonItemDisplay;
	private int length;
	private int curIdx;

	StoreItem[] items;

	public String TITLE;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Display(MaintenanceController maintenanceController) {
		maintanenceController = maintenanceController;
		storeCtrl = maintanenceController.getMainController().getStoreController();
	}

	public void populateButtonItemDisplay() {
		buttonItemDisplay = new ButtonItemDisplay(TITLE, items, length);
		buttonItemDisplay.clear();
		this.add(buttonItemDisplay);
	}

	public void addListener(String listener, MaintenanceController maintenanceController) {
		ActionListener actionlistener = MaintenanceListenerFactory.createListener(listener, maintenanceController);
		buttonItemDisplay.addListener(actionlistener);
	}
	
	public void populateLengthAnStoreItem(Integer storeType) {
		length = storeCtrl.getStoreSize(storeType);
		items = getStoreCtrl().getStoreItems(storeType);
	}

	public void setActive(boolean st) {
		buttonItemDisplay.setActive(st);
	}

	public void displayQty(int idx, int qty) throws VMCSException {
		curIdx = idx;
		buttonItemDisplay.clear();
		buttonItemDisplay.displayQty(idx, qty);
	}

	public int getCurIdx() {
		return curIdx;
	}

	public StoreController getStoreCtrl() {
		return storeCtrl;
	}

	public void setStoreCtrl(StoreController storeCtrl) {
		this.storeCtrl = storeCtrl;
	}

	public MaintenanceController getmCtrl() {
		return maintanenceController;
	}

	public void setmCtrl(MaintenanceController mCtrl) {
		this.maintanenceController = mCtrl;
	}

	public ButtonItemDisplay getBi() {
		return buttonItemDisplay;
	}

	public void setBi(ButtonItemDisplay bi) {
		this.buttonItemDisplay = bi;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCurIdx(int curIdx) {
		this.curIdx = curIdx;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

}
