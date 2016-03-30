package hu.tamas.cardealership.ejbservice.domain;

public class ServiceStationStub {
	private String name;
	private String city; //cimet itt is szetszedtem, db-ben modositani
	private String street;
	private String streetNumber;
	private long taxnumber;
	private long phoneNumber;
	private String specialization;
	private ServiceStationProfileStub profile;
	
	public ServiceStationStub(String name, String city, String street, String streetNumber, long taxnumber,
			long phoneNumber, String specialization, ServiceStationProfileStub profile) {
		super();
		this.name = name;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.taxnumber = taxnumber;
		this.phoneNumber = phoneNumber;
		this.specialization = specialization;
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public long getTaxnumber() {
		return taxnumber;
	}

	public void setTaxnumber(long taxnumber) {
		this.taxnumber = taxnumber;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ServiceStationProfileStub getProfile() {
		return profile;
	}

	public void setProfile(ServiceStationProfileStub profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "ServiceStationStub [name=" + name + ", city=" + city + ", street=" + street + ", streetNumber="
				+ streetNumber + ", taxnumber=" + taxnumber + ", phoneNumber=" + phoneNumber + ", specialization="
				+ specialization + ", profile=" + profile + "]";
	}
	
	
	
	
}
