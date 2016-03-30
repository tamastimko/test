package hu.tamas.cardealership.persistence.service;

import java.util.List;

import hu.tamas.cardealership.persistence.entity.ServiceStation;
import hu.tamas.cardealership.persistence.entity.trunk.ServiceStationProfile;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;

public interface ServiceStationService {

	boolean exists(long taxnumber) throws PersistenceServiceException;

	ServiceStation create(String name, String city, String street, String streetNumber, Long taxnumber,
			Long phonenumber, String specialization, ServiceStationProfile profile) throws PersistenceServiceException;

	ServiceStation read(Long id) throws PersistenceServiceException; //ID alapon

	ServiceStation read(String taxnumber) throws PersistenceServiceException; //adoszam alapon
	
	List<ServiceStation> read(ServiceStationProfile profile) throws PersistenceServiceException;

	List<ServiceStation> readAll() throws PersistenceServiceException;

	ServiceStation update(String name, String city, String street, String streetNumber, Long taxnumber,
			Long phonenumber, String specialization, ServiceStationProfile profile) throws PersistenceServiceException;

	void delete(long taxnumber) throws PersistenceServiceException;
}
