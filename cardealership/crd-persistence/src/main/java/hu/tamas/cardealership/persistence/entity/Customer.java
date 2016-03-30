package hu.tamas.cardealership.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import hu.tamas.cardealership.persistence.query.CustomerQuery;
import hu.tamas.cardealership.persistence.parameter.CustomerParameter;
import hu.tamas.cardealership.persistence.entity.trunk.CustomerGender;

@Entity
@Table(name = "Customer")
@NamedQueries(value = { 
		@NamedQuery(name = CustomerQuery.COUNT_BY_IDENTITY, query = "SELECT COUNT(c) FROM Customer c WHERE c.identityCardNumber=:" + CustomerParameter.IDENTITY),
		@NamedQuery(name = CustomerQuery.GET_BY_ID, query = "SELECT c FROM Customer c WHERE c.id=:" + CustomerParameter.ID),
		@NamedQuery(name = CustomerQuery.GET_BY_IDENTITY, query = "SELECT c FROM Customer c WHERE c.identityCardNumber=:" + CustomerParameter.IDENTITY),
		@NamedQuery(name = CustomerQuery.GET_ALL_BY_GENDER, query = "SELECT c FROM Customer c WHERE c.gender=:" + CustomerParameter.GENDER + " ORDER BY c.city"),
		@NamedQuery(name = CustomerQuery.GET_BY_CITY, query = "SELECT c FROM Customer c WHERE c.city=:" + CustomerParameter.CITY),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT c FROM Customer c ORDER BY c.name"),
		@NamedQuery(name = CustomerQuery.REMOVE_BY_IDENTITY, query = "DELETE FROM Customer c WHERE c.identityCardNumber=:" + CustomerParameter.IDENTITY)
})


public class Customer implements Serializable {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 4223202666425527400L;

	@Id
	@SequenceGenerator(name = "generatorCustomer", sequenceName = "customer_customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCustomer")
	@Column(name = "customer_id", nullable = false)
	private Long id;
	
	@Column(name = "customer_name", nullable = false)
	private String name;
	
	@Column(name = "customer_identityCardNumber", nullable = false)
	private long identityCardNumber;
	
	@Column(name = "customer_country", nullable = false)
	private String country;
	
	@Column(name = "customer_zipcode", nullable = false)
	private String zipcode;
	
	@Column(name = "customer_city", nullable = false)
	private String city;
	
	@Column(name = "customer_street", nullable = false)
	private String street;
	
	@Column(name = "customer_streetNumber", nullable = false)
	private int streetNumber;
	
	@Column(name = "customer_mothersName", nullable = false)
	private String mothersName;
	
	//enum miatti db struktura valtozas kell, masik table idhoz kapcsolt nevvel, mindenhol kell, ahol enum lesz. 
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "customer_gender_id", nullable = false)
	private CustomerGender gender;
	
	public Customer(){
		this(null, 0l, null, null, null, null, 0, null, CustomerGender.MALE);
	}

	public Customer(String name, long identityCardNumber, String country, String zipcode, String city, String street,
			int streetNumber, String mothersName, CustomerGender gender) {
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

	public long getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(long identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
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

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public CustomerGender getGender() {
		return gender;
	}

	public void setGender(CustomerGender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", identityCardNumber=" + identityCardNumber + ", country="
				+ country + ", zipcode=" + zipcode + ", city=" + city + ", street=" + street + ", streetNumber="
				+ streetNumber + ", mothersName=" + mothersName + ", gender=" + gender + "]";
	}
	
	
	
	
	
}
