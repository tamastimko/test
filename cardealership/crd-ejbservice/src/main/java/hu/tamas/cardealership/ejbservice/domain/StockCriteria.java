package hu.tamas.cardealership.ejbservice.domain;

public class StockCriteria {
	
	private StockFueltypeStub fuelType;
	private int yearOfManufacturing;
	private int minimumprice;
	private int maximumprice;
	
	public StockCriteria(){
	}

	public int getMinimumprice() {
		return minimumprice;
	}

	public void setMinimumprice(int minimumprice) {
		this.minimumprice = minimumprice;
	}

	public int getMaximumprice() {
		return maximumprice;
	}

	public void setMaximumprice(int maximumprice) {
		this.maximumprice = maximumprice;
	}

	public StockFueltypeStub getFuelType() {
		return fuelType;
	}

	public void setFuelType(StockFueltypeStub fuelType) {
		this.fuelType = fuelType;
	}

	public int getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(int yearOfManufacturing) {
		this.yearOfManufacturing = yearOfManufacturing;
	}

	@Override
	public String toString() {
		return "StockCriteria [fuelType=" + fuelType + ", yearOfManufacturing=" + yearOfManufacturing
				+ ", minimumprice=" + minimumprice + ", maximumprice=" + maximumprice + "]";
	}

	
	
	
}
