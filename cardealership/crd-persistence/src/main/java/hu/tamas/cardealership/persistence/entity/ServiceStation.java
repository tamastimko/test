package hu.tamas.cardealership.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.tamas.cardealership.persistence.entity.trunk.ServiceStationProfile;
import hu.tamas.cardealership.persistence.parameter.ServiceStationParameter;
import hu.tamas.cardealership.persistence.query.ServiceStationQuery;

@Entity
@Table(name = "ServiceStation")
@NamedQueries(value = { 
		@NamedQuery(name = ServiceStationQuery.COUNT_BY_TAXNUMBER, query = "SELECT COUNT(s) FROM ServiceStation s WHERE s.taxnumber=:" + ServiceStationParameter.TAXNUMBER),
		@NamedQuery(name = ServiceStationQuery.GET_BY_ID, query = "SELECT s FROM ServiceStation s WHERE s.id=:" + ServiceStationParameter.ID),
		@NamedQuery(name = ServiceStationQuery.GET_BY_TAXNUMBER, query = "SELECT s FROM ServiceStation s WHERE s.taxnumber=:" + ServiceStationParameter.TAXNUMBER),
		@NamedQuery(name = ServiceStationQuery.GET_ALL_BY_PROFILE, query = "SELECT s FROM ServiceStation s WHERE s.profile=:" + ServiceStationParameter.PROFILE + " ORDER BY s.city"),
		@NamedQuery(name = ServiceStationQuery.GET_ALL_BY_SPECS, query = "SELECT s FROM ServiceStation s WHERE s.specialization=:" + ServiceStationParameter.SPECS + " ORDER BY s.city"),
		@NamedQuery(name = ServiceStationQuery.GET_BY_CITY, query = "SELECT s FROM ServiceStation s WHERE s.city=:" + ServiceStationParameter.CITY),
		@NamedQuery(name = ServiceStationQuery.GET_ALL, query = "SELECT s FROM ServiceStation s ORDER BY s.name"),
		@NamedQuery(name = ServiceStationQuery.REMOVE_BY_TAXNUMBER, query = "DELETE FROM ServiceStation s WHERE s.taxnumber=:" + ServiceStationParameter.TAXNUMBER)
})

public class ServiceStation implements Serializable {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 8008713161524793727L;

	@Id
	@SequenceGenerator(name = "generatorServiceStation", sequenceName = "servicestation_servicestation_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorServiceStation")
	@Column(name = "servicestation_id", nullable = false)
	private Long id;
	
	@Column(name = "servicestation_name", nullable = false)
	private String name;
	
	@Column(name = "servicestation_city", nullable = false)
	private String city;
	
	@Column(name = "servicestation_street", nullable = false)
	private String street;
	
	@Column(name = "servicestation_streetnumber", nullable = false)
	private String streetNumber;
	
	@Column(name = "servicestation_taxnumber", nullable = false)
	private Long taxnumber;
	
	@Column(name = "servicestation_phonenumber", nullable = false)
	private Long phonenumber;
	
	@Column(name = "servicestation_specialization", nullable = false)
	private String specialization;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "servicestation_profile", nullable = false)
	private ServiceStationProfile profile;

	public ServiceStation(String name, String city, String street, String streetNumber, Long taxnumber,
			Long phonenumber, String specialization, ServiceStationProfile profile) {
		super();
		this.name = name;
		this.city = city;
		this.street = street;
		this.streetNumber = streetNumber;
		this.taxnumber = taxnumber;
		this.phonenumber = phonenumber;
		this.specialization = specialization;
		this.profile = profile;
	}
	
	public ServiceStation(){
		this(null,null,null,null,0l,0l,null,ServiceStationProfile.ELECTRICAL);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getTaxnumber() {
		return taxnumber;
	}

	public void setTaxnumber(Long taxnumber) {
		this.taxnumber = taxnumber;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ServiceStationProfile getProfile() {
		return profile;
	}

	public void setProfile(ServiceStationProfile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "ServiceStation [id=" + id + ", name=" + name + ", city=" + city + ", street=" + street
				+ ", streetNumber=" + streetNumber + ", taxnumber=" + taxnumber + ", phonenumber=" + phonenumber
				+ ", specialization=" + specialization + ", profile=" + profile + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
