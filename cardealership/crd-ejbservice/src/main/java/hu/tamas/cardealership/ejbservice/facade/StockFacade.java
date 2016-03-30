package hu.tamas.cardealership.ejbservice.facade;

import java.sql.Date;
import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.StockCriteria;
import hu.tamas.cardealership.ejbservice.domain.StockFueltypeStub;
import hu.tamas.cardealership.ejbservice.domain.StockStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;


public interface StockFacade {
	
	StockStub getStockItem(String vinNumber) throws FacadeException;

	List<StockStub> getStockItems(StockCriteria criteria) throws FacadeException;

	StockStub saveStockItem(String numberplate, String vinNumber, StockFueltypeStub fueltype, int yearOfManufacturing,
			Date getUnit, int price) throws FacadeException;

	void removeStockItem(String vinNumber) throws FacadeException;
}
