package hu.tamas.cardealership.persistence.service;

import java.util.List;

import hu.tamas.cardealership.persistence.entity.Customer;
import hu.tamas.cardealership.persistence.entity.trunk.CustomerGender;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;

public interface CustomerService {
	
	boolean exists(long identityCardNumber) throws PersistenceServiceException;

	Customer create(String name, long identityCardNumber, String country, String zipcode, String city, String street,
			int streetNumber, String mothersName, CustomerGender gender) throws PersistenceServiceException;

	Customer read(Long id) throws PersistenceServiceException; //ID alapon

	Customer read(String identityCardNumber) throws PersistenceServiceException; //szemszam alapon
	
	List<Customer> read(CustomerGender gender) throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;

	Customer update(String name, long identityCardNumber, String country, String zipcode, String city, String street,
			int streetNumber, String mothersName, CustomerGender gender) throws PersistenceServiceException;

	void delete(long identityCardNumber) throws PersistenceServiceException;
}
