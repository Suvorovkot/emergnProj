package example.emergn.course.controllers;

import example.emergn.course.database.models.Artist;
import example.emergn.course.database.repo.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ArtistsController {

    private ArtistRepository artistRepository;

    public ArtistsController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @PostMapping(value = "/createArtist")
    public String addArtist(@ModelAttribute Artist artist) {
        //TODO тут должно быть сообщение об ошибке
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    @PostMapping(value = "/editArt")
    public String editArt(@ModelAttribute Artist artist,
                          Model model) {
        //TODO тут тоже может вылетать SQL - ошибка
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    //TODO можно попытаться все же получить боди в качестве пост - реквеста, чтобы в базу лишний раз не гонять
    @GetMapping(value = "/editArtist")
    public String editArtistPage(@RequestParam Integer id,
                                 Model model) {
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            model.addAttribute("origin", artist.get());
            return "editArtist";
        }
        //TODO тут должно быть ваше окошко об ошибке (если такого артиста нет)
        return "redirect:/artists";

    }

    @GetMapping(value = "/addArtist")
    public String addArtistPage(Model model) {
        return "addArtist";
    }

    @DeleteMapping(value = "/deleteArtist")
    public String deleteArtist(@RequestParam Integer id,
                               Model model) {
        //TODO если не нашли айдишку (мало ли), выводим ошибку
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

    @GetMapping("artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists";
    }

}
