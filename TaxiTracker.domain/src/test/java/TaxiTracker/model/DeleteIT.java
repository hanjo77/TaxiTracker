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
public class DeleteIT {

    private EntityManager em;

	@Test
	public void test() {

        this.em = Persistence.createEntityManagerFactory(
                "TaxiTracker.domain").createEntityManager();

        String[] classes = new String[] {
                "Position",
                "Session",
                "Driver",
                "Car",
        };

        for (int i = 0; i < classes.length; i++) {
            deleteItems(classes[i]);
        }
	}

    private void deleteItems(String className) {

        Query q = this.em.createQuery("select a from "+ className +" a");
        @SuppressWarnings("unchecked")
        List<Object> items = q.getResultList();
        for (int i = 0; i < items.size(); i++) {
            this.em.getTransaction().begin();
            this.em.remove(items.get(i));
            this.em.getTransaction().commit();
        }
        Assert.assertEquals(q.getResultList().size(), 0);
    }
}
