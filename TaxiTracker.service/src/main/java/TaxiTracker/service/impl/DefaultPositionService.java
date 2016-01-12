package TaxiTracker.service.impl;

import TaxiTracker.model.Position;
import TaxiTracker.repository.PositionRepository;
import TaxiTracker.service.PositionService;
import TaxiTracker.service.dto.PositionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

@Named
public class DefaultPositionService implements PositionService {

    @Inject
    private PositionRepository positionRepository;

    private final ModelMapper mapper = new ModelMapper();

    public PositionDTO create(PositionDTO positionDto) {
        Position position = mapper.map(positionDto, Position.class);
        Position persistedPosition = positionRepository.save(position);
        return mapper.map(persistedPosition, PositionDTO.class);
    }

    public PositionDTO read(long id) {
        Position position = positionRepository.findOne(id);
        if (position == null) return null;
        return mapper.map(position, PositionDTO.class);
    }

    public Collection<PositionDTO> list() {
        Iterable<Position> positions = positionRepository.findAll();
        Type listType = new TypeToken<Collection<PositionDTO>>() {
        }.getType();
        return mapper.map(positions, listType);
    }

    public PositionDTO update(PositionDTO positionDto) {
        Position position = mapper.map(positionDto, Position.class);
        Position updatedPosition = positionRepository.save(position);
        return mapper.map(updatedPosition, PositionDTO.class);
    }

    public void delete(PositionDTO positionDto) {
        Position position = positionRepository.findOne(positionDto.getId());
        positionRepository.delete(position);
    }
}
