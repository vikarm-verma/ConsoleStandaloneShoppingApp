package service;

import java.io.Serializable;
import java.util.Date;

public class ItemReturnService implements Serializable {
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
	private int itemUpdatedQuantity;
	private int itemUpdatedTotal;
	private Date itemReturningDate;
	/**
	 * @param invoiceNo
	 * @param userId
	 * @param userEmail
	 * @param itemId
	 * @param itemName
	 * @param itemCode
	 * @param itemPrice
	 * @param itemUpdatedQuantity
	 * @param itemUpdatedTotal
	 * @param itemReturningDate
	 */
	public ItemReturnService(int invoiceNo, int userId, String userEmail, int itemId, String itemName, String itemCode,
			int itemPrice, int itemUpdatedQuantity, int itemUpdatedTotal, Date itemReturningDate) {
		super();
		this.invoiceNo = invoiceNo;
		this.userId = userId;
		this.userEmail = userEmail;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.itemPrice = itemPrice;
		this.itemUpdatedQuantity = itemUpdatedQuantity;
		this.itemUpdatedTotal = itemUpdatedTotal;
		this.itemReturningDate = itemReturningDate;
	}
	/**
	 * @return the invoiceNo
	 */
	public int getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	 * @return the itemUpdatedQuantity
	 */
	public int getItemUpdatedQuantity() {
		return itemUpdatedQuantity;
	}
	/**
	 * @param itemUpdatedQuantity the itemUpdatedQuantity to set
	 */
	public void setItemUpdatedQuantity(int itemUpdatedQuantity) {
		this.itemUpdatedQuantity = itemUpdatedQuantity;
	}
	/**
	 * @return the itemUpdatedTotal
	 */
	public int getItemUpdatedTotal() {
		return itemUpdatedTotal;
	}
	/**
	 * @param itemUpdatedTotal the itemUpdatedTotal to set
	 */
	public void setItemUpdatedTotal(int itemUpdatedTotal) {
		this.itemUpdatedTotal = itemUpdatedTotal;
	}
	/**
	 * @return the itemReturningDate
	 */
	public Date getItemReturningDate() {
		return itemReturningDate;
	}
	/**
	 * @param itemReturningDate the itemReturningDate to set
	 */
	public void setItemReturningDate(Date itemReturningDate) {
		this.itemReturningDate = itemReturningDate;
	}
	@Override
	public String toString() {
		return "ItemReturnService [invoiceNo=" + invoiceNo + ", userId=" + userId + ", userEmail=" + userEmail
				+ ", itemId=" + itemId + ", itemName=" + itemName + ", itemCode=" + itemCode + ", itemPrice="
				+ itemPrice + ", itemUpdatedQuantity=" + itemUpdatedQuantity + ", itemUpdatedTotal=" + itemUpdatedTotal
				+ ", itemReturningDate=" + itemReturningDate + "]";
	}
	
}
