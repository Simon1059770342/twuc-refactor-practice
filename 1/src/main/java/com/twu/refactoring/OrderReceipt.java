package com.twu.refactoring;

import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
	public static final String PRINTING_ORDERS = "======Printing Orders======";
	public static final String SALES_TAX = "Sales Tax";
	public static final String TOTAL_AMOUNT = "Total Amount";
	public static final String ENTER = "\n";
	public static final char TAB = '\t';
	private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	private static final double rate = 0.10;

	public String printReceipt() {
		StringBuilder output = new StringBuilder();
		// print headers
		output.append(PRINTING_ORDERS).append(ENTER).append(order.getCustomerName()).append(order.getCustomerAddress());

		// prints lineItems
		double totalPrice = order.getOrderItems().stream().mapToDouble(OrderItem::totalAmount).sum();
		output.append(order.getOrderItems().stream().map(OrderItem::toString).collect(Collectors.joining()));

		double totalSalesTax = totalPrice * rate;
		double totalPriceWithTax = totalPrice + totalSalesTax;

		// prints the state tax
		output.append(SALES_TAX).append(TAB).append(totalSalesTax);

        // print total amount
		output.append(TOTAL_AMOUNT).append(TAB).append(totalPriceWithTax);
		return output.toString();
	}
}