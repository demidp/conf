package panochevnykh.conf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import panochevnykh.conf.domain.Conference;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long>, JpaSpecificationExecutor<Conference> {

}
