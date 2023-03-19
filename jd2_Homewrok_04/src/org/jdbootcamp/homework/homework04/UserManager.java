package org.jdbootcamp.homework.homework04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {

	private List<User> users = new ArrayList<User>();

	public UserManager() {}

	public void addNewUser(User user) {
		Scanner scanner = new Scanner(System.in);

		if (user.getName() == null) {
			System.out.print("Adınız: ");
			user.setName(scanner.nextLine());

			System.out.print("Soyadınız: ");
			user.setSurname(scanner.nextLine());

			System.out.print("Şifre: ");
			user.setPassword(scanner.nextLine());
		}
		scanner.close();
		users.add(user);
	}

	public void getUser() {
		int index = 0;
		for (User user : users) {
			System.out.println(++index + ". " + user.getName() + " " + user.getSurname());
		}
	}

}
