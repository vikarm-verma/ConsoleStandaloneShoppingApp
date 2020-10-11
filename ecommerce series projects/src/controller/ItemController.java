package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import bean.ItemBean;
import bean.LoginBean;
import service.ItemService;
import streamspack.AppendingObjectOutputStream;

public class ItemController {
	static Map<ItemBean, String> map = new TreeMap<>();
	static int invoiceNo = 100, choice, jacketQuantity, jeansQuantity, shirtQuantity, jacketTotal, jeansTotal,
			shirtTotal, grandTotal, grandQuantity;
	static String userEmail;
	static Scanner s = new Scanner(System.in);
	static ArrayList<ItemService> al = new ArrayList<>();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static LoginBean lb = new LoginBean();

	public static void setItems() {
		map.put(new ItemBean(1, "Jacket", "Ja1", 20), "Ja1");
		map.put(new ItemBean(2, "Jeans", "Je1", 10), "Je1");
		map.put(new ItemBean(3, "Shirt", "Sh1", 20), "Sh1");
	}

	public static Map<ItemBean, String> getItem() {
		for (Map.Entry<ItemBean, String> entry : map.entrySet()) {
		}
		return map;
	}

	public static void showItems() throws FileNotFoundException, ClassNotFoundException, IOException {
		al.clear();
		int invoiceNo = 100, choice = 0, jacketQuantity = 0, jeansQuantity = 0, shirtQuantity = 0, jacketTotal = 0,
				jeansTotal = 0, shirtTotal = 0, grandTotal = 0, grandQuantity = 0, jacketTotalQuantity = 0,
				jeansTotalQuantity = 0, shirtTotalQuantity = 0;
		boolean flag = true;
		while (flag) {
			System.out.println("\nStandalone Ecommerce App\r\n"
					+ "	+===============================================+\r\n"
					+ "	|	Items		Item Code	Price	|\r\n" + "	|	1.Jacket	Ja1		20$	|\r\n"
					+ "	|	2.Jeans		Je1		10$	|\r\n" + "	|	3.Shirt		Sh1		5$	|\r\n"
					+ "	|	4.EXIT					|\r\n" + "	+===============================================+\n");
			try {
				choice = 0;
				System.out.println("\nenter your choice ".toUpperCase());
				choice = s.nextInt();
			} catch (Exception e) {
				System.out.println("\nenter correct input".toUpperCase());
				flag = true;
			}
			s.nextLine();

			switch (choice) {
			case 1:
				for (Map.Entry<ItemBean, String> entry : getItem().entrySet()) {
					if (choice == entry.getKey().getItemId()) {
						System.out.println("\nIts a nice... ".toUpperCase() + entry.getKey().getItem().toUpperCase());
						jacketQuantity = 1;
						jacketTotalQuantity += 1;
						jacketTotal = jacketTotalQuantity * entry.getKey().getItemPrice();
						System.out.println("item :".toUpperCase() + entry.getKey().getItem()
								+ "\nquantity :".toUpperCase() + jacketQuantity + " \namount :".toUpperCase()
								+ jacketTotal + "$ \n...purchase more ?\n".toUpperCase());
						if (jacketTotal > 0) {
							userEmail = LoginController.email;
							al.add(new ItemService(invoiceNo + 1, 1, userEmail, entry.getKey().getItemId(),
									entry.getKey().getItem(), entry.getKey().getItemCode(),
									entry.getKey().getItemPrice(), jacketQuantity, entry.getKey().getItemPrice(),
									new Date()));
						}
					}

				}
				break;
			case 2:
				for (Map.Entry<ItemBean, String> entry : getItem().entrySet()) {
					if (choice == entry.getKey().getItemId()) {
						System.out.println("\nIts a nice..." + entry.getKey().getItem().toUpperCase());
						jeansQuantity = 1;
						jeansTotalQuantity += 1;
						jeansTotal = jeansTotalQuantity * entry.getKey().getItemPrice();
						System.out.println("item :".toUpperCase() + entry.getKey().getItem()
								+ "\nquantity :".toUpperCase() + jeansQuantity + "\namount :".toUpperCase() + jeansTotal
								+ "$ \n...purchase more ?\n".toUpperCase());
						if (jeansTotal > 0) {
							userEmail = LoginController.email;
							al.add(new ItemService(invoiceNo + 1, 1, userEmail, entry.getKey().getItemId(),
									entry.getKey().getItem(), entry.getKey().getItemCode(),
									entry.getKey().getItemPrice(), jeansQuantity, entry.getKey().getItemPrice(),
									new Date()));
						}
					}

				}
				break;
			case 3:
				for (Map.Entry<ItemBean, String> entry : getItem().entrySet()) {
					if (choice == entry.getKey().getItemId()) {
						System.out.println("\nIts a nice ..." + entry.getKey().getItem().toUpperCase());
						shirtQuantity = 1;
						shirtTotalQuantity += 1;
						shirtTotal = shirtTotalQuantity * entry.getKey().getItemPrice();
						System.out.println("Item :".toUpperCase() + entry.getKey().getItem()
								+ "\nquantity :".toUpperCase() + shirtQuantity + "\namount :".toUpperCase() + shirtTotal
								+ "$ \n...purchase more ?\n".toUpperCase());
						if (shirtTotal > 0) {
							userEmail = LoginController.email;
							al.add(new ItemService(invoiceNo + 1, 1, userEmail, entry.getKey().getItemId(),
									entry.getKey().getItem(), entry.getKey().getItemCode(),
									entry.getKey().getItemPrice(), shirtQuantity, entry.getKey().getItemPrice(),
									new Date()));
						}
					}

				}
				break;
			case 4:
				grandTotal = jacketTotal + jeansTotal + shirtTotal;
				grandQuantity = jacketQuantity + jeansQuantity + shirtQuantity;
				if (grandTotal != 0) {
					System.out.println("\n\t\t+==============Standalone Ecommerece App Invoice================+");
					System.out.println("\t\t|Customer Email: ".toUpperCase() + userEmail + " Date: ".toUpperCase()
							+ sdf.format(new Date()) + "\t|");
					System.out.println("\t\t|Invoice no :" + (invoiceNo + 1) + "\t\t\t\t\t\t|");
					System.out.println("\t\t|---------------------------------------------------------------|");
					System.out.println("\t\t|SR.NO\tITEMS\tITEM CODE\tPRICE\tQUANTITY\tTOTAL\t|");
					System.out.println("\t\t|1\tJacket\tJa1\t\t20$\t".toUpperCase() + jacketTotalQuantity + "\t\t"
							+ jacketTotal + "$\t|");
					System.out.println("\t\t|2\tJeans\tJe1\t\t10$\t".toUpperCase() + jeansTotalQuantity + "\t\t"
							+ jeansTotal + "$\t|");
					System.out.println("\t\t|3\tShirt\tSh1\t\t20$\t".toUpperCase() + shirtTotalQuantity + "\t\t"
							+ shirtTotal + "$\t|");
					System.out.println("\t\t|---------------------------------------------------------------|");
					System.out.println("\t\t|Total = " + grandTotal + "$\t\t\t\t\t\t\t|".toUpperCase());
					System.out.println("\t\t|Thanks for visiting\t\t\t\t\t\t|".toUpperCase());
					System.out.println("\t\t+===============================================================+\n");

					File file = new File("datafiles/UserItemDetails.txt");
					boolean append = file.exists();
					AppendingObjectOutputStream out = new AppendingObjectOutputStream(
							new FileOutputStream(file, append));
					out.writeObject(al);
					out.flush();
					out.close();
					System.out.println("\nyour item details are saved !!!".toUpperCase());
					al.clear();
				}
				flag = false;
				break;
			}
		}
	}

	public static ArrayList<ItemService> getAllItems() {
		Iterator<ItemService> i = al.listIterator();
		while (i.hasNext()) {
			ItemService us = i.next();
		}
		return al;
	}
}
