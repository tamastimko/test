package hu.tamas.cardealership.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.tamas.cardealership.ejbservice.domain.CustomerGenderStub;
import hu.tamas.cardealership.ejbservice.domain.CustomerStub;
import hu.tamas.cardealership.persistence.entity.Customer;

@Stateless
public class CustomerConverterImpl implements CustomerConverter {

	@Override
	public CustomerStub to(Customer customer) {
		final CustomerGenderStub gender = CustomerGenderStub.valueOf(customer.getGender().toString());
		return new CustomerStub(customer.getName(), customer.getIdentityCardNumber(),customer.getCountry(), customer.getZipcode(), 
				customer.getCity(), customer.getStreet(), customer.getStreetNumber(), customer.getMothersName(), gender);
	}

	@Override
	public List<CustomerStub> to(List<Customer> customers) {
		final List<CustomerStub> result = new ArrayList<>();
		for(Customer actual : customers){
			result.add(this.to(actual));
		}
		return result;
	}

}
