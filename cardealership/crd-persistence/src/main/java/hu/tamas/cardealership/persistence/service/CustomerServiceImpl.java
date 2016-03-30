package hu.tamas.cardealership.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.tamas.cardealership.persistence.entity.Customer;
import hu.tamas.cardealership.persistence.entity.trunk.CustomerGender;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;
import hu.tamas.cardealership.persistence.parameter.CustomerParameter;
import hu.tamas.cardealership.persistence.query.CustomerQuery;


@Stateless(mappedName = "ejb/customerservice")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	
	@PersistenceContext(unitName = "crd-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public boolean exists(long identityCardNumber) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Customer by identityCardNumber  (" + identityCardNumber + ")");
		}
		try{
			return this.entityManager.createNamedQuery(CustomerQuery.GET_BY_IDENTITY, Long.class).setParameter(CustomerParameter.IDENTITY, identityCardNumber).getSingleResult() == 1;
		}
		catch (final Exception e){
			throw new PersistenceServiceException("Unknown error during counting Customers by Identitycardnumber (" + identityCardNumber + ")" + e.getLocalizedMessage(),e);
		}
	}

	@Override
	public Customer create(String name, long identityCardNumber, String country, String zipcode, String city,
			String street, int streetNumber, String mothersName, CustomerGender gender)
					throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create customer (name: " + name + ", identityCardNumber: " + identityCardNumber + ", country: " + country + ", zipcode: " + zipcode + ", city: " + city
					+ ", street: " + street + ", streetNumber: " + streetNumber+ ", mothersName: " + mothersName+ ", gender: " + gender + ")");
		}
		try{
			final Customer customer = new Customer(name, identityCardNumber, country, zipcode, city, street, streetNumber, mothersName, gender);
			this.entityManager.persist(customer);
			return customer;
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Customer (" + identityCardNumber + ") " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Customer read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get customer by id (" + id + ")");
		}
		
		Customer result = null;

		try{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_ID, Customer.class).setParameter(CustomerParameter.ID, id).getSingleResult();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by id (" + id + ") " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Customer read(String identityCardNumber) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get customer by identityCardNumber (" + identityCardNumber + ")");
		}
		
		Customer result = null;
		try{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_BY_IDENTITY, Customer.class).setParameter(CustomerParameter.IDENTITY, identityCardNumber).getSingleResult();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customer by identityCardNumber (" + identityCardNumber + ") " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Customer> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all customers");
		}
		List<Customer> result = null;
		try{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_ALL,Customer.class).getResultList();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Customer update(String name, long identityCardNumber, String country, String zipcode, String city,
			String street, int streetNumber, String mothersName, CustomerGender gender)
					throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update customer (name: " + name + ", identityCardNumber: " + identityCardNumber + ", country: " + country + ", zipcode: " + zipcode + ", city: " + city
					+ ", street: " + street + ", streetNumber: " + streetNumber+ ", mothersName: " + mothersName+ ", gender: " + gender + ")");
		}
		try{
			final Customer customer = this.read(identityCardNumber);
			customer.setName(name);
			customer.setCountry(country);
			customer.setZipcode(zipcode);
			customer.setCity(city);
			customer.setStreet(street);
			customer.setStreetNumber(streetNumber);
			customer.setMothersName(mothersName);
			customer.setGender(gender);
			return this.entityManager.merge(customer);
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when merging customer " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(long identityCardNumber) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove customer by identityCardNumber (" + identityCardNumber + ")");
		}
		try{
			this.entityManager.createNamedQuery(CustomerQuery.REMOVE_BY_IDENTITY).setParameter(CustomerParameter.IDENTITY, identityCardNumber).executeUpdate();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing customer by identityCardNumber (" + identityCardNumber + ") " + e.getLocalizedMessage(), e);
		}
		
	}

	@Override
	public List<Customer> read(CustomerGender gender) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get customers by gender");
		}
		List<Customer> result = null;
		try{
			result = this.entityManager.createNamedQuery(CustomerQuery.GET_ALL_BY_GENDER, Customer.class).setParameter(CustomerParameter.GENDER, gender).getResultList();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Customers " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	
	
}
