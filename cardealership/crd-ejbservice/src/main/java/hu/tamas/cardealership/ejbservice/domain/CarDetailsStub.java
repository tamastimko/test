package hu.tamas.cardealership.ejbservice.domain;

public class CarDetailsStub {
	private String maker;
	private String model;
	
	public CarDetailsStub(String maker, String model) {
		super();
		this.maker = maker;
		this.model = model;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "CarDetails [maker=" + maker + ", model=" + model + "]";
	}
	
	
}
