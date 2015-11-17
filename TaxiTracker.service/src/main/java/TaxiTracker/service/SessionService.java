package TaxiTracker.service;

import TaxiTracker.service.dto.SessionDTO;

import java.util.Collection;

/**
 * Created by hanjo on 17.11.15.
 */
public interface SessionService {

    public SessionDTO create(SessionDTO session);

    public SessionDTO read(long id);

    public Collection<SessionDTO> list();

    public SessionDTO update(SessionDTO session);

    public void delete(SessionDTO session);
}
