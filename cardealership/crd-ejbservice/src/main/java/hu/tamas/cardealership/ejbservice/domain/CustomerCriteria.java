package hu.tamas.cardealership.ejbservice.domain;

public class CustomerCriteria {
	private String country;
	private String city;
	private CustomerGenderStub gender;
	
	public CustomerCriteria() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CustomerGenderStub getGender() {
		return gender;
	}

	public void setGender(CustomerGenderStub gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerCriteria [country=" + country + ", city=" + city + ", gender=" + gender + "]";
	}
	
	
	
	
	
	
}
