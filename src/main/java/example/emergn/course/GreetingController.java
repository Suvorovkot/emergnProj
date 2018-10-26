package example.emergn.course;

import example.emergn.course.database.AlbumRepository;
import example.emergn.course.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Album test = new Album("who built the moon?", 2017, 12, 1);
        albumRepository.save(test);
        return "greeting";
    }

    @GetMapping("greeting/lol")
    public String greeting1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "kek");
        return "greeting";
    }


}