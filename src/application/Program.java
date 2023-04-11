package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira os dados do cliente:");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento: ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		System.out.println("Insira os dados do pedido:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);

		System.out.print("Quantos itens cabem neste pedido? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do item nº " + i+ ":");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço do Produto: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem item = new OrderItem(quantity, productPrice, product);
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);

			sc.close();
	}
}
