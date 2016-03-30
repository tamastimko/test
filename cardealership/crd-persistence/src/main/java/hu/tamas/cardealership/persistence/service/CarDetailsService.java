package hu.tamas.cardealership.persistence.service;

import java.util.List;

import hu.tamas.cardealership.persistence.entity.CarDetails;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;


public interface CarDetailsService {
	
	boolean exists(String model) throws PersistenceServiceException;

	CarDetails create(String maker, String model) throws PersistenceServiceException;

	CarDetails read(Long id) throws PersistenceServiceException; //ID alapon

	CarDetails read(String model) throws PersistenceServiceException; //model alapon

	List<CarDetails> readAll() throws PersistenceServiceException;

	CarDetails update(String maker, String model) throws PersistenceServiceException;

	void delete(long model) throws PersistenceServiceException;
}
