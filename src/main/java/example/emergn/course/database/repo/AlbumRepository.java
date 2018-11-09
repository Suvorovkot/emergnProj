package example.emergn.course.database.repo;

import example.emergn.course.database.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
