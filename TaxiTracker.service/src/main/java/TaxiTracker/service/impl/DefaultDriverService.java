package TaxiTracker.service.impl;

import TaxiTracker.model.Driver;
import TaxiTracker.repository.DriverRepository;
import TaxiTracker.service.DriverService;
import TaxiTracker.service.dto.DriverDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

@Named
public class DefaultDriverService implements DriverService {

    @Inject
    private DriverRepository driverRepository;

    private final ModelMapper mapper = new ModelMapper();

    public DriverDTO create(DriverDTO driverDto) {
        Driver driver = mapper.map(driverDto, Driver.class);
        Driver persistedDriver = driverRepository.save(driver);
        return mapper.map(persistedDriver, DriverDTO.class);
    }

    public DriverDTO read(long id) {
        Driver driver = driverRepository.findOne(id);
        if (driver == null) return null;
        return mapper.map(driver, DriverDTO.class);
    }

    public Collection<DriverDTO> list() {
        Iterable<Driver> drivers = driverRepository.findAll();
        Type listType = new TypeToken<Collection<DriverDTO>>() {
        }.getType();
        return mapper.map(drivers, listType);
    }

    public DriverDTO update(DriverDTO driverDto) {
        Driver driver = mapper.map(driverDto, Driver.class);
        Driver updatedDriver = driverRepository.save(driver);
        return mapper.map(updatedDriver, DriverDTO.class);
    }

    public void delete(DriverDTO driverDto) {
        Driver driver = driverRepository.findOne(driverDto.getId());
        driverRepository.delete(driver);
    }
}
