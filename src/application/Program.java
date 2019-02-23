package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i < n + 1; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (resp == 'c') {
				list.add(new Product(name, price));
			}
			if (resp == 'i') {
				System.out.print("Customs fee: ");
				double customsFree = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFree));

			}
			if (resp == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY):");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}
		}
		System.out.println("PRICE TAGS: ");
		System.out.println();
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		sc.close();

	}

}
