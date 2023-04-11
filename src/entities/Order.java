package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.add(item);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem itm : this.items) {
			sum += itm.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RESUMO DO PEDIDO: \n");
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(this.moment) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(this.status + "\n");
		sb.append("Client: ");
		sb.append(this.client + "\n");
		sb.append("Ordem dos pedidos:  \n");
		for(OrderItem itm : this.items) {
			sb.append(itm + "\n");
		}
		sb.append("Preço total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
