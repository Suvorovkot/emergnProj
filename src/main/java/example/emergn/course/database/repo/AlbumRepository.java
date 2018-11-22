package example.emergn.course.database.repo;

import example.emergn.course.database.models.Album;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumRepository extends PagingAndSortingRepository<Album, Integer> {

}
