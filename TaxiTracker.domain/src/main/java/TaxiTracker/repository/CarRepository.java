package TaxiTracker.repository;

import TaxiTracker.model.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * @author OldGuysRule
 *
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
