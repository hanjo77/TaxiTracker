/**
 * 
 */
package TaxiTracker.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import TaxiTracker.model.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author OldGuysRule
 * 
 */
public class ReadIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"TaxiTracker.domain").createEntityManager();

		Query q = em.createQuery("select p from Position p");
		@SuppressWarnings("unchecked")
		List<Position> foundPositions = q.getResultList();
		Position firstPosition = foundPositions.get(0);
		Assert.assertTrue(firstPosition.getLatitude().equals(new Float(40)));

		Car car = firstPosition.getSession().getCar();
		Assert.assertTrue(car.getName().equals("Hanjo"));
	}

}
