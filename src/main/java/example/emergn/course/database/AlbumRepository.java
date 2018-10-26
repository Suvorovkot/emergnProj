package example.emergn.course.database;

import example.emergn.course.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
