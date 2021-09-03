import com.mycompany.objectrelationalmapping.models.Customer;
import com.mycompany.objectrelationalmapping.models.ItemType;

import com.mycompany.objectrelationalmapping.models.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Tester {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();


        /// Create customer and save it to database
      /* Customer c1 = new Customer("Nicholas","Nicholas@gmail.com");
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        ///em.close();*/


        /// find a customer
        TypedQuery<Customer> c2 = em.createQuery("SELECT c FROM Customer c WHERE c.id =?1",Customer.class).setParameter(1,1);
        Customer customer = c2.getSingleResult();
        System.out.println(customer.getName());


        ///Get all customers
        TypedQuery<Customer> q3 = em.createQuery("SELECT c From Customer c",Customer.class);
        List<Customer> customers = q3.getResultList();

        for (Customer c:customers){
            System.out.println(c.getName());
        }


        /// Create ItemType

        ItemType itemType = new ItemType("Manitou","tobak",76);
        em.getTransaction().begin();
        em.persist(itemType);
        em.getTransaction().commit();


        /// get an item type
        TypedQuery<ItemType> i1 = em.createQuery("SELECT i FROM ItemType i WHERE i.id =?1",ItemType.class).setParameter(1,1);
        ItemType itemType1 = i1.getSingleResult();
        System.out.println(itemType.getName());


        ///create an order and add it to a Customer

        Orders o1 = new Orders();
        o1.setCustomer(customer);
        em.getTransaction().begin();
        em.persist(o1);
        em.getTransaction().commit();


        /// find all orders, for a specific customer

        TypedQuery<Customer> c1 = em.createQuery("SELECT c FROM Customer c WHERE c.id =?1",Customer.class).setParameter(1,1);
        Customer customer2 = c1.getSingleResult();

        for (Orders orders: customer2.getOrder()) {
           System.out.println(orders.getId());
       }

















    }


}
