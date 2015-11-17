package TaxiTracker.repository;

import TaxiTracker.model.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * @author OldGuysRule
 *
 */
public interface DriverRepository extends CrudRepository<Driver, Long> {
}
