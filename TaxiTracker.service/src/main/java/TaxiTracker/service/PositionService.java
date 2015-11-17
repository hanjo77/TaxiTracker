package TaxiTracker.service;

import TaxiTracker.service.dto.PositionDTO;

import java.util.Collection;

/**
 * Created by hanjo on 17.11.15.
 */
public interface PositionService {

    public PositionDTO create(PositionDTO position);

    public PositionDTO read(long id);

    public Collection<PositionDTO> list();

    public PositionDTO update(PositionDTO position);

    public void delete(PositionDTO position);
}
