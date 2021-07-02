/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.cis.paystation;
import java.util.*;
/**
 *
 * @author ramir
 */
public class Main {
    public static void main (String args[]) throws IllegalCoinException {
        PayStation ps = new PayStationImpl();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("GREETING FROM THE PAYSTATION!");
        System.out.println("\n******************\n"
                + "To add payment select 'Deposit Coins'\n"
                + "To complete your transaction select 'Buy Ticket'\n"
                + "To cancel youre transaction select 'Cancel'\n"
                + "To turn off the Paystation select'Quit'\n"
                + "******************\n");
        String input;
        int coinVal;
        while(true){
            System.out.println("Deposit Coins\n"
                + "Display\n"
                + "Buy Ticket\n"
                + "Cancel\n"
                + "Empty\n"
                + "Change Rate Strategy\n"
                + "Quit\n");
            
            input = scan.nextLine();
            
            System.out.println("input: "+input);
            System.out.println("******************");
            
            //Conditionals for menu options
            if(input.toLowerCase().equals("display")){
                System.out.println("You have purchased: " + ps.readDisplay() + " mins");
            }
            else if(input.toLowerCase().equals("deposit coins")){
                System.out.println("How much do you want to deposit?");
                coinVal = Integer.parseInt(scan.nextLine());
                if (coinVal != 5 ^ coinVal != 10 ^ coinVal != 25){
                    System.out.println("Please insert a coin of value 5, 10, or 25");
                }
                else
                    ps.addPayment(coinVal);
            }
            else if(input.toLowerCase().equals("buy ticket")){
                Receipt r = ps.buy();
                System.out.println("Thank you for purchsing your ticket you have purchased:\n" + r.value() + "mins");
                break;
            }
            else if(input.toLowerCase().equals("cancel")){
                ps.cancel();
                System.out.println("Thank You Please Come Again");
                break;
            }
            else if(input.toLowerCase().equals("empty")){
                ps.empty();
            }
            else if(input.toLowerCase().equals("change rate strategy")){
                System.out.println("Which Rate Strategy do you want?");
                System.out.println("Alternating1\n"
                        + "Alternating2\n"
                        + "Linear1\n"
                        + "Linear2\n"
                        + "Progressive\n");
                String rateStrategy = scan.nextLine();
                //Conditionals for the Rate Strategy menu
                if(rateStrategy.toLowerCase().equals("alternating1")){
                    ps.setRS(2);
                }
                
                else if(rateStrategy.toLowerCase().equals("alternating2")){
                    ps.setRS(4);
                }
                
                else if(rateStrategy.toLowerCase().equals("linear1")){
                    ps.setRS(0);
                }
                
                else if(rateStrategy.toLowerCase().equals("linear2")){
                    ps.setRS(3);
                }
                
                else if(rateStrategy.toLowerCase().equals("progressive")){
                    ps.setRS(1);
                }
            }
            else if(input.toLowerCase().equals("quit")){
                break;
            }
            else{
                System.out.println("Falure");
            }
            
            System.out.println("******************");
        }
    }
}
