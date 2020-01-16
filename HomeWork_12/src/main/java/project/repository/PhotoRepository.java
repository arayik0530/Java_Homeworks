package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.models.PhotoEntity;

public interface PhotoRepository extends CrudRepository<PhotoEntity, Long> {

}
