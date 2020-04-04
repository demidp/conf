package panochevnykh.conf.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import panochevnykh.conf.domain.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
