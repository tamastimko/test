package hu.tamas.cardealership.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.ServiceStationProfileStub;
import hu.tamas.cardealership.ejbservice.domain.ServiceStationStub;
import hu.tamas.cardealership.persistence.entity.ServiceStation;

public class ServiceStationConverterImpl implements ServiceStationConverter {

	@Override
	public ServiceStationStub to(ServiceStation servicestation) {
		final ServiceStationProfileStub profile = ServiceStationProfileStub.valueOf(servicestation.getProfile().toString());
		return new ServiceStationStub(servicestation.getName(), servicestation.getCity(), servicestation.getStreet(), servicestation.getStreetNumber(),
				servicestation.getTaxnumber(), servicestation.getPhonenumber(), servicestation.getSpecialization(), profile);
	}

	@Override
	public List<ServiceStationStub> to(List<ServiceStation> servicestations) {
		final List<ServiceStationStub> result = new ArrayList<>();
		for(ServiceStation actual : servicestations){
			result.add(this.to(actual));
		}
		return result;
	}

}
