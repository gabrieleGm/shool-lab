package example.refactoring.cap3;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

import org.junit.Test;

import ch.gmtech.xutils.fields.Fields;

public class PrintOrderTest {

	@Test
	public void print_noOrder(){
		Vector<Fields> lineOrder = new Vector<Fields>();
		Order order = new Order(lineOrder);
		StringWriter stringWriter = new StringWriter();
		order.writeOrder(new PrintWriter(stringWriter));
		assertEquals("should be ", "Order total = 0\n", stringWriter.toString());
	}
	
	@Test
	public void print_oneOrder(){
		Vector<Fields> lineOrder = new Vector<Fields>();
		lineOrder.add(Fields.empty().put("unitPrice", "1").put("quantity", "100").put("imageID", "10").put("productID","1"));
		Order order = new Order(lineOrder);
		StringWriter stringWriter = new StringWriter();
		order.writeOrder(new PrintWriter(stringWriter));
		
		assertEquals("should be ", ""
				+ "Begin Line Item\n"
				+ "Product = 1\n"
				+ "Image = 10\n"
				+ "Quantity = 100\n"
				+ "Total = 100\n"
				+ "End Line Item\n"
				+ "Order total = 100\n"
				+ "", stringWriter.toString());
	}
	
	@Test
	public void print_twoOrder(){
		Vector<Fields> lineOrder = new Vector<Fields>();
//		Fields lineItem = new LineItem(1,10,100, 1);
		lineOrder.add(Fields.empty().put("unitPrice", "1").put("quantity", "100").put("imageID", "10").put("productID","1"));
//		LineItem lineItem2 = new LineItem(2,20,200,2);
		lineOrder.add(Fields.empty().put("unitPrice", "2").put("quantity", "200").put("imageID", "20").put("productID","2"));
		
		Order order = new Order(lineOrder);
		StringWriter stringWriter = new StringWriter();
		order.writeOrder(new PrintWriter(stringWriter));
		
		assertEquals("should be ", ""
				+ "Begin Line Item\n"
				+ "Product = 1\n"
				+ "Image = 10\n"
				+ "Quantity = 100\n"
				+ "Total = 100\n"
				+ "End Line Item\n"
				+ "Begin Line Item\n"
				+ "Product = 2\n"
				+ "Image = 20\n"
				+ "Quantity = 200\n"
				+ "Total = 400\n"
				+ "End Line Item\n"
				+ "Order total = 500\n"
				+ "", stringWriter.toString());
	}
}
