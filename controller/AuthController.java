package com.technocrats.creatingjoy.controller;


import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.service.AuthService;
import com.technocrats.creatingjoy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Slf4j
public class AuthController {


    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("userDTO", new UserDTO());
        theModel.addAttribute("addressDTO", new AddressDTO());


        return "login_signup";
    }


    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("user") UserDTO userDTO, @ModelAttribute("address") AddressDTO addressDTO,
            BindingResult theBindingResult,
            Model theModel) {

        log.info("address is {}", addressDTO);

        String userName = userDTO.getUserName();
        log.info("Processing registration form for: " + userName);


        if (theBindingResult.hasErrors()) {
            return "login_signup";
        }


        UserDTO existing = userService.findByUserName(userName);
        if (existing != null) {
            theModel.addAttribute("userDTO", new UserDTO());
            theModel.addAttribute("addressDTO", new AddressDTO());
            theModel.addAttribute("registrationError", "User name already exists.");

            log.error("User name already exists.");
            return "login_signup";
        }
        /*address.setUserDTO(user);
        user.setAddressDTO(address);
        userService.save(user);


        theModel.addAttribute("registrationSuccess", "Registered Successfully.Please log in");
        */
        theModel.addAttribute("userDTO", userDTO);
        theModel.addAttribute("addressDTO", addressDTO);
        authService.sendToken(userDTO.getPhoneNumber(), "sms");

        return "otp_page";
    }

    @PostMapping("/verifyOTP")

    public String verifyOtp(@ModelAttribute("userDTO") UserDTO userDTO, @ModelAttribute("addressDTO") AddressDTO addressDTO, Model model, HttpServletRequest request) {
        String otp = request.getParameter("OTP");
        String phoneNumber = userDTO.getPhoneNumber();
        log.info("phonenumber:{}", phoneNumber);
        log.info(addressDTO.getCity());
        if (authService.verifyToken(otp, phoneNumber)) {
            userDTO.setAddressDTO(addressDTO);
            addressDTO.setUserDTO(userDTO);

            userService.save(userDTO);
            return "login_signup";

                /*log.info("Successfully created user: " + userName);
                log.info("user:"+userDTO);
                log.info("address"+userDTO.getAddressDTO());
                return "registration-confirmation";*/
        } else {
            model.addAttribute("Message", "Invalid OTP!");
            return "otp_page";
        }


    }


}





