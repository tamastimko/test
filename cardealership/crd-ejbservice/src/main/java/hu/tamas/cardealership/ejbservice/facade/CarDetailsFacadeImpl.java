package hu.tamas.cardealership.ejbservice.facade;

import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.CarDetailsCriteria;
import hu.tamas.cardealership.ejbservice.domain.CarDetailsStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;
//ha kesz van a persistence reteg, akkor jon ez
public class CarDetailsFacadeImpl implements CarDetailsFacade {

	@Override
	public CarDetailsStub getCarDetail(String model) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarDetailsStub> getCarDetails(CarDetailsCriteria criteria) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDetailsStub saveCarDetail(String maker, String model) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCarDetail(String model) throws FacadeException {
		// TODO Auto-generated method stub
		
	}

}
