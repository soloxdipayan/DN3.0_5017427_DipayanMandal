class CustomerService {
    private CustomerRepositoryImpl customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}
