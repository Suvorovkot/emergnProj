package example.emergn.course.controllers;

import example.emergn.course.database.models.Album;
import example.emergn.course.database.models.Artist;
import example.emergn.course.database.models.Pager;
import example.emergn.course.database.repo.AlbumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                               @RequestParam("pageSize") Optional<Integer> pageSize,
                               @RequestParam("page") Optional<Integer> page,
                               Model model) {
        // TODO теоретически может не найтись имя, вывести ошибку
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Album> albumsPage = albumRepository.findAll(new PageRequest(evalPage, evalPageSize));
        model.addAttribute("albumsPage", albumsPage);
        // evaluate page size
        model.addAttribute("selectedPageSize", evalPageSize);
        // add page sizes
        model.addAttribute("pageSizes", PAGE_SIZES);
        // add pager
        model.addAttribute("pager", new Pager(albumsPage.getTotalPages(), albumsPage.getNumber(), BUTTONS_TO_SHOW));
        model.addAttribute("albums", albumRepository.findByArtistName(artistName));
        return "albums";
    }

    @GetMapping("/addAlbum")
    public String addAlbumPage(@RequestParam String artistName,
                               Model model) {
        model.addAttribute("artistName", artistName);
        return "addAlbum";
    }

    @PostMapping(value = "/createAlbum")
    public String addAlbum(@ModelAttribute Album album,
                           Model model) {
        albumRepository.save(album);
        return "redirect:/albums?artistName=" + album.getArtistName();

    }

    @PostMapping(value = "/editAlb")
    public String editArt(@ModelAttribute Album album,
                          Model model) {
        //TODO тут тоже может вылетать SQL - ошибка
        albumRepository.save(album);
        return "redirect:/albums?artistName=" + album.getArtistName();
    }

    //TODO можно попытаться все же получить боди в качестве пост - реквеста, чтобы в базу лишний раз не гонять
    @GetMapping(value = "/editAlbum")
    public String editArtistPage(@RequestParam Integer id,
                                 @RequestParam String artistName,
                                 Model model) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            model.addAttribute("origin", album.get());
            return "editAlbum";
        }
        //TODO тут должно быть ваше окошко об ошибке (если такого альбом нет)
        return "redirect:/albums?artistName=" + artistName;

    }

    @GetMapping(value = "/albums/deleteAlbum/{albumId}")
    public String deleteAlbum(@PathVariable("albumId") String albumId) {
        // TODO мало ли тут ошибка выпрыгнет?
        Integer id = Integer.parseInt(albumId);
        albumRepository.deleteById(id);
       return "redirect:/artists";
    }

}

