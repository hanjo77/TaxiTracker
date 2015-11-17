package TaxiTracker.repository;

import TaxiTracker.model.Session;
import org.springframework.data.repository.CrudRepository;

/**
 * @author OldGuysRule
 *
 */
public interface SessionRepository extends CrudRepository<Session, Long> {
}
