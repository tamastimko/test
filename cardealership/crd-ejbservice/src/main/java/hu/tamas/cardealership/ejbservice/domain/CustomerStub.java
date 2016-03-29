package hu.tamas.cardealership.ejbservice.domain;

public class CustomerStub {
	
	private String name;
	private long identityCardNumber;
	private String country; //cimet szetszedtem orszag-irszam-varos-utca-hazszamra, dbben is javitani
	private String zipcode;
	private String city;
	private String street;
	private int streetNumber;
	private String mothersName;
	private String gender; //lehetne bool is, 0 ha no, 1 ha ferfi
	
	public CustomerStub(){
		this(null,0l,null,null,null,null,0,null,null);
	}
	

	public CustomerStub(String name, long identityCardNumber, String country, String zipcode, String city,
			String street, int streetNumber, String mothersName, String gender) {
		super();
		this.name = name;
		this.identityCardNumber = identityCardNumber;
		this.country = country;
		this.zipcode = zipcode;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.mothersName = mothersName;
		this.gender = gender;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(long identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	@Override
	public String toString() {
		return "CustomerStub [name=" + name + ", identityCardNumber=" + identityCardNumber + ", country=" + country
				+ ", zipcode=" + zipcode + ", city=" + city + ", street=" + street + ", streetNumber=" + streetNumber
				+ ", mothersName=" + mothersName + ", gender=" + gender + "]";
	}

	
	
	
	
	
	
	
}
