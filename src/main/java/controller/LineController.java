package controller;

import entity.Line;
import service.LineService;
import service.LineServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LineController {
    private final LineService lineService = new LineServiceImpl();

    @RequestMapping(value = "/list-lines", method = RequestMethod.GET)
    public String showLines(ModelMap model) {
        model.put("lines", lineService.getAll());
        return "line-list";
    }

    @RequestMapping(value = "/add-line", method = RequestMethod.GET)
    public String showAddLinePage(ModelMap model) {
        model.addAttribute("line", new Line());
        return "line-form";
    }

    @RequestMapping(value = "/delete-line", method = RequestMethod.GET)
    public String deleteLine(@RequestParam int id) {
        lineService.delete(id);
        return "redirect:/list-lines";
    }

    @RequestMapping(value = "/update-line", method = RequestMethod.GET)
    public String showUpdateLinePage(@RequestParam int id, ModelMap model) {
        Line line = lineService.findById(id);
        model.put("line", line);
        return "line-form";
    }

    @RequestMapping(value = "/update-line", method = RequestMethod.POST)
    public String updateLine(@Valid Line line) {
        lineService.update(line);
        return "redirect:/list-lines";
    }

    @RequestMapping(value = "/add-line", method = RequestMethod.POST)
    public String addLine(@Valid Line line) {
        lineService.add(line);
        return "redirect:/list-lines";
    }
}