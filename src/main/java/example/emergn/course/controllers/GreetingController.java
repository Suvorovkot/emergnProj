package example.emergn.course.controllers;

import example.emergn.course.database.repo.AlbumRepository;
import example.emergn.course.database.repo.ArtistRepository;
import example.emergn.course.database.models.Album;
import example.emergn.course.database.models.Artist;
import example.emergn.course.database.models.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;

@Controller
public class GreetingController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    ArtistRepository artistRepository;

    @GetMapping("greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Album test = new Album("who built the moon?", 2017, 12, "NGHFB");
        albumRepository.save(test);
        return "greeting";
    }

    @GetMapping("greetingNew")
    public String greetingNew(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Artist test = new Artist("Noel", "Gallagher", "NGHFB", Countries.BRITAIN, new LinkedList<Album>() );
        artistRepository.save(test);
        return "greeting";
    }

    @GetMapping("greeting/lol")
    public String greeting1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "kek");
        return "greeting";
    }

    @GetMapping("developers")
    public String smth(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "kek");
        return "developers";
    }


}