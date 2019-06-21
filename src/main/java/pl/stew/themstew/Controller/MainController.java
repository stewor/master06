package pl.stew.themstew.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.stew.themstew.zwykleklasy.Color;

import java.util.Map;

@Controller
public class MainController {
    Color color;
    @Autowired
    public MainController(Color color){
        this.color=color;
    }

    @GetMapping("/")
    public ModelAndView getMain() {
        ModelAndView m = new ModelAndView();
        m.setViewName("index");
        color.resetM();
        Map<String, String> mm = color.getMyMap();
        String costam = color.getWitaj();
        m.addObject("costam", costam);
        m.addAllObjects(mm);
        return m;
    }

    @GetMapping("/color")
    public ModelAndView getForm(@RequestParam(value = "color") String s) {
        ModelAndView m = new ModelAndView();
        m.addObject("color",s);
        char[] as=s.toCharArray();
        String sn= ""+as[0]+""+as[2]+""+as[4]+""+as[6];
        color.setKol(sn);
        color.spColor();
        Map<String, String> mm = color.getMyMap();
        m.addAllObjects(mm);
        String costam = color.getWitaj();
        m.addObject("costam", costam);
        m.setViewName("index");
        return m;
    }
 }