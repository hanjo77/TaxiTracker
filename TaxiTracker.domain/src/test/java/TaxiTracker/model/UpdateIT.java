/**
 * 
 */
package TaxiTracker.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author OldGuysRule
 * 
 */
public class UpdateIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"TaxiTracker.domain").createEntityManager();

		Query q = em.createQuery("select c from Car c");
		@SuppressWarnings("unchecked")
		List<Car> foundCars = q.getResultList();
		Car firstCar = foundCars.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstCar.setToken("changed");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstCar.getToken().equals("changed"));
	}

}
