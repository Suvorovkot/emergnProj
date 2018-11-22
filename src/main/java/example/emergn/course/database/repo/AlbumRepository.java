package example.emergn.course.database.repo;

import example.emergn.course.database.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
    List<Album> findByArtistName(String artistName);
}
