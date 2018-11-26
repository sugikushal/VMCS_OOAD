package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;

public class CoinButtonBuilder implements Builder {
	
	private StoreItem storeItem;
	private CashStoreItem cashStoreItem;
	private StoreObject storeObject;
	private Coin coin;
	private String coinName;
	private int coinValue;
	private double coinWeight;
	
	@Override
	public void setStoreItem(StoreItem storeItem) {
		this.storeItem = storeItem;
	}

	@Override
	public void setStoreItemType() {
		this.cashStoreItem = (CashStoreItem)storeItem;
	}

	@Override
	public void setStoreObject() {
		this.storeObject = cashStoreItem.getContent();
	}

	@Override
	public void setObjectProperties() {
		System.out.println("Inside coin input builder");
		this.coin = (Coin)storeObject;
		this.coinName = coin.getName();
		this.coinValue = coin.getValue();
		this.coinWeight = coin.getWeight();
		
	}
	
	public CoinButton getResult() {
		return new CoinButton(coinName,coinValue,coinWeight);
	}

}
