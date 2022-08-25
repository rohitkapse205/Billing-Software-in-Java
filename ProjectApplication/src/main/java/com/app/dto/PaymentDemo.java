package com.app.dto;

import java.util.Scanner;

public class PaymentDemo {
	int ch;
	Scanner scan = new Scanner(System.in);

	public void print() {
		System.out.println("Press 1: Cash Payment");
		System.out.println("Press 2: Online Payment");
		ch = scan.nextInt();
		switch (ch)

		{
		case 1: {
			System.out.println("Done.. Payment Successful");
			break;
		}
		case 2: {
			System.out.println("(+91)7898754862- Pay Here");
			System.out.println("Done.. Payment Successful");
			break;
		}
		}
	}
}
