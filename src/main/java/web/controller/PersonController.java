package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Person;
import web.service.PersonService;

@Controller
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value="/create")
    public String createPerson(ModelMap model) {
        model.addAttribute("person", new Person());
        return "create";
    }

    @GetMapping(value="/persons")
    public String showAllPersons(Model model) {
        model.addAttribute("persons", personService.listPersons());
        return "persons";
    }
    @GetMapping(value="/person/{id}")
    public String showOnePerson(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", personService.getPersonById(id));
        return "person";
    }

    @PostMapping(value="/save")
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/";
    }

    @PostMapping(value="/update")
    public String updatePerson(@ModelAttribute("person") Person person) {
        personService.updatePerson(person);
        return "redirect:/";
    }

    @GetMapping(value="/person/update/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "update";
    }

    @GetMapping(value="/person/delete/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.deletePersonById(id);
        return "redirect:/";
    }

}
