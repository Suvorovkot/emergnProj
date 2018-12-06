package example.emergn.course.controllers;

import example.emergn.course.database.models.Album;
import example.emergn.course.database.repo.AlbumRepository;
import example.emergn.course.view.Pager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class AlbumsController {

    private AlbumRepository albumRepository;
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10};


    public AlbumsController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping(value = "/albums")
    public String albumsByName(@RequestParam String artistName,
                               @RequestParam Optional<Integer> pageSize,
                               @RequestParam Optional<Integer> page,
                               Model model) {
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Album> albumsPage = albumRepository.findByArtistName(artistName, new PageRequest(evalPage, evalPageSize));
        model.addAttribute("artistName", artistName);
        model.addAttribute("albumsPage", albumsPage);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", new Pager(albumsPage.getTotalPages(), albumsPage.getNumber(), BUTTONS_TO_SHOW));
        return "albums";
    }

    @GetMapping("/addAlbum")
    public String addAlbumPage(@RequestParam String artistName,
                               Model model) {
        model.addAttribute("artistName", artistName);
        return "addAlbum";
    }

    @PostMapping(value = "/createAlbum")
    public String addAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return "redirect:/albums?artistName=" + album.getArtistName();

    }

    @PostMapping(value = "/editAlb")
    public String editArt(@ModelAttribute Album album) {
        albumRepository.save(album);
        return "redirect:/albums?artistName=" + album.getArtistName();
    }


    @GetMapping(value = "/editAlbum")
    public String editArtistPage(@RequestParam Integer id,
                                 @RequestParam String artistName,
                                 Model model) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            model.addAttribute("origin", album.get());
            return "editAlbum";
        }
        return "redirect:/albums?artistName=" + artistName;

    }

    @GetMapping(value = "/deleteAlbum")
    public String deleteAlbum(@RequestParam Integer albumId,
                              @RequestParam String artistName) {
        albumRepository.deleteById(albumId);
        return "redirect:/albums?artistName=" + artistName;
    }

}

