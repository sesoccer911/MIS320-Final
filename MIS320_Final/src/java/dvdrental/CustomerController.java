/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.model.DataModel;

/**
 *
 * @author gutsman214
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable
{   short customerId;
    DataModel CustomerInfo;
    CustomerHelper helper;
    
    private Customer current;
    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController()
    {
        helper = new CustomerHelper();
        customerId =1;
    }
     public CustomerController(short customerId)
    {
        helper = new CustomerHelper();
        this.customerId = customerId;
    }
     
     public Customer getSelected() {
        if (current == null) {
            current = new Customer();
        }
        return current;
    }
    
    // Retrieves details about the customer
}
