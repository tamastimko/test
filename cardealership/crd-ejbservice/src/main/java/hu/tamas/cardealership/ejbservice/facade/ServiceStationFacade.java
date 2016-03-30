package hu.tamas.cardealership.ejbservice.facade;

import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.ServiceStationCriteria;
import hu.tamas.cardealership.ejbservice.domain.ServiceStationProfileStub;
import hu.tamas.cardealership.ejbservice.domain.ServiceStationStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;

public interface ServiceStationFacade {

	ServiceStationStub getServiceStation(long taxnumber) throws FacadeException; //ez az egyedi, de jobb lenne nev alapjan, ertelmesebb

	List<ServiceStationStub> getServiceStations(ServiceStationCriteria criteria) throws FacadeException;

	ServiceStationStub saveServiceStation(String name, String city, String street, String streetNumber, long taxnumber,
			long phoneNumber, String specialization, ServiceStationProfileStub profile) throws FacadeException;

	void removeServiceStation(long taxnumber) throws FacadeException;
}
