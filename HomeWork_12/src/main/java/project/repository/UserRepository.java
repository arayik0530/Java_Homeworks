package project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
