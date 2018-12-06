package example.emergn.course.database.repo;

import example.emergn.course.database.models.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {
}
