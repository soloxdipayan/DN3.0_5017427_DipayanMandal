public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
       
        return new Customer(id, "Dipayan Mandal");
    }
}
