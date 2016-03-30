package hu.tamas.cardealership.ejbservice.domain;

public class ServiceStationCriteria {
	
	private String city;
	private String specialization;
	private ServiceStationProfileStub profile;
	
	public ServiceStationCriteria(){
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
		return "ServiceStationCriteria [city=" + city + ", specialization=" + specialization + ", profile=" + profile
				+ "]";
	}
	
	
}
