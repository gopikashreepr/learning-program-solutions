package di;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(String id) {
        // For demo purposes, return a dummy customer
        return new Customer(id, "John Doe", "john@example.com");
    }
}
