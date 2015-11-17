package TaxiTracker.service;

import TaxiTracker.service.dto.DriverDTO;

import java.util.Collection;

/**
 * Created by hanjo on 17.11.15.
 */
public interface DriverService {

    public DriverDTO create(DriverDTO driver);

    public DriverDTO read(long id);

    public Collection<DriverDTO> list();

    public DriverDTO update(DriverDTO driver);

    public void delete(DriverDTO driver);
}
