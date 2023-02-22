/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBean;

import javax.ejb.Remote;

/**
 *
 * @author ADMIN
 */
@Remote
public interface StatelessTemperatureBeanRemote {

    double calculateToCelsius(double fah);
    
}
