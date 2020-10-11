package bean;

import java.io.Serializable;

public class ItemBean implements Comparable<ItemBean> , Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int itemId;
private String item;
private String itemCode;
private int itemPrice;
private String userEamil;

/**
 * @param itemId
 * @param item
 * @param itemCode
 * @param intPrice
 */
public ItemBean(int itemId, String item, String itemCode, int itemPrice) {
	super();
	this.itemId = itemId;
	this.item = item;
	this.itemCode = itemCode;
	this.itemPrice = itemPrice;
}
/**
 * @return the itemId
 */
public int getItemId() {
	return itemId;
}
/**
 * @param itemId the itemId to set
 */
public void setItemId(int itemId) {
	this.itemId = itemId;
}
/**
 * @return the item
 */
public String getItem() {
	return item;
}
/**
 * @param item the item to set
 */
public void setItem(String item) {
	this.item = item;
}
/**
 * @return the itemCode
 */
public String getItemCode() {
	return itemCode;
}
/**
 * @param itemCode the itemCode to set
 */
public void setItemCode(String itemCode) {
	this.itemCode = itemCode;
}
/**
 * @return the intPrice
 */
public int getItemPrice() {
	return itemPrice;
}
/**
 * @param intPrice the intPrice to set
 */
public void setItmePrice(int intPrice) {
	this.itemPrice = intPrice;
}
@Override
public String toString() {
	return "ItemBean [itemId=" + itemId + ", item=" + item + ", itemCode=" + itemCode + ", intPrice=" + itemPrice + "]";
}
@Override
public int compareTo(ItemBean o) {
	// TODO Auto-generated method stub
	if(this.itemId>o.itemId)
		return 1;
	else if(this.itemId<o.itemId)
		return -1;
	else
		return 0;
}
}
