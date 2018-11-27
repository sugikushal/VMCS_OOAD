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
	
	@Override
	public void buildPartStoreItem(StoreItem storeItem) {
		this.storeItem = storeItem;
	}

	@Override
	public void buildPartStoreItemType() {
		this.cashStoreItem = (CashStoreItem)storeItem;
	}

	@Override
	public void buildPartStoreObject() {
		this.storeObject = cashStoreItem.getContent();
	}

	@Override
	public void buildPartObjectProperties() {
		System.out.println("Inside coin input builder");
		this.coin = (Coin)storeObject;
	
	}
	
	public CoinButton getResult() {
		return new CoinButton(coin.getName(),coin.getValue(),coin.getWeight());
	}

}
