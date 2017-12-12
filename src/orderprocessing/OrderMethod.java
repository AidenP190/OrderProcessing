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
public class OrderMethod {
    
    private File input;
    private File output;
    private String[] orders;
    final double  TAX_RATE = .02;
    final double SHIPPING_RATE = .05;
    double finalTaxes;
    double finalShipping;
    double finalTotal;
    
    public OrderMethod()
    {
        input = new File("Orders.txt");
        output = new File("OrdersProcessed.txt");
    };

    public OrderMethod(File input, File output)
    {
        this.input = input;
        this.output = output;
    };
    
    public void Reader()
    {
        System.out.println("Start processing orders.");
        
        try(BufferedReader br = new BufferedReader(new FileReader(input)))
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            
            br.readLine();
            
            while(br.ready())
            {
                    orders = br.readLine().split("\\|");
                    Writer(writer);
            }
            writer.close();
            System.out.println("Finished processing orders.");
        }
        catch(IOException ex)
        {
            System.out.println("Could not read file.");
        }
        catch(Exception ex)
        {
            System.out.println("File error");
        }
        
    }
    
    public double calculateTax()
    {
        
        return finalTaxes = (Double.parseDouble(orders[2]) * TAX_RATE * Integer.parseInt(orders[3]));
    }
    
    public double calculateShipping()
    {
        
        return finalShipping = (Double.parseDouble(orders[2]) * SHIPPING_RATE * Integer.parseInt(orders[3]));
    }
    
    public double calculateTotal()
    {
        return  finalTotal = ((Double.parseDouble(orders[2]) * TAX_RATE * Integer.parseInt(orders[3])) + (Double.parseDouble(orders[2]) * SHIPPING_RATE * Integer.parseInt(orders[3])) + ((Double.parseDouble(orders[2])*(Double.parseDouble(orders[3])))));
    }
    
    public void Writer(BufferedWriter writer)
    {
        try
        {
                    writer.write("Order ID: " + orders[0]);
                    writer.write("\n");
                    writer.write("Part Num: " + orders[1]);
                    writer.write("\n");
                    writer.write("Price: " + orders[2]);
                    writer.write("\n");
                    writer.write("Quantity: " + orders[3]);
                    writer.write("\n");
                    writer.write("Tax: " + calculateTax());
                    writer.write("\n");
                    writer.write("Shipping: " + calculateShipping());
                    writer.write("\n");
                    writer.write("Total: " + calculateTotal());
                    writer.write("\n");
                    writer.write("\n");      
        }
        catch(IOException ex)
        {
            System.out.println("Could not write to file.");
        }
    }
}
