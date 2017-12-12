/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessing;
import java.io.*;
/**
 *
 * @author aparsons
 */
public class OrderProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File input = new File("Orders.txt");
        File output = new File("OrdersProcessed.txt");
        OrderMethod order = new OrderMethod(input, output);
        
        order.Reader();
    }
    
}
