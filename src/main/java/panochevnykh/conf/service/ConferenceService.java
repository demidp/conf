package panochevnykh.conf.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import panochevnykh.conf.domain.Conference;
import panochevnykh.conf.repository.ConferenceRepository;

import java.util.List;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }
    public List<Conference> findAll(Specification<Conference> confSpecification) {
        return conferenceRepository.findAll(confSpecification);
    }

    public void create(Conference conference) {
        conferenceRepository.save(conference);
    }

}
