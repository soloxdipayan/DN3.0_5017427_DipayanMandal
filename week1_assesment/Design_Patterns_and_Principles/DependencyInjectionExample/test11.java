public class test11 {
    public static void main(String[] args) {
 
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.getCustomerById("123");
   
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found");
        }



    }
}