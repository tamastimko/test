package hu.tamas.cardealership.ejbservice.converter;

import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.ServiceStationStub;
import hu.tamas.cardealership.persistence.entity.ServiceStation;

public interface ServiceStationConverter {
	
	ServiceStationStub to(ServiceStation servicestation);
	List<ServiceStationStub> to(List<ServiceStation> servicestations);
}
