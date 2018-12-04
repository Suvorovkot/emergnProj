package example.emergn.course;

import example.emergn.course.controllers.ArtistsController;
import example.emergn.course.database.models.Artist;
import example.emergn.course.database.models.Countries;
import example.emergn.course.database.repo.ArtistRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ArtistsControllerTest {
    private ArtistRepository artistRepository;
    private ArtistsController artistsController;
    private Model model;
    private Artist artist;
    @Before
    public void setMock() {
        model = mock(Model.class);
        artistRepository = mock(ArtistRepository.class);
        artistsController = new ArtistsController(artistRepository);
        configureArtist();
    }

    private void configureArtist() {
        this.artist = new Artist();
        artist.setId(5);
        artist.setCountry(Countries.RUSSIA);
        artist.setStageName("BerliOS");
        artist.setFirstName("Mishka");
        artist.setLastName("Gabrielyan");
    }


    @Test
    public void addArtistTest() {
        String result = artistsController.addArtist(artist);
        verify(artistRepository).save(artist);
        assertEquals("redirect:/artists", result);
    }

    @Test
    public void editArtistPageWithCorrectIdTest() {
        Integer id = 5;
        when(artistRepository.findById(id)).thenReturn(Optional.of(artist));
        String res = artistsController.editArtistPage(id, model);

        verify(model, times(1)).addAttribute("origin", artist);
        assertEquals("editArtist", res);
    }

    @Test
    public void editArtistPageWithIncorrectIdTest() {
        Integer id = 1;
        when(artistRepository.findById(id)).thenReturn(Optional.empty());
        String res = artistsController.editArtistPage(id, model);

        verify(model, never()).addAttribute("origin", artist);
        assertEquals("redirect:/artists", res);
    }
}
