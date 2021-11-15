package codegym.controller;

import codegym.service.LibraryService;
import codegym.service.impl.LibraryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    LibraryService libraryService = new LibraryServiceImpl();
    @GetMapping ("")
    public String display(){
        return "Dictionary";
    }
    @PostMapping("traCuu")
    public String translate(@RequestParam String english, Model model){
        String vietNam = libraryService.find(english);
        model.addAttribute("vietNam", vietNam);
        return "Dictionary";
    }
}
