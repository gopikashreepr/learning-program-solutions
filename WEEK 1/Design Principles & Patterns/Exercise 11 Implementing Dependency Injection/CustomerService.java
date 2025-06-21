package di;

public class CustomerService {
    private final CustomerRepository customerRepository;

    // Step 5: Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        System.out.println("🧾 Customer Info:");
        System.out.println("ID    : " + customer.getId());
        System.out.println("Name  : " + customer.getName());
        System.out.println("Email : " + customer.getEmail());
    }
}
