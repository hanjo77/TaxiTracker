package TaxiTracker.repository;

import TaxiTracker.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * @author OldGuysRule
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class CarRepositoryIT {

    @Inject
    private CarRepository carRepository;

    @Test
    public void test() {
        // Create
        Car newCar = new Car();
        newCar.setName("Test");
        carRepository.save(newCar);
        // Read
        Car readCar = carRepository.findOne(newCar.getId());
        org.junit.Assert.assertTrue(newCar.getName().

        equals(readCar.getName()

        ));
        // Update
        readCar.setName("Test2");
        readCar=carRepository.save(readCar);
        Car updatedCar = carRepository.findOne(readCar.getId());
        org.junit.Assert.assertTrue(readCar.getName().

        equals(updatedCar.getName()

        ));
        // Delete
        carRepository.delete(updatedCar);
        Car deletedCar = carRepository.findOne(readCar.getId());
        org.junit.Assert.assertNull(deletedCar);
    }
}
