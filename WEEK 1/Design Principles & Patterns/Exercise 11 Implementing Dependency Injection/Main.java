package di;

public class Main {
    public static void main(String[] args) {
        // Injecting dependency manually using constructor injection
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.displayCustomer("CUST101");
    }
}
