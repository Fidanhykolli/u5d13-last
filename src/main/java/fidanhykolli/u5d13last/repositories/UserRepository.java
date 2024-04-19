package fidanhykolli.u5d13last.repositories;

import fidanhykolli.u5d13last.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
