package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String getUsersTable(Model model) {
        model.addAttribute("userList", service.getAllUser());
        return "main";
    }

    @RequestMapping(value = "main", method = RequestMethod.POST)
    public String addUser(User user) {
        service.addUser(user);
        return "redirect:/main";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteUser(User user) {
        service.deleteUser(user.getId());
        return "redirect:/main";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String getUpdatePage(ModelMap model, User user) {
        model.addAttribute("id", user.getId())
                .addAttribute("name", user.getName())
                .addAttribute("surName", user.getSurName());
        return "update-user";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateUser(User user) {
        service.updateUser(user.getId(), user.getName(), user.getSurName());
        return "redirect:/main";
    }
}


