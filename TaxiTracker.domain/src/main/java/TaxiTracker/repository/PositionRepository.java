package TaxiTracker.repository;

import TaxiTracker.model.Position;
import org.springframework.data.repository.CrudRepository;

/**
 * @author OldGuysRule
 *
 */
public interface PositionRepository extends CrudRepository<Position, Long> {
}
