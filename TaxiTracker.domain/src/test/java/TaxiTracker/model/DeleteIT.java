/**
 * 
 */
package TaxiTracker.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import TaxiTracker.model.Position;
import org.junit.Test;

/**
 * @author OldGuysRule
 * 
 */
public class DeleteIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"TaxiTracker.domain").createEntityManager();

        Query q = em.createQuery("select a from Position a");
        @SuppressWarnings("unchecked")
        List<Position> foundPositions = q.getResultList();
        Position firstPosition = foundPositions.get(0);
        // Assert.assertTrue(firstAuthor.getLastname().equals("Tolkien"));

        // Write access needs a transaction
        em.getTransaction().begin();
        em.remove(firstPosition);
		em.getTransaction().commit();
	}
}
