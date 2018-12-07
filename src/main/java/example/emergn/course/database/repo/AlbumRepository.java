package example.emergn.course.database.repo;

import example.emergn.course.database.models.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends PagingAndSortingRepository<Album, Integer> {
    Page<Album> findByArtistName(String artistName, Pageable var1);
}
