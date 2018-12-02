package example.emergn.course.controllers;

import example.emergn.course.database.models.Album;
import example.emergn.course.database.repo.AlbumRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class AlbumsController {

    private AlbumRepository albumRepository;
    private Pageable pageable;

    public AlbumsController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping(value = "/albums")
    public String albumsByName(@RequestParam String artistName,
                               Model model) {
        // TODO теоретически может не найтись имя, вывести ошибку
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

    @DeleteMapping(value = "/deleteAlbum")
    public String deleteAlbum(@RequestParam Integer id,
                              @RequestParam String artistName,
                              Model model) {
        // TODO мало ли тут ошибка выпрыгнет?
        albumRepository.deleteById(id);
        return "redirect:/albums?artistName=" + artistName;
    }

//    @GetMapping(value = "/setPage")
//    public String setPage(@RequestParam String artistName,
//                          @RequestParam Integer pagenum,
//                          Model model) {
//        pageable = PageRequest.of(pagenum, 5);
//        model.addAttribute("albums", albumRepository.findByArtistName(artistName));
//        return "albums";
//    }
//
//    @GetMapping(value = "/nextPage")
//    public String nextPage(@RequestParam String artistName,
//                           Model model) {
//        pageable = albumRepository.findAll(pageable).nextPageable();
//        model.addAttribute("albums", albumRepository.findAll(pageable));
//        return "albums";
//    }
//
//    @GetMapping(value = "/previousPage")
//    public String previousPage(@RequestParam String artistName,
//                               Model model) {
//        pageable = albumRepository.findAll(pageable).previousPageable();
//        model.addAttribute("albums", albumRepository.findAll(pageable));
//        return "albums";
//    }
}

