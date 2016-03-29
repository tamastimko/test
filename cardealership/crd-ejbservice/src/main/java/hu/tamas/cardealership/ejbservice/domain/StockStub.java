package hu.tamas.cardealership.ejbservice.domain;

import java.sql.Date;

public class StockStub {
	
	private String numberplate;
	private String vinNumber;
	private StockFueltypeStub fueltype;
	private int yearOfManufacturing;
	private Date getUnit;
	private int price; //dbbol kimaradt, javitani
	
	public StockStub(String numberplate, String vinNumber, StockFueltypeStub fueltype, int yearOfManufacturing,
			Date getUnit, int price) {
		super();
		this.numberplate = numberplate;
		this.vinNumber = vinNumber;
		this.fueltype = fueltype;
		this.yearOfManufacturing = yearOfManufacturing;
		this.getUnit = getUnit;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNumberplate() {
		return numberplate;
	}

	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public StockFueltypeStub getFueltype() {
		return fueltype;
	}

	public void setFueltype(StockFueltypeStub fueltype) {
		this.fueltype = fueltype;
	}

	public int getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(int yearOfManufacturing) {
		this.yearOfManufacturing = yearOfManufacturing;
	}

	public Date getGetUnit() {
		return getUnit;
	}

	public void setGetUnit(Date getUnit) {
		this.getUnit = getUnit;
	}

	@Override
	public String toString() {
		return "Stock [numberplate=" + numberplate + ", vinNumber=" + vinNumber + ", fueltype=" + fueltype
				+ ", yearOfManufacturing=" + yearOfManufacturing + ", getUnit=" + getUnit + ", price=" + price + "]";
	}

	
	
	
	
	
}
