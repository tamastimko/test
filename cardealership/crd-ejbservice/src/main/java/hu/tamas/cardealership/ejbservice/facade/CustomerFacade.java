package hu.tamas.cardealership.ejbservice.facade;

import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.CustomerCriteria;
import hu.tamas.cardealership.ejbservice.domain.CustomerGenderStub;
import hu.tamas.cardealership.ejbservice.domain.CustomerStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;

public interface CustomerFacade {
	
	CustomerStub getCustomer(String identityCardNumber) throws FacadeException; //jobb lenne szemszam szerint 

	List<CustomerStub> getCustomers(CustomerCriteria criteria) throws FacadeException;

	CustomerStub saveCustomer(String name, long identityCardNumber, String country, String zipcode, String city,
			String street, int streetNumber, String mothersName, CustomerGenderStub gender) throws FacadeException;

	void removeCustomer(long identityCardNumber) throws FacadeException;
}
