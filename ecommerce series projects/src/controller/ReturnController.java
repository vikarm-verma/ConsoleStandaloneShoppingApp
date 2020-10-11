package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import service.ItemService;
import streamspack.AppendingObjectInputStream;
import streamspack.AppendingObjectOutputStream;

public class ReturnController extends DataProcessing {
	boolean flag = false, itemFlag = true;
	String itemCode = "", proceed = "", email = "";;
	int itemQuantity = 0, invoiceNo = 0;
	Scanner s = new Scanner(System.in);
	ArrayList<ItemService> al = new ArrayList<>();
	ArrayList<ItemService> al2 = new ArrayList<>();
	Iterator<ItemService> itr;
	ItemService us;
	File userFileInput = new File("datafiles/UserItemDetails.txt");
	File userFileOutput = new File("datafiles/UserItemDetails.txt");
	File returningFileInput = new File("datafiles/UserReturningItemDetails.txt");
	File returningFileOutput = new File("datafiles/UserReturningItemDetails.txt");
	FileOutputStream fos;
	AppendingObjectOutputStream aoos;
	FileInputStream fis = null;
	AppendingObjectInputStream aois = null;

//clearing all arraylists before using
	
	public ReturnController() throws IOException {
		al.clear();
		al2.clear();
		flag = true;
		if (!returningFileInput.exists()) {
			returningFileInput.createNewFile();
		}

	}

//this will read file object if found there is no data in file ,will return back to last menu else move ahead	
	
	public boolean creatingReadingObjectInstances() {
		try {
			fis = new FileInputStream(userFileInput);
			aois = new AppendingObjectInputStream(fis);
			if (fis.available() == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("no data in file");
		}
		return flag;

	}

//this will visit current user's purchased items if any else will return back to main menu	
	
	public void visitingUserItemObject() {
		al.clear();
		al2.clear();
		try {
			if (!userFileInput.exists()) {
				userFileInput.createNewFile();
				return;
			} else {
				while (fis.available() > 0) {
					al = (ArrayList<ItemService>) aois.readObject();
					itr = al.iterator();
					{
						while (itr.hasNext()) {
							us = itr.next();

							if (LoginController.email.equalsIgnoreCase(us.getUserEmail())) {
								System.out.println(us.getInvoiceNo() + "\t\t" + us.getUserEmail() + "\t\t"
										+ us.getItemName() + "\t\t" + us.getItemCode() + "\t\t" + us.getItemPrice()
										+ "\t\t" + us.getItemQuantity() + "\t\t" + us.getItemTotal() + "\t\t"
										+ us.getItemPurchasingDate());
							}
							al2.add(us);
						}
					}
				}
			}
			al.clear();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				aois.close();
			} // for saving while creating file if it is not created
			catch (NullPointerException | IOException e) {

			}
		}

	}

	// this will take item code from user and save that one into returning item file
	
	public void returningUserItemObject() {
		try {
			while (flag) {
				if (al2.size() == 0) {
					System.out.println("no item to show".toUpperCase());
					return;
				} else {
					System.out.println("\nwrite item code... for last menu press enter ".toUpperCase());
					itemCode = s.nextLine();
					if (itemCode.isEmpty()) {
						return;
					}
				}
				flag = false;
			}
			if (flag == false) {
				itr = al2.iterator();
				int i = 0;
				while (itr.hasNext()) {
					us = itr.next();
					if (itemCode.equals(us.getItemCode())
							&& LoginController.email.equalsIgnoreCase(us.getUserEmail())) {
						i++;
						if (i == 1) {
							try {
								itr.remove();
								System.out.println("item code removed...saving  your returned item".toUpperCase());
								boolean append = returningFileOutput.exists();
								fos = new FileOutputStream(returningFileOutput, append);
								aoos = new AppendingObjectOutputStream(fos);
								aoos.writeObject(us);
								aoos.flush();
								aoos.close();
								System.out.println("...returning items saved ".toUpperCase());
								flag = false;
								break;
							} catch (Exception e) {
								System.out.println("issue in saving returning item " + e);
							}
						}
					} else {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// will save items list back to user item file
	
	public void savingUserItemObjectAgain() {
		if (flag == false) {
			try {
				System.out.println("saving your remaining items".toUpperCase());
				fos = new FileOutputStream(userFileOutput);
				aoos = new AppendingObjectOutputStream(fos);
				aoos.writeObject(al2);
				aoos.flush();
				aoos.close();
				System.out.println("...remaining items saved ".toUpperCase());
			} catch (Exception e) {
				System.out.println("issue in saving returning item".toUpperCase());
			}

		}
		al.clear();
	}

	// will read user's returning items
	
	public boolean readFromItemReturningDetails() {
		try {

			fis = new FileInputStream(returningFileInput);
			aois = new AppendingObjectInputStream(fis);
			if (fis.available() == 0) {
				flag = false;
			} else {
				System.out.println("INVOICE NO\tEMAIL\t\tITEM NAME\tITEM CODE\tITEM PRICE\tITEM QUANTITY\t"
						+ "ITEM TOTAL\tPURCHASED DATE\t");
				while (fis.available() > 0) {
					us = (ItemService) aois.readObject();
					if (LoginController.email.equals(us.getUserEmail()))
						System.out.println(us.getInvoiceNo() + "\t\t" + us.getUserEmail() + "\t\t" + us.getItemName()
								+ "\t\t" + us.getItemCode() + "\t\t" + us.getItemPrice() + "\t\t" + us.getItemQuantity()
								+ "\t\t" + us.getItemTotal() + "\t\t" + us.getItemPurchasingDate());
				}
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				aois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}