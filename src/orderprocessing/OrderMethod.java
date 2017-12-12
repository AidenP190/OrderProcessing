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
    double taxes = .02;
    double shipping = .05;
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
            
            for(int i = 0; true; i++)
            {
                if(br.ready()) 
                {
                    orders = br.readLine().split("\\|");
                    Writer(writer);
                }
                else
                {
                   break;
                } 
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
    
    public double calculate(String Calculation)
    {
        
        
        if(Calculation.equals("Tax"))
        {
            return finalTaxes = (Double.parseDouble(orders[2]) * taxes * Integer.parseInt(orders[3]));
        }
        else if(Calculation.equals("Shipping"))
        {
            return finalShipping = (Double.parseDouble(orders[2]) * shipping * Integer.parseInt(orders[3]));
        }
        else if(Calculation.equals("Total"))
        {
            return  finalTotal = ((Double.parseDouble(orders[2]) * taxes * Integer.parseInt(orders[3])) + (Double.parseDouble(orders[2]) * shipping * Integer.parseInt(orders[3])) + ((Double.parseDouble(orders[2])*(Double.parseDouble(orders[3])))));
        }
        else
        {
          return 0;  
        } 
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
                    writer.write("Tax: " + finalTaxes);
                    writer.write("\n");
                    writer.write("Shipping: " + finalShipping);
                    writer.write("\n");
                    writer.write("Total: " + finalTotal);
                    writer.write("\n");
                    writer.write("\n");
                    
        }
        catch(IOException e)
        {
            System.out.println("Could not write to file.");
        }
    }
}
