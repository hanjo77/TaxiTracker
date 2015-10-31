/**
 * 
 */
package TaxiTracker.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * @author OldGuysRule
 * 
 */
public class CreateIT {

	@Test
	public void test() {
        EntityManager em = Persistence.createEntityManagerFactory(
                "TaxiTracker.domain").createEntityManager();
        em.getTransaction().begin();

        Driver driver = new Driver();
		driver.setFirstname("Hansjürg");
		driver.setLastname("Jaggi");
		driver.setToken("jaggh1");
        em.persist(driver);

		Car car = new Car();
		car.setName("Hanjo");
        car.setToken("dummy");
        em.persist(car);

        Session session = new Session();
        session.setCar(car);
        session.setDriver(driver);
        session.setStartTime(new Date());
        session.setEndTime(new Date());
        em.persist(session);

        for (int i = 0; i < 10; i++) {
            Position position = new Position();
            position.setSession(session);
            position.setLatitude(new Float(40+i));
            position.setLongitude(new Float(2+i));
            position.setTime(new Date());
            em.persist(position);
        }

        em.getTransaction().commit();
	}
}
