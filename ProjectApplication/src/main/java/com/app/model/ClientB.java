package com.app.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientB {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		conf.configure("hibernate-cfg.xml");
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String id = null;
		String productName = null;
		int quantity = 0;
		double price = 0.0;
		double totalPrice = 0.0;
		double overAllPrice = 0.0;
		double cgst, sgst, subtotal = 0.0, discount = 0.0;
		char choice = '\0';

		String cname = null;
		int c_phone = 0;

		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t " + "  " + "Metro Mart Grocery Shop");
		System.out.println("\t\t\t\t\t3/98 Mecrobertganj New Mumbai");
		System.out.println("\t\t\t\t\t" + "    " + "Opposite Metro Walk");
		System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+91) 9988776655");
		// format of date and time
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		// prints current date and time
		System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
				+ "\t\t\t\t\t\t (+91) 9998887770");

		// Employee emp=new Employee();
		Bill user = new Bill();
		Scanner scl = new Scanner(System.in);

		// name and no
		System.out.println("Enter Customer Name: ");
		cname = scl.nextLine();
		user.setCname(cname);
		// To valid Phone Number
		System.out.println("Enter Customer Number:(+91)");
		c_phone = scl.nextInt();
		user.setC_phone(c_phone);
		// Generate Random Bill Number
		int min = 1;
		int max = 1000;
		int a = (int) (Math.random() * (max - min + 1) + min);
		System.out.print("Bill Number: " + a);

		// create Scanner class object
		// creating an ArrayList to store the product
		List<Bill> product = new ArrayList<Bill>();
		ArrayList<String> productList = new ArrayList<String>();
		{

			do {

				// List Of Items
				System.out.println("\n\nList Of Product...");
				String[] s = new String[] { "Sugar    ", "Rice    ", "Wheat    ", "Biscuits     ", "Maggie",
						"Oats     ", "Soap     ", "Nuts   ", "Beans    ", "Cat food" };

				int[] rate = new int[] { 30, 35, 40, 30, 10, 30, 25, 10, 15, 70 };
				// To Print Item & Price
				System.out.println("\nITEM" + "\t\t\tPrice");

				Double totalPrice1 = scl.nextDouble();
				user.setTotalPrice(totalPrice1);

				for (int i = 0; i < 10; i++)
					System.out.println((i + 1) + "." + s[i] + "\t\t" + rate[i]);
				// read input values
				System.out.println("Enter the product details: ");
				System.out.print("Product ID: ");
				String id1 = scl.next();
				user.setId(id1);
				System.out.print("Product Name: ");
				String pname = scl.next();
				user.setPname(pname);
				System.out.print("Quantity: ");
				int qty = scl.nextInt();
				user.setQty(qty);
				System.out.print("Price (per unit): ");
				Double price1 = scl.nextDouble();
				user.setPrice(price1);
				// calculate total price for a particular product
				totalPrice1 = price1 * quantity;
				// calculates overall price
				overAllPrice = overAllPrice + totalPrice1;
				// creates Product class object and add it to the List
				product.add(new Bill(cname, c_phone, id1, qty, productName, pname, quantity, price1, totalPrice1));
				// ask for continue shopping?
				System.out.print("Want to Add More Items? (y or n): ");
				// reads a character Y or N
				choice = scl.next().charAt(0);
				// read remaining characters, don't store (no use)
				scl.nextLine();
			} while (choice == 'y' || choice == 'Y');
			// display all product with its properties
			Bill.displayFormat();
			for (Bill p : product) {
				p.display();
			}
			// Display Bill Format

			// More Operations
			System.out.print("Want to Remove Items? (y or n): ");
			choice = scl.next().charAt(0);
			// Choice
			if (choice == 'y' || choice == 'Y') {
				System.out.print("Enter Product Name to Delete: ");

				for (String name : productList) {
					System.out.println(name);

				}
				productList.remove(scl.next());

				for (String name : productList) {
					System.out.println("Name is" + name);
				}
				System.out.print("Item Deleted Successfully");
				// Display Bill Format
				// Bill bf1 = new Bill();
				// Make A Payment
				// paymentDemmo pd1 = new paymentDemmo();
				user.print();
			} // else {
				// paymentDemmo pd = new paymentDemmo();
				// pd.print();
		}

		// close Scanner
		// scan.close();
		// }

		// private void print() {
		// TODO Auto-generated method stub

		/// my code
		// System.out.println("Enter your product ID");
		// String id=scl.next();
		// user.setId(id);
		// System.out.println("Enter your product name");
		// String pname=scl.next();
		// user.setPname(pname);
		// System.out.println("Enter your Product quentity");
		// int qty=scl.nextInt();
		// user.setQty(qty);
		// System.out.println("Enter your product price");
		// Double price=scl.nextDouble();
		// user.setPrice(price);
		// System.out.println(" your total price");
		// Double totalPrice=scl.nextDouble();
		// user.setTotalPrice(totalPrice);

//	

		// emp.getEmpName();

//	emp.getEmpId();
//	emp.getEmpName();
		// emp.setEmpsal(465776.90);
		user.getCname();
		user.getCname();
		user.getId();
		user.getPname();
		user.getQty();
		user.getPrice();
		user.getTotalPrice();

		session.persist(user);
		tx.commit();

		System.out.println("Record Inserted" + user);
		session.close();
	}
}
