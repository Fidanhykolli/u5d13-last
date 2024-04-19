package fidanhykolli.u5d13last.controllers;

import fidanhykolli.u5d13last.entities.User;
import fidanhykolli.u5d13last.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showUserProfile(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "userProfile";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUserForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
