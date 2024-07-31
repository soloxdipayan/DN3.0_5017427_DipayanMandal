public class test11 {
    public static void main(String[] args) {
    
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository 
        CustomerService customerService = new CustomerService(customerRepository);

        //  find a customer
        Customer customer = customerService.getCustomerById("1");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}
