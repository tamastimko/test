package hu.tamas.cardealership.ejbservice.domain;

public class CarDetailsCriteria {
	private String maker;
	
	public CarDetailsCriteria(){
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "CarDetailsCriteria [maker=" + maker + "]";
	}
	
}
