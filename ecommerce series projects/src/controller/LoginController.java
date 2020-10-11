package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.LoginBean;
import bean.RegisterBean;
import streamspack.AppendingObjectInputStream;

public class LoginController {
	static String email = "";
	static String password = "";
	static Scanner s = new Scanner(System.in);
	static File file = new File("datafiles/RegistrationDetails.txt");
	static LoginBean lb;// = new LoginBean();
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$";
	static private Pattern pattern;
	static private Matcher matcher;

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

	public static boolean checkCredentials() throws FileNotFoundException, ClassNotFoundException, IOException {

		boolean flag1 = true;
		// to check if user is not registered go to last menu or file is not created
		// then create file and then go to last menu
		TreeMap<RegisterBean, Integer> map1 = new TreeMap<>();
		FileInputStream fis = null;
		AppendingObjectInputStream ois = null;
		if (!file.exists()) {
			file.createNewFile();
		} else {
			fis = new FileInputStream(file);
			ois = new AppendingObjectInputStream(fis);
		}
		try {
			if (RegisterController.getRegisterUsers().entrySet().isEmpty()
					&& RegisterController.getRegisterUsers().entrySet() == null) {

			}
		} catch (NullPointerException e) {
			System.out.println("no data...".toUpperCase());
			return false;
		}

		try {

			while (flag1) {
				System.out.println("\nEnter email or press enter for last menu".toUpperCase());
				email = s.nextLine();
				if (email.isEmpty()) {
					return flag1 = false;

				}
				System.out.println("\nEnter password [Rahul@jaipur20 or Rahul#123]\"".toUpperCase());
				password = s.nextLine();
				while (fis.available() > 0) {
					if (validateEmail(email) && validatePassword(password)) {
						map1 = (TreeMap<RegisterBean, Integer>) ois.readObject();
						for (Map.Entry<RegisterBean, Integer> entry : map1.entrySet()) {
							if (entry.getKey().getEmail().equalsIgnoreCase(email)
									&& entry.getKey().getPassword().equals(password)) {
								new LoginBean(email, password);
								return flag1 = true;
							} else {
								flag1 = true;
							}
						}
					} else {
						System.out.println("\nsome issue is there...".toUpperCase());
						return flag1 = false;
						// break;
					}
				}
			}
			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println("\nregister first...".toUpperCase());
			return flag1 = false;
		}
		return flag1;
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		checkCredentials();
	}
}
