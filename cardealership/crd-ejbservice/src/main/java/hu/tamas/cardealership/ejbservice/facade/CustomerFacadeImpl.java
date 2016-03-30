package hu.tamas.cardealership.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


import hu.tamas.cardealership.ejbservice.converter.CustomerConverter;
import hu.tamas.cardealership.ejbservice.domain.CustomerCriteria;
import hu.tamas.cardealership.ejbservice.domain.CustomerGenderStub;
import hu.tamas.cardealership.ejbservice.domain.CustomerStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;
import hu.tamas.cardealership.persistence.entity.Customer;
import hu.tamas.cardealership.persistence.entity.trunk.CustomerGender;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;
import hu.tamas.cardealership.persistence.service.CustomerService;

@Stateless(mappedName = "ejb/customerFacade") 
public class CustomerFacadeImpl implements CustomerFacade {

	
	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);
	
	@EJB
	private CustomerService service;
	
	@EJB
	private CustomerConverter converter;
	
	
	@Override
	public CustomerStub getCustomer(String identityCardNumber) throws FacadeException {
		try{
			final CustomerStub stub = this.converter.to(this.service.read(identityCardNumber));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get customer by identityCardNumber (" + identityCardNumber + ") --> " + stub);
			}
			return stub;
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	

	@Override
	public List<CustomerStub> getCustomers(CustomerCriteria criteria) throws FacadeException {
		List<CustomerStub> stubs = new ArrayList<CustomerStub>();
		try{
			List<Customer> customers = null;
			if(criteria.getGender() == null){
				customers = this.service.readAll();
			}
			else{
				customers = this.service.read(CustomerGender.valueOf(criteria.getGender().name()));
			}
			stubs = this.converter.to(customers);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get customers by criteria (" + criteria + ") --> " + stubs.size() + " customer(s)");
			}
		} 
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public CustomerStub saveCustomer(String name, long identityCardNumber, String country, String zipcode, String city,
			String street, int streetNumber, String mothersName, CustomerGenderStub gender) throws FacadeException {
		try{
			Customer customer = null;
			if(this.service.exists(identityCardNumber)){
				customer = this.service.update(name, identityCardNumber, country, zipcode, city, street, streetNumber, mothersName, CustomerGender.valueOf(gender.name()));
			}
			else{
				customer = this.service.create(name, identityCardNumber, country, zipcode, city, street, streetNumber, mothersName, CustomerGender.valueOf(gender.name()));
			}
			return this.converter.to(customer);
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void removeCustomer(long identityCardNumber) throws FacadeException {
		try{
			this.service.delete(identityCardNumber);
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		
		
	}
	
}
