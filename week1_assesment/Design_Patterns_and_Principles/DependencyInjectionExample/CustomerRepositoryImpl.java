class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
       
        if ("123".equals(id)) {
            return new Customer("123", "Dipayan Mandal", "D.m@example.com");
        }
        return null;
    }
}