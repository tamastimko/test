package hu.tamas.cardealership.ejbservice.facade;

import java.sql.Date;
import java.util.List;

import hu.tamas.cardealership.ejbservice.domain.StockCriteria;
import hu.tamas.cardealership.ejbservice.domain.StockFueltypeStub;
import hu.tamas.cardealership.ejbservice.domain.StockStub;
import hu.tamas.cardealership.ejbservice.exception.FacadeException;

public class StockFacadeImpl implements StockFacade {
	//ha meg lesz a persistence reteg, akkor jon ez 
	@Override
	public StockStub getStockItem(String vinNumber) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockStub> getStockItems(StockCriteria criteria) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockStub saveStockItem(String numberplate, String vinNumber, StockFueltypeStub fueltype,
			int yearOfManufacturing, Date getUnit, int price) throws FacadeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStockItem(String vinNumber) throws FacadeException {
		// TODO Auto-generated method stub
		
	}



	

}
