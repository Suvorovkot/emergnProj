package example.emergn.course.database.repo;

import example.emergn.course.database.models.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
