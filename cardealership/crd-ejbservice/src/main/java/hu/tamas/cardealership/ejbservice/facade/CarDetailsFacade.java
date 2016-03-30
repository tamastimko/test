package hu.tamas.cardealership.ejbservice.facade;

import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.CarDetailsCriteria;
import hu.tamas.cardealership.ejbservice.domain.CarDetailsStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;

public interface CarDetailsFacade {
	
	CarDetailsStub getCarDetail(String model) throws FacadeException;

	List<CarDetailsStub> getCarDetails(CarDetailsCriteria criteria) throws FacadeException;

	CarDetailsStub saveCarDetail(String maker, String model) throws FacadeException;

	void removeCarDetail(String model) throws FacadeException;
}
