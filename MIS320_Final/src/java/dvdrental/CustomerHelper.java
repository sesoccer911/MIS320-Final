/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author gutsman214
 */
public class CustomerHelper
{
    Session session = null;
    
    public CustomerHelper(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    // method to retrieve customers by customerId
    public Customer getCustomersByID(short customerId){
    Customer customer = null;
    try {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Customer as customer where customer.customerId=" + customerId);
        customer = (Customer) q.uniqueResult();
        tx.commit();
        tx = null;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return customer;
    }
    
    //Method to Retrieve payment info by customerId
    public Payment getPaymentbyID(short customerId){
        Payment payment = null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q =session.createQuery("from Payment as payment where payment.customerId=" + customerId);
            payment = (Payment) q.uniqueResult();
            tx.commit();
            tx = null;
        
        } catch (Exception e){
            e.printStackTrace();
        }
        return payment;
        }
    
    //Method to retrieve rental history by customerID. Not complete
    public Rental getRentalByID(short customerId){
    List<Rental> rentalList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Rental as rental where rental.customerId=" + customerId);
        rentalList = (List<Rental>) q.list();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return rentalList.get(0);
    }
}
