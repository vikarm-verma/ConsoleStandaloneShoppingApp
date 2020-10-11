package service;

import java.io.Serializable;
import java.util.Date;

public class ItemService implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int invoiceNo;	
private int userId;
private String userEmail;
private int itemId;
private String itemName;
private String itemCode;
private int itemPrice;
private int itemQuantity;
private int itemTotal;
private Date itemPurchasingDate;
/**
 * @param userId
 * @param userEmail
 * @param itemId
 * @param itemName
 * @param itemCode
 * @param itemPrice
 * @param itemQuantity
 * @param itemTotal
 * @param itemPurchasingDate
 */
public ItemService()
{
	
}
public ItemService(int invoiceNo,int userId, String userEmail, int itemId, String itemName, String itemCode, int itemPrice,
		int itemQuantity, int itemTotal, Date itemPurchasingDate) {
	super();
	this.invoiceNo=invoiceNo;
	this.userId = userId;
	this.userEmail = userEmail;
	this.itemId = itemId;
	this.itemName = itemName;
	this.itemCode = itemCode;
	this.itemPrice = itemPrice;
	this.itemQuantity = itemQuantity;
	this.itemTotal = itemTotal;
	this.itemPurchasingDate = itemPurchasingDate;
	
	
}
public int getInvoiceNo()
{
	return invoiceNo;
}
public void setInvoiceNo(int invoiceNo)
{
	this.invoiceNo=invoiceNo;
}
/**
 * @return the userId
 */
public int getUserId() {
	return userId;
}
/**
 * @param userId the userId to set
 */
public void setUserId(int userId) {
	this.userId = userId;
}
/**
 * @return the userEmail
 */
public String getUserEmail() {
	return userEmail;
}
/**
 * @param userEmail the userEmail to set
 */
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
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
 * @return the itemName
 */
public String getItemName() {
	return itemName;
}
/**
 * @param itemName the itemName to set
 */
public void setItemName(String itemName) {
	this.itemName = itemName;
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
 * @return the itemPrice
 */
public int getItemPrice() {
	return itemPrice;
}
/**
 * @param itemPrice the itemPrice to set
 */
public void setItemPrice(int itemPrice) {
	this.itemPrice = itemPrice;
}
/**
 * @return the itemQuantity
 */
public int getItemQuantity() {
	return itemQuantity;
}
/**
 * @param itemQuantity the itemQuantity to set
 */
public void setItemQuantity(int itemQuantity) {
	this.itemQuantity = itemQuantity;
}
/**
 * @return the itemTotal
 */
public int getItemTotal() {
	return itemTotal;
}
/**
 * @param itemTotal the itemTotal to set
 */
public void setItemTotal(int itemTotal) {
	this.itemTotal = itemTotal;
}
/**
 * @return the itemPurchasingDate
 */
public Date getItemPurchasingDate() {
	return itemPurchasingDate;
}
/**
 * @param itemPurchasingDate the itemPurchasingDate to set
 */
public void setItemPurchasingDate(Date itemPurchasingDate) {
	this.itemPurchasingDate = itemPurchasingDate;
}
@Override
public String toString() {
	return "UserService [invoiceNo="+invoiceNo +"userId=" + userId + ", userEmail=" + userEmail + ", itemId=" + itemId + ", itemName="
			+ itemName + ", itemCode=" + itemCode + ", itemPrice=" + itemPrice + ", itemQuantity=" + itemQuantity
			+ ", itemTotal=" + itemTotal + ", itemPurchasingDate=" + itemPurchasingDate + "]";
}

}
