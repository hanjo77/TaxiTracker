package TaxiTracker.service.impl;

import TaxiTracker.model.Session;
import TaxiTracker.repository.SessionRepository;
import TaxiTracker.service.SessionService;
import TaxiTracker.service.dto.SessionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

@Named
public class DefaultSessionService implements SessionService {

    @Inject
    private SessionRepository sessionRepository;

    private final ModelMapper mapper = new ModelMapper();

    public SessionDTO create(SessionDTO sessionDto) {
        Session session = mapper.map(sessionDto, Session.class);
        Session persistedSession = sessionRepository.save(session);
        return mapper.map(persistedSession, SessionDTO.class);
    }

    public SessionDTO read(long id) {
        Session session = sessionRepository.findOne(id);
        if (session == null) return null;
        return mapper.map(session, SessionDTO.class);
    }

    public Collection<SessionDTO> list() {
        Iterable<Session> sessions = sessionRepository.findAll();
        Type listType = new TypeToken<Collection<SessionDTO>>() {
        }.getType();
        return mapper.map(sessions, listType);
    }

    public SessionDTO update(SessionDTO sessionDto) {
        Session session = mapper.map(sessionDto, Session.class);
        Session updatedSession = sessionRepository.save(session);
        return mapper.map(updatedSession, SessionDTO.class);
    }

    public void delete(SessionDTO sessionDto) {
        Session session = sessionRepository.findOne(sessionDto.getId());
        sessionRepository.delete(session);
    }
}
