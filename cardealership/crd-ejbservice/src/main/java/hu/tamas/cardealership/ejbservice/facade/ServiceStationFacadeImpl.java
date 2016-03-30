package hu.tamas.cardealership.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.tamas.cardealership.ejbservice.converter.ServiceStationConverter;
import hu.tamas.cardealership.ejbservice.domain.ServiceStationCriteria;
import hu.tamas.cardealership.ejbservice.domain.ServiceStationProfileStub;
import hu.tamas.cardealership.ejbservice.domain.ServiceStationStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;
import hu.tamas.cardealership.persistence.entity.ServiceStation;
import hu.tamas.cardealership.persistence.entity.trunk.ServiceStationProfile;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;
import hu.tamas.cardealership.persistence.service.ServiceStationService;

@Stateless(mappedName = "ejb/servicestationFacade") 
public class ServiceStationFacadeImpl implements ServiceStationFacade {

	private static final Logger LOGGER = Logger.getLogger(CustomerFacadeImpl.class);
	
	@EJB 
	ServiceStationService service;
	
	@EJB
	ServiceStationConverter converter;
	
	@Override
	public ServiceStationStub getServiceStation(long taxnumber) throws FacadeException {
		try{
			final ServiceStationStub stub = this.converter.to(this.service.read(taxnumber));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get servicestation by taxnumber (" + taxnumber + ") --> " + stub);
			}
			return stub;
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<ServiceStationStub> getServiceStations(ServiceStationCriteria criteria) throws FacadeException {
		List<ServiceStationStub> stubs = null;
		try{
			List<ServiceStation> servicestations = null;
			if(criteria.getProfile() == null){
				servicestations = this.service.readAll();
			}
			else{
				servicestations = this.service.read(ServiceStationProfile.valueOf(criteria.getProfile().name()));
			}
			stubs = this.converter.to(servicestations);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get servicestations by criteria (" + criteria + ") --> " + stubs.size() + " customer(s)");
			}
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
		
	}

	@Override
	public ServiceStationStub saveServiceStation(String name, String city, String street, String streetNumber,
			long taxnumber, long phoneNumber, String specialization, ServiceStationProfileStub profile)
					throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Save servicestation (" + name + ")");
		}
		try{
			ServiceStation servicestation = null;
			if(this.service.exists(taxnumber)){
				servicestation = this.service.update(name, city, street, streetNumber, taxnumber, phoneNumber, specialization, ServiceStationProfile.valueOf(profile.name()));
			}
			else{
				servicestation = this.service.update(name, city, street, streetNumber, taxnumber, phoneNumber, specialization, ServiceStationProfile.valueOf(profile.name()));
			}
			return this.converter.to(servicestation);
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void removeServiceStation(long taxnumber) throws FacadeException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Delete servicestation (" + taxnumber + ")");
		}
		try{
			this.service.delete(taxnumber);
		}
		catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		
	}

}
