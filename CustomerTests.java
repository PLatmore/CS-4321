package Store;

public class CustomerTests {
	
	//public static void main(String[] args) {
        //testAddOrder();
        //testFindOrderById();
        //testAddStoreCredit();
        //testGetStoreCredit();
        //testCustomerScenario();
        //System.out.println("All tests finished.");
    //}

	//testAddOrder()
    public static void testAddOrder() {
        Customer customer = new Customer("John Doe");
        Order order = new Order();
        customer.addOrder(order);
        if (customer.getOrders().size() != 1) {
            System.out.println("Failed: testAddOrder");
        }
    }
    //testFindOrderById()
    public static void testFindOrderById() {
        Customer customer = new Customer("John Doe");
        Order order = new Order();
        customer.addOrder(order);
        int orderId = order.getId();
        if (customer.findOrderById(orderId) != order) {
            System.out.println("Failed: testFindOrderById");
        }
    }
    //testAddStoreCredit()
    public static void testAddStoreCredit() {
        Customer customer = new Customer("John Doe");
        customer.addStoreCredit(50);
        if (customer.getStoreCredit() != 50) {
            System.out.println("Failed: testAddStoreCredit");
        }
    }
    //testGetStoreCredit()
    public static void testGetStoreCredit() {
        Customer customer = new Customer("John Doe");
        customer.addStoreCredit(100);
        if (customer.getStoreCredit() != 100) {
            System.out.println("Failed: testGetStoreCredit");
        }
    }
    //testCustomerScenario()
    public static void testCustomerScenario() {
        Customer customer = new Customer("Jane Doe");  
        Order order1 = new Order();
        Order order2 = new Order();
        customer.addOrder(order1);
        customer.addOrder(order2);
        
        if (customer.getOrders().size() != 2) {
            System.out.println("Failed: order count");
        }
        if (customer.findOrderById(order1.getId()) != order1) {
            System.out.println("Failed: find order1");
        }
        if (customer.findOrderById(order2.getId()) != order2) {
            System.out.println("Failed: find order2");
        }
        customer.addStoreCredit(50);
        customer.addStoreCredit(25);
        
        if (customer.getStoreCredit() != 75) {
            System.out.println("Failed: store credit");
        }
    }

    
}