package example.refactoring.cap3;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import ch.gmtech.xutils.fields.Fields;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Order {
	 
	private final Vector<Fields> _lineItemList;
 
	public Order(Vector<Fields> lineItemList) {
		_lineItemList = lineItemList;
	}

	@Override
	public boolean equals(Object aThat) {
            if ( this == aThat ) return true;
        if ( !(aThat instanceof Order) ) return false;
            Order that = (Order)aThat;
        return _lineItemList.equals(that._lineItemList);
    }
 
    // writes this order object to the specified print writer
    public void writeOrder(PrintWriter pw) {
        // get a vector of line items
        Iterator<Fields> iter = _lineItemList.iterator();
        Fields item = Fields.empty();
        // set total to zero
        int total = getTotal();

           while (iter.hasNext()) {
                item = iter.next();
 
                // calculate total for line item
                int unitPrice = item.firstIntValueFor("unitPrice");
                int quantity = item.firstIntValueFor("quantity");
                String productID = item.firstValueFor("productID");
                String imageID = item.firstValueFor("imageID");
                int lineItemTotal = unitPrice * quantity;
 
                pw.println("Begin Line Item");
                pw.println("Product = " + productID);
                pw.println("Image = " + imageID);
                pw.println("Quantity = " + quantity);
                pw.println("Total = " + lineItemTotal);
                pw.println("End Line Item");
            }
        pw.println("Order total = " + total);
    }
 
	/** This method saves the order to the database */
    public void saveOrder()  throws SQLException
    {
        //create connection
        Connection conn = null;
 
        PreparedStatement orderStatement = null;
        String sql = null;
        sql = new StringBuffer().append("INSERT INTO T_ORDER " )
            .append("(AUTHORIZATION_CODE, " )
            .append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) " )
            .append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ).toString();
        conn = setConnection();
        orderStatement = (PreparedStatement) conn.prepareStatement(sql);
        //set all parameters
       
        //execute statement
        orderStatement.executeUpdate();
    }

	private int getTotal() {
	    // get a vector of line items
	    Vector<Fields> lineItems = _lineItemList;
	    // create an iterator for the vector
	    Iterator<Fields> iter = lineItems.iterator();
	    Fields item = Fields.empty();
	    int total = 0;
	        while (iter.hasNext()) {
	            item = iter.next();
	
	            // calculate total for line item
	            int unitPrice = item.firstIntValueFor("unitPrice");
	            int qty = item.firstIntValueFor("quantity");
	            int lineitemtotal = unitPrice * qty;
	
	            total += lineitemtotal;
	        }
	        return total;
	}

	private Connection setConnection() {
		return null;
}
}
