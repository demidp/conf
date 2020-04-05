package panochevnykh.conf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panochevnykh.conf.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
