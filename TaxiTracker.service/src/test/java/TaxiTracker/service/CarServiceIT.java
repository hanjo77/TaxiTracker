package TaxiTracker.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TaxiTracker.service.dto.CarDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class CarServiceIT {

    @Inject
    private CarService carService;

    @Test
    public void test() {

        // Create
        CarDTO newCar = new CarDTO();
        newCar.setName("Test");
        newCar = carService.create(newCar);

        // Read
        CarDTO readCar = carService.read(newCar.getId());
        Assert.assertTrue(newCar.getName().equals(readCar.getName()));

        // Update
        readCar.setName("Test2");
        readCar = carService.update(readCar);
        CarDTO updatedCar = carService.read(readCar.getId());
        Assert.assertTrue(readCar.getName().equals(updatedCar.getName()));

        // Delete
        carService.delete(updatedCar);
        CarDTO deletedCar = carService.read(readCar.getId());
        Assert.assertNull(deletedCar);
    }

}