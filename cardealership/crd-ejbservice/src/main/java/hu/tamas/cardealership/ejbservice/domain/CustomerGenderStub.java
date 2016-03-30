package hu.tamas.cardealership.ejbservice.domain;

public enum CustomerGenderStub {
	
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other");
	
	private final String label;

	private CustomerGenderStub(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public String getName(){
		return this.name();
	}
}
