package hu.tamas.cardealership.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.tamas.cardealership.persistence.entity.CarDetails;
import hu.tamas.cardealership.persistence.exception.PersistenceServiceException;



@Stateless(mappedName = "ejb/cardetailsservice")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CarDetailsServiceImpl implements CarDetailsService {

	
	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	@PersistenceContext(unitName = "crd-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public boolean exists(String model) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Cardetail by model  (" + model + ")");
		}
		//try{
			//return this.entityManager.createNamedQuery(CarDetailsQuery.GET_BY_MODEL,String.class).setParameter(CarDetailsParameter.MODEL, model).getSingleResult() == 1;
		//}
		return false;
		//egyenlore, at kell meg gondolni, igy nem lesz jo
	}

	@Override
	public CarDetails create(String maker, String model) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create cardetail (maker: " + maker + ", maker: " + model + ")");
		}
		try{
			final CarDetails cardetail = new CarDetails(maker, model);
			this.entityManager.persist(cardetail);
			return cardetail;
		}
		catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting cardetail (" + model + ") " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public CarDetails read(Long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDetails read(String model) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarDetails> readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDetails update(String maker, String model) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long model) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		
	}
	
}
