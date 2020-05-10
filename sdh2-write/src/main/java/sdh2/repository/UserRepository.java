package sdh2.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdh2.data.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
