package com.project.iBook.paypal.CaptureIntentExamples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.paypal.http.HttpResponse;
import com.paypal.http.serializer.Json;
import com.project.iBook.paypal.PayPalClient;
import com.paypal.orders.AddressPortable;
import com.paypal.orders.AmountBreakdown;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Item;
import com.paypal.orders.LinkDescription;
import com.paypal.orders.Money;
import com.paypal.orders.Name;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import com.paypal.orders.ShippingDetail;

public class CreateOrder extends PayPalClient {

	/**
	 * Method to generate sample create order body with <b>CAPTURE</b> intent
	 *
	 * @return OrderRequest with created order request
	 */
	private OrderRequest buildRequestBody(double price) {
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.checkoutPaymentIntent("CAPTURE");

		String totalPrice = String.valueOf(price);

		ApplicationContext applicationContext = new ApplicationContext().brandName("iBook INC.").landingPage("BILLING")
				.cancelUrl("https://www.facebook.com").returnUrl("https://www.google.com").userAction("CONTINUE")
				.shippingPreference("SET_PROVIDED_ADDRESS");
		orderRequest.applicationContext(applicationContext);

		List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<PurchaseUnitRequest>();
		PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest().referenceId("PUHF")
				.description("Knowledge Goods").customId("CUST-HighFashions").softDescriptor("HighFashions")
				.amountWithBreakdown(new AmountWithBreakdown().currencyCode("USD").value(totalPrice)
						.amountBreakdown(new AmountBreakdown().itemTotal(new Money().currencyCode("USD").value(totalPrice))
//								.shipping(new Money().currencyCode("USD").value("20.00"))
//								.handling(new Money().currencyCode("USD").value("10.00"))
//								.taxTotal(new Money().currencyCode("USD").value("20.00"))
//								.shippingDiscount(new Money().currencyCode("USD").value("10.00"))
								)
							)
				.items(new ArrayList<Item>() {
					{
						add(new Item().name("All Books").description("All book in cart").sku("sku01")
								.unitAmount(new Money().currencyCode("USD").value(totalPrice))
//								.tax(new Money().currencyCode("USD").value("10.00"))
								.quantity("1")
								.category("PHYSICAL_GOODS"));
//						add(new Item().name("Shoes").description("Running, Size 10.5").sku("sku02")
//								.unitAmount(new Money().currencyCode("USD").value("45.00"))
//								.tax(new Money().currencyCode("USD").value("5.00")).quantity("2")
//								.category("PHYSICAL_GOODS"));
					}
				})
				.shippingDetail(new ShippingDetail().name(new Name().fullName("Zhihao Lyu"))
						.addressPortable(new AddressPortable().addressLine1("123 Townsend St").addressLine2("Floor 2")
								.adminArea2("San Jose").adminArea1("CA").postalCode("95035").countryCode("US")));
		purchaseUnitRequests.add(purchaseUnitRequest);
		orderRequest.purchaseUnits(purchaseUnitRequests);
		return orderRequest;
	}

	/**
	 * Method to create order
	 *
	 * @param debug true = print response data
	 * @return HttpResponse<Order> response received from API
	 * @throws IOException Exceptions from API if any
	 */
	public HttpResponse<Order> createOrder(boolean debug, double price) throws IOException {
		OrdersCreateRequest request = new OrdersCreateRequest();
		request.header("prefer","return=representation");
		request.requestBody(buildRequestBody(price));
		HttpResponse<Order> response = client().execute(request);
		if (debug) {
			if (response.statusCode() == 201) {
				System.out.println("Status Code: " + response.statusCode());
				System.out.println("Status: " + response.result().status());
				System.out.println("Order ID: " + response.result().id());
				System.out.println("Intent: " + response.result().checkoutPaymentIntent());
				System.out.println("Links: ");
				for (LinkDescription link : response.result().links()) {
					System.out.println("\t" + link.rel() + ": " + link.href() + "\tCall Type: " + link.method());
				}
				System.out.println("Total Amount: " + response.result().purchaseUnits().get(0).amountWithBreakdown().currencyCode()
						+ " " + response.result().purchaseUnits().get(0).amountWithBreakdown().value());
				System.out.println("Full response body:");
				System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));
			}
		}
		return response;
	}

	/**
	 * This is the driver function which invokes the createOrder function to create
	 * an sample order.
	 */
	public static void main(String args[]) {
		try {
			new CreateOrder().createOrder(true, 100);
		} catch (com.paypal.http.exceptions.HttpException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
