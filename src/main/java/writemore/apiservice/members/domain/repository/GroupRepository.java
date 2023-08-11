package writemore.apiservice.members.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import writemore.apiservice.members.domain.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
