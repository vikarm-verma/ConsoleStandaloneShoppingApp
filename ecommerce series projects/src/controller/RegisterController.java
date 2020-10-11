package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.RegisterBean;
import streamspack.AppendingObjectInputStream;
import streamspack.AppendingObjectOutputStream;

public class RegisterController {

	static Map<RegisterBean, Integer> map = new TreeMap<RegisterBean, Integer>();
	static int regId = 0;
	static String email, password;
	static String registrationStatus = "";

	static Scanner s = new Scanner(System.in);

	static File file = new File("datafiles/RegistrationDetails.txt");
	static boolean fileExistence = false;

	static private Pattern pattern;
	static private Matcher matcher;

	// pattern for email and password
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$";

//will clear map before using
	RegisterController() {
		map.clear();
	}

	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();

	}

	public static boolean validatePassword(String password) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	// will take email and password from user and register if not else proceed to
	// login

	public static void setRegisterUser() throws IOException, ClassNotFoundException {
		boolean flag = true;
		while (flag) {
			System.out.println("\nenter email or press enter for last menu".toUpperCase());
			email = s.nextLine().toLowerCase();
			if (email.isEmpty()) {
				return;
			}
			if (validateEmail(email)) {
				System.out.println("\nenter password ".toUpperCase() + "[Rahul@jaipur20 or Rahul#123]");
				password = s.nextLine();
				if (validatePassword(password)) {
					regId += 1;
					map.put(new RegisterBean(regId, email, password), regId);
					fileExistence = file.exists();
					if (fileExistence == true) {
						readUserObject();
					}
					if (registrationStatus.equals("not reg") || registrationStatus.equals("")) {
						writeUserObject();
					}
					flag = false;
				} else {
					System.out.println("\npassword is not in valid format\n".toUpperCase());
					flag = true;
				}
			} else {
				System.out.println("\nemail is not in valid format\n");
				flag = true;
			}

		}

	}

	// will read data from file for checking user's email and password

	public static void readUserObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		AppendingObjectInputStream ois = new AppendingObjectInputStream(fis);
		Map<RegisterBean, Integer> map1 = null;
		try {
			while (fis.available() > 0) {
				map1 = (TreeMap<RegisterBean, Integer>) ois.readObject();
				for (Map.Entry<RegisterBean, Integer> entry : map1.entrySet()) {
					if (entry.getKey().getEmail().equals(email) && entry.getKey().getPassword().equals(password)) {
						registrationStatus = "already registered";
						System.out.println("\nalready registered...proceed to login\n".toUpperCase());
						return;
					} else {
						registrationStatus = "not reg";
					}
				}
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} finally {
			fis.close();
			ois.close();
		}
	}

	// if user is new then this will write user into file

	public static void writeUserObject() throws FileNotFoundException, IOException {
		AppendingObjectOutputStream out = new AppendingObjectOutputStream(new FileOutputStream(file, fileExistence));
		out.writeObject(map);
		out.flush();
		out.close();
		map.clear();
		System.out.println("\nsuccessfully registered!!!\n".toUpperCase());
	}

	// will return user's registration status [already registered or not reg]

	public static String getRegistrationStatus() {
		return registrationStatus;
	}

	public static Map<RegisterBean, Integer> getRegisterUsers()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		TreeMap<RegisterBean, Integer> map1 = null;
		FileInputStream fis = null;
		AppendingObjectInputStream ois = null;
		try {
			map1 = new TreeMap<>();
			if (file.exists()) {
				fis = new FileInputStream(file);
			} else {
				file.createNewFile();
			}
			ois = new AppendingObjectInputStream(fis);
			if (fis.available() == 0) {
				map1 = null;

			}

			while (fis.available() > 0) {
				map1 = (TreeMap<RegisterBean, Integer>) ois.readObject();
				for (Map.Entry<RegisterBean, Integer> entry : map1.entrySet()) {
					// System.out.println("reg Key = " + entry.getKey() + ", Value = " +
					// entry.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			ois.close();
		}
		return map1;
	}

}
