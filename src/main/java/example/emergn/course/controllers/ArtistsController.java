package example.emergn.course.controllers;

import example.emergn.course.database.models.Artist;
import example.emergn.course.view.Pager;
import example.emergn.course.database.repo.ArtistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ArtistsController {

    private ArtistRepository artistRepository;
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10};

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
    public String editArt(@ModelAttribute Artist artist) {
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
    public String addArtistPage() {
        return "addArtist";
    }

    @GetMapping(value = "/deleteArtist")
    public String deleteArtist(@RequestParam Integer id) {
        //TODO если не нашли айдишку (мало ли), выводим ошибку
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

    @GetMapping("artists")
    public String getArtists(Model model,
                             @RequestParam("pageSize") Optional<Integer> pageSize,
                             @RequestParam("page") Optional<Integer> page) {
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Artist> artistsPage = artistRepository.findAll(new PageRequest(evalPage, evalPageSize));


        model.addAttribute("artistsPage", artistsPage);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", new Pager(artistsPage.getTotalPages(), artistsPage.getNumber(), BUTTONS_TO_SHOW));

        return "artists";
    }

}
