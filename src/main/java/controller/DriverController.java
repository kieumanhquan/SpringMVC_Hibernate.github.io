package controller;

import entity.Driver;
import service.DriverService;
import service.DriverServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class DriverController {

    private final DriverService driverService = new DriverServiceImpl();

    @RequestMapping(value = "/list-drivers", method = RequestMethod.GET)
    public String showDrivers(ModelMap model) {
        model.put("drivers", driverService.getAll());
        return "driver-list";
    }

    @RequestMapping(value = "/add-driver", method = RequestMethod.GET)
    public String showAddDriverPage(ModelMap model) {
        model.addAttribute("driver", new Driver());
        return "driver-form";
    }

    @RequestMapping(value = "/delete-driver", method = RequestMethod.GET)
    public String deleteDriver(@RequestParam int id) {
        driverService.delete(id);
        return "redirect:/list-drivers";
    }

    @RequestMapping(value = "/update-driver", method = RequestMethod.GET)
    public String showUpdateDriverPage(@RequestParam int id, ModelMap model) {
        Driver driver = driverService.findById(id);
        model.put("driver", driver);
        return "driver-form";
    }

    @RequestMapping(value = "/update-driver", method = RequestMethod.POST)
    public String updateDriver(@Valid Driver driver) {
        driverService.update(driver);
        return "redirect:/list-drivers";
    }

    @RequestMapping(value = "/add-driver", method = RequestMethod.POST)
    public String addDriver(@Valid Driver driver) {
        driverService.add(driver);
        return "redirect:/list-drivers";
    }
}