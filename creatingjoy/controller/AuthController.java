package com.technocrats.creatingjoy.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AuthController {

   /* List<UserDTO> users = new ArrayList<UserDTO>();

    @GetMapping("/")
    public String login() {
        return "login_signup";
    }

    @GetMapping("/showLogin")
    public String showLogin() {
        return "login_signup";
    }

    @PostMapping("/verifyOTP")
    public String verifyOtp(Model model, HttpServletRequest request) {
        String otp = request.getParameter("OTP");
        if (otp.equals("1234")) {
            return "login_signup";
        } else {
            model.addAttribute("Message", "Invalid OTP!");
            return "otp_page";
        }
    }

    @GetMapping("/sendOTP")
    public String sendOtp(){
        return "otp_page";
    }


    @PostMapping("/validate")
    public String validate(@ModelAttribute(name = "user") UserDTO user, Model model) {


        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUserName().equals(user.getUserName())) {
                if (users.get(i).getPassword().equals(user.getPassword()))
                    return "home";
                else {
                    model.addAttribute("Message", "Wrong Password!!");
                    return "login_signup";
                }


            }
        }
        model.addAttribute("Message", "You are not registered!!");
        return "login_signup";

    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute(name = "user") UserDTO user, Model model) {
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUserName().equals(user.getUserName())) {
                model.addAttribute("Message", "UserName already exists!!");
                return "login_signup";
            }

        }
        users.add(user);

        return "login_signup";
    }


*/



}