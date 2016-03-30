package hu.tamas.cardealership.ejbservice.converter;

import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.CustomerStub;
import hu.tamas.cardealership.persistence.entity.Customer;

public interface CustomerConverter {
	
	CustomerStub to(Customer customer); 
	List<CustomerStub> to(List<Customer> customers);
}
