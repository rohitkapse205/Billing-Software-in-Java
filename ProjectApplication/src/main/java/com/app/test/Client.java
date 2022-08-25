package com.app.test;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.dao.USerDao;
import com.app.dto.InputRequest;
import com.app.dto.UserRequest;
import com.app.factory.UserFactory;
import com.app.model.Bill;
import com.app.model.ClientB;
import com.app.model.User;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		USerDao dao = UserFactory.getUser();
		String ch = "";
		List<Bill> product = new ArrayList<Bill>();
		ArrayList<String> productList = new ArrayList<>();
		do {
			System.out.println("Welcome To My Project");
			System.out.println("Press 1: for Register");
			System.out.println("Press 2: for Login");
			System.out.println("Press 3: for Display Users");
			System.out.println("Press 4: for Display User on id");
			System.out.println("-------------------------------");
			System.out.println("Enter Your Choice:");
			int choice = sn.nextInt();
			switch (choice) {
			case 1:
				User user = InputRequest.register();
				int i = dao.register(user);
				if (i == 1) {
					System.out.println("Successfully Register");
				} else {
					System.out.println("Something went wrong...!");
				}
				break;
			case 2:
				UserRequest request = InputRequest.login();
				User userLogin = dao.login(request);
				if (userLogin != null && userLogin.getRole().equalsIgnoreCase("admin")) {
					System.out.println("welcome to admin portal.");
				} else if (userLogin != null && userLogin.getRole().equalsIgnoreCase("user")) {
					System.out.println("Welcome to User Portal..");
					ClientB c = new ClientB();
				} else {
					System.out.println("Invalid username and password");
				}
				break;
			case 3:
				List<User> list = dao.listOfUsers();
				list.stream().forEach(s -> System.out.println(s.getId() + "\t" + s.getFisrtName() + " "
						+ s.getLastName() + "\t" + s.getAddress() + "\t" + s.getMobile()));
				break;
			case 4:
				System.out.println("Enter your id for find user:");
				int id = sn.nextInt();
				User u1 = dao.findById(id);
				System.out.println(u1);
				break;
			default:
				System.out.println("Invalid Request...!");
				break;
			}
			System.out.println("Do you want to continue...(y)");
			ch = sn.next();
		} while (ch.equalsIgnoreCase("y"));
		System.out.println("Thank you");
	}

	private static String ReciptPrint(List<Bill> Product) throws Exception {
		File file = new File("C:\\Users\\rohit\\eclipse-workspace\\ProjectApplication\\bill.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write("\n\t\tWelcome to our Food Ordering Application\n");
		fw.append("\t" + LocalDate.now());
		fw.append("\t\t\t\t\tCustomer Name:" + Product.get(0).getCname());
		fw.append("\n-------------------------------------------------------\n");
		fw.append("Order id \t Menu Type\t Item Name\t Prize\t TotalBill");
		for (Bill c : Product) {

			fw.append("\n" + c.getId() + "\t\t\t\t" + c.getPname() + "\t\t\t" + c.getQty() + "\t" + c.getPrice()
					+ "\t\t" + c.getTotalPrice());
		}
		fw.append("\n-------------------------------------------------------\n");
		System.out.println("\n\n");
		fw.close();
		return "success";
	}

}
