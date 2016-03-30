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

import hu.tamas.cardealership.persistence.entity.ServiceStation;
import hu.tamas.cardealership.persistence.entity.trunk.ServiceStationProfile;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;
import hu.tamas.cardealership.persistence.query.ServiceStationQuery;
import hu.tamas.cardealership.persistence.parameter.ServiceStationParameter;

@Stateless(mappedName = "ejb/servicestationservice")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ServiceStationServiceImpl implements ServiceStationService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	@PersistenceContext(unitName = "crd-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public boolean exists(long taxnumber) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Servicestation by taxnumber  (" + taxnumber + ")");
		}
		try{
			return this.entityManager.createNamedQuery(ServiceStationQuery.GET_BY_TAXNUMBER,Long.class).setParameter(ServiceStationParameter.TAXNUMBER, taxnumber).getSingleResult() == 1;
		}
		catch (final Exception e){
			throw new PersistenceServiceException("Unknown error during counting Servicestations by taxnumber (" + taxnumber + ")" + e.getLocalizedMessage(),e);
		}
	}

	@Override
	public ServiceStation create(String name, String city, String street, String streetNumber, Long taxnumber,
			Long phonenumber, String specialization, ServiceStationProfile profile) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create Servicestation (name: " + name + ", city: " + city + ", street: " + street + ", streetNumber: " + streetNumber + ", taxnumber: " + taxnumber
					+ ", phonenumber: " + phonenumber + ", specialization: " + specialization+ ", profile: " + profile + ")");
		}
		try{
			final ServiceStation servicestation = new ServiceStation(name,city,street,streetNumber,taxnumber,phonenumber,specialization,profile);
			this.entityManager.persist(servicestation);
			return servicestation;
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Servicestation (" + taxnumber + ") " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public ServiceStation read(Long id) throws PersistenceServiceException {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get ServiceStaion by id (" + id + ")");
		}
		
		ServiceStation result = null;
		try{
			result = this.entityManager.createNamedQuery(ServiceStationQuery.GET_BY_ID, ServiceStation.class).setParameter(ServiceStationParameter.ID, id).getSingleResult();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Servicestation by id (" + id + ") " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public ServiceStation read(String taxnumber) throws PersistenceServiceException {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get ServiceStaion by taxnumber (" + taxnumber + ")");
		}
		ServiceStation result = null;
		try{
			result = this.entityManager.createNamedQuery(ServiceStationQuery.GET_BY_TAXNUMBER, ServiceStation.class).setParameter(ServiceStationParameter.TAXNUMBER, taxnumber).getSingleResult();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Servicestation by taxnumber (" + taxnumber + ") " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<ServiceStation> read(ServiceStationProfile profile) throws PersistenceServiceException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Servicestations by profile");
		}
		
		List<ServiceStation> result = null;
		try{
			result = this.entityManager.createNamedQuery(ServiceStationQuery.GET_ALL_BY_PROFILE, ServiceStation.class).setParameter(ServiceStationParameter.PROFILE, profile).getResultList();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Servicestations by profile " + e.getLocalizedMessage(), e);
		}
		return result;

	}

	@Override
	public List<ServiceStation> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get all Servicestations");
		}
		
		List<ServiceStation> result = null;
		try{
			result = this.entityManager.createNamedQuery(ServiceStationQuery.GET_ALL,ServiceStation.class).getResultList();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching ServiceStations " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public ServiceStation update(String name, String city, String street, String streetNumber, Long taxnumber,
			Long phonenumber, String specialization, ServiceStationProfile profile) throws PersistenceServiceException {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update Servicestation (name: " + name + ", city: " + city + ", street: " + street + ", streetNumber: " + streetNumber + ", taxnumber: " + taxnumber
					+ ", phonenumber: " + phonenumber + ", specialization: " + specialization+ ", profile: " + profile + ")");
		}
		try{
			final ServiceStation servicestation = this.read(taxnumber);
			servicestation.setName(name);
			servicestation.setCity(city);
			servicestation.setStreet(street);
			servicestation.setStreetNumber(streetNumber);
			servicestation.setTaxnumber(taxnumber);
			servicestation.setPhonenumber(phonenumber);
			servicestation.setSpecialization(specialization);
			servicestation.setProfile(profile);
			return this.entityManager.merge(servicestation);
			
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when merging servicestation " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(long taxnumber) throws PersistenceServiceException {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove customer by taxnumber (" + taxnumber + ")");
		}
		try{
			this.entityManager.createNamedQuery(ServiceStationQuery.REMOVE_BY_TAXNUMBER).setParameter(ServiceStationParameter.TAXNUMBER, taxnumber).executeUpdate();
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing servicestation by taxnumber (" + taxnumber + ") " + e.getLocalizedMessage(), e);
		}
		
	}

}
