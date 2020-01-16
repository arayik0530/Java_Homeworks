package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.models.CommentEntity;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
