package com.comp.controllers;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   
import com.comp.beans.GreetingsMain;
import com.comp.dao.GreetDao;

@Controller  
public class GreetController {
    @Autowired
    GreetDao dao;

    @RequestMapping("/greetform")
    public String showform(Model m){  
    	m.addAttribute("command", new GreetingsMain());
    	return "greetform";
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("hi") GreetingsMain hi){
        dao.save(hi);
        return "redirect:/viewhello";
    }  

    @RequestMapping("/viewhello")
    public String viewhello(Model m){
        List<GreetingsMain> list=dao.getGreetings();
        m.addAttribute("list",list);
        return "viewhello";
    }  

    @RequestMapping(value="/editgreeting/{id}")
    public String edit(@PathVariable int id, Model m){  
        GreetingsMain hi=dao.getGreetById(id);
        m.addAttribute("command",hi);
        return "greeteditform";
    }
    @RequestMapping(value="/saveedited",method = RequestMethod.POST)
    public String saveedited(@ModelAttribute("hi") GreetingsMain hi){
        dao.update(hi);
        return "redirect:/viewhello";
    }  

    @RequestMapping(value="/deletehello/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewhello";
    }   
}  