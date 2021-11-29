package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import web.model.Car;

import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String showAllCars(@RequestParam(value="count", required = false) Integer count, ModelMap model) {
        CarService CService = new CarService();
        CService.setSameCars();
        List<Car> listCars = (count != null) ? CService.getNeedCountCars(count) : CService.getNeedCountCars(5);
        model.addAttribute("cars", listCars);
        return "car";
    }

}