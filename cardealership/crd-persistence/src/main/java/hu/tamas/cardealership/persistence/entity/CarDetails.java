package hu.tamas.cardealership.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.tamas.cardealership.persistence.parameter.CarDetailsParameter;
import hu.tamas.cardealership.persistence.query.CarDetailsQuery;


@Entity
@Table(name = "CarDetails")
@NamedQueries(value = { 
		@NamedQuery(name = CarDetailsQuery.COUNT_BY_MAKER, query = "SELECT COUNT(c) FROM CarDetails c WHERE c.maker=:" + CarDetailsParameter.MAKER),
		@NamedQuery(name = CarDetailsQuery.COUNT_BY_MODEL, query = "SELECT COUNT(c) FROM CarDetails c WHERE c.model=:" + CarDetailsParameter.MODEL),
		@NamedQuery(name = CarDetailsQuery.GET_ALL, query = "SELECT c FROM CarDetails c ORDER BY c.maker"),
		@NamedQuery(name = CarDetailsQuery.GET_BY_MODEL, query = "SELECT c FROM CarDetails c WHERE c.id=:" + CarDetailsParameter.ID)
})

public class CarDetails implements Serializable {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 6442086443576925178L;

	@Id
	@SequenceGenerator(name = "generatorCarDetails", sequenceName = "cardetails_cardetails_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCarDetails")
	@Column(name = "cardetails_id", nullable = false)
	private Long id;
	
	@Column(name = "cardetails_maker", nullable = false)
	private String maker;
	
	@Column(name = "cardetails_model", nullable = false)
	private String model;

	public CarDetails(String maker, String model) {
		super();
		this.maker = maker;
		this.model = model;
	}
	
	public CarDetails(){
		this(null,null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "CarDetails [id=" + id + ", maker=" + maker + ", model=" + model + "]";
	}
	
	
	
	
}
