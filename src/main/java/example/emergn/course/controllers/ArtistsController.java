package example.emergn.course.controllers;

import example.emergn.course.database.models.Artist;
import example.emergn.course.database.repo.ArtistRepository;
import example.emergn.course.view.Pager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    @PostMapping(value = "/editArt")
    public String editArt(@ModelAttribute Artist artist) {
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    @GetMapping(value = "/editArtist")
    public String editArtistPage(@RequestParam Integer id,
                                 Model model) {
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            model.addAttribute("origin", artist.get());
            return "editArtist";
        }
        return "redirect:/artists";

    }

    @GetMapping(value = "/addArtist")
    public String addArtistPage() {
        return "addArtist";
    }

    @GetMapping(value = "/deleteArtist")
    public String deleteArtist(@RequestParam Integer id) {
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

    @GetMapping("artists")
    public String getArtists(Model model,
                             @RequestParam Optional<String> stageName,
                             @RequestParam Optional<Integer> pageSize,
                             @RequestParam Optional<Integer> page,
                             @RequestParam Optional<String> sortBy) {
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Artist> artistsPage;

        if (sortBy.isPresent()) {
            artistsPage = pageFormerWithSorting(stageName, sortBy.get(), evalPage, evalPageSize);
            model.addAttribute("sortBy", sortBy.get());
        } else {
            artistsPage = pageFormerWithoutSorting(stageName, evalPage, evalPageSize);
        }

        stageName.ifPresent((name) -> model.addAttribute("stageName", name));
        model.addAttribute("artistsPage", artistsPage);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", new Pager(artistsPage.getTotalPages(), artistsPage.getNumber(), BUTTONS_TO_SHOW));

        return "artists";
    }

    private Page<Artist> pageFormerWithSorting(Optional<String> stageName, String sortBy, Integer evalPage, Integer evalPageSize) {
        Page<Artist> artistsPage;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, sortBy));
        if (stageName.isPresent()) {
            artistsPage = artistRepository.findByStageName(stageName.get(), new PageRequest(evalPage, evalPageSize, sort));
        } else {
            artistsPage = artistRepository.findAll(new PageRequest(evalPage, evalPageSize, sort));
        }
        return artistsPage;
    }

    private Page<Artist> pageFormerWithoutSorting(Optional<String> stageName, Integer evalPage, Integer evalPageSize) {
        Page<Artist> artistsPage;
        if (stageName.isPresent()) {
            artistsPage = artistRepository.findByStageName(stageName.get(), new PageRequest(evalPage, evalPageSize));
        } else {
            artistsPage = artistRepository.findAll(new PageRequest(evalPage, evalPageSize));
        }
        return artistsPage;
    }

}
