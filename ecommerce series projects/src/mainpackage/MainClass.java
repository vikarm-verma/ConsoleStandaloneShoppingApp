package mainpackage;

import java.io.IOException;
import java.util.Scanner;

import controller.ItemController;
import controller.LoginController;
import controller.RegisterController;
import controller.ReturnController;

public class MainClass {

	static void mainMenu() throws ClassNotFoundException, IOException {
		Scanner s = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		ReturnController rc = new ReturnController();
		while (flag) {
			System.out.println("\n		Standalone Ecommerce App\r\n"
					+ "	+===============================================+\r\n" + "	|	1.REGISTER				|\r\n"
					+ "	|	2.LOGIN					|\r\n" + "	|	3.BUY AN ITEM				|\r\n"
					+ "	|	4.RETURN AN ITEM			|\r\n" + "	|	5.EXIT					|\r\n"
					+ "	+===============================================+\n".toUpperCase());
			try {
				System.out.println("enter your choice".toUpperCase());
				choice = s.nextInt();
			} catch (Exception e) {
				flag = true;
			}
			s.nextLine();
			switch (choice) {
			case 1:
				RegisterController.setRegisterUser();
				if (RegisterController.getRegistrationStatus().equals("already registered!!!".toUpperCase())) {
					boolean flag1 = true;
					while (flag1) {
						System.out.println("\n	Standalone Ecommerce App\r\n"
								+ "	+===============================================+\r\n"
								+ "	|	1.LOGIN			 	2.EXIT	|\r\n"
								+ "	+===============================================+\n".toUpperCase());
						try {
							choice = 0;
							System.out.println("\nenter your choice".toUpperCase());
							choice = s.nextInt();

						} catch (Exception e) {
							flag1 = true;
						}
						s.nextLine();
						
						switch (choice) {
						case 1:
							boolean checkFlag = LoginController.checkCredentials();
							boolean flag2 = true;
							while (flag2) {
								if (checkFlag == true) {
									System.out.println("\n	Standalone Ecommerce App\r\n"
											+ "	+===============================================+\r\n"
											+ "	|	1.BUY AN ITEM				|\r\n"
											+ "	|	2.RETURN AN ITEM			|\r\n"
											+ " 	|	3.YOUR RETURNING ITEM LIST		|\r\n"
											+ "	|	4.EXIT					|\r\n"
											+ "	+===============================================+\n".toUpperCase());
									try {
										choice = 0;
										System.out.println("\nenter your choice".toUpperCase());
										choice = s.nextInt();
									} catch (Exception e) {
										flag2 = true;
									}
									s.nextLine();
									switch (choice) {
									case 1:
										ItemController.setItems();
										ItemController.showItems();
										checkFlag = true;
										break;
									case 2:
										
										boolean itemFlag = rc.creatingReadingObjectInstances();
										if (itemFlag) {
											rc.processingDataRequest();

										} else {
											System.out.println(
													"...you need to purchase item before returning\n".toUpperCase());
										}
										checkFlag = true;
										break;
									case 3:
										if (rc.readFromItemReturningDetails()) {

										} else {
											System.out.println("...you did not return any item\n".toUpperCase());
										}
										checkFlag = true;
										break;
									case 4:
										flag = true;
										flag2 = false;
										break;
									default:
										System.out.println("enter correct input\n".toUpperCase());
										flag2 = true;
									}
								} else if (checkFlag == false) {
									flag2 = false;
									flag = true;
								}
							}
							break;
						case 2:
							flag = true;
							flag1 = false;
							break;
						default:
							System.out.println("enter correct input\n".toUpperCase());
							flag1 = true;
						}
					}
				}
				break;
			case 2:
				boolean checkFlag = LoginController.checkCredentials();
				boolean flag2 = true;
				while (flag2) {
					if (checkFlag == true) {
						System.out.println("\n	Standalone Ecommerce App\r\n"
								+ "	+===============================================+\r\n"
								+ "	|	1.BUY AN ITEM				|\r\n" + "	|	2.RETURN AN ITEM			|\r\n"
								+ " 	|	3.YOUR RETURNING ITEM LIST		|\r\n"
								+ "	|	4.EXIT					|\r\n"
								+ "	+===============================================+\n".toUpperCase());
						try {
							choice = 0;
							System.out.println("\nenter your choice".toUpperCase());
							choice = s.nextInt();
						} catch (Exception e) {
							flag2 = true;
						}
						s.nextLine();
						switch (choice) {
						case 1:
							ItemController.setItems();
							ItemController.showItems();
							checkFlag = true;
							break;
						case 2:
							boolean itemFlag = rc.creatingReadingObjectInstances();
							if (itemFlag) {
								rc.processingDataRequest();

							} else {
								System.out.println("you need to purchase item before returning\n".toUpperCase());
							}
							checkFlag = true;
							break;
						case 3:
							if (rc.readFromItemReturningDetails()) {

							} else {
								System.out.println("you did not return any item\n".toUpperCase());
							}
							checkFlag = true;
							break;
						case 4:
							flag = true;
							flag2 = false;
							break;
						default:
							System.out.println("enter correct input\n".toUpperCase());
							flag2 = true;
						}
					} else if (checkFlag == false) {
						flag2 = false;
						flag = true;

					}
				}
				break;
			case 3:
				System.out
						.println("cannot buy !!! register[if new user]/login[if registered user] first\n".toUpperCase());
				flag = true;
				break;
			case 4:
				System.out.println(
						"cannot replace !!1register[if new user]/login[if registered user] first\n".toUpperCase());
				flag = true;
				break;
			case 5:
				flag = false;
				System.out.println("thanks for shopping !!! pleae do visit again".toUpperCase());
				return;
			default:
				System.out.println("enter correct input".toUpperCase());
				flag = true;
			}
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		mainMenu();
	}
}
