/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelesstemperatureclient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import myBean.StatelessTemperatureBeanRemote;

/**
 *
 * @author ADMIN
 */
public class CallRemote {

    StatelessTemperatureBeanRemote call = lookupStatelessTemperatureBeanRemote();

    private StatelessTemperatureBeanRemote lookupStatelessTemperatureBeanRemote() {
        try {
            Context c = new InitialContext();
            return (StatelessTemperatureBeanRemote) c.lookup("java:comp/env/StatelessTemperatureBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        double f;
        System.out.print("Enter degree in Fahrenheit: ");
        f = scan.nextDouble();
        System.out.println(f + " Fahrenheit = " + call.calculateToCelsius(f) + " Celsius");
    }

}
