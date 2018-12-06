package example.emergn.course.database.repo;

import example.emergn.course.database.models.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {
    Page<Artist> findByStageName(String stageName, Pageable var1);
}
