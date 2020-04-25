package com.technocrats.creatingjoy.controller;


import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.entity.Address;
import com.technocrats.creatingjoy.entity.User;
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
@RequestMapping("/register")
public class RegistrationController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;






    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("userDTO", new UserDTO());
        theModel.addAttribute("addressDTO",new AddressDTO());


        return "login_signup";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("userDTO") UserDTO userDTO, @ModelAttribute("addressDTO") AddressDTO addressDTO,
            BindingResult theBindingResult,
            Model theModel) {

        log.info("address is {}",addressDTO);

        String userName = userDTO.getUserName();
        log.info("Processing registration form for: " + userName);


        if (theBindingResult.hasErrors()){
            return "login_signup";
        }


        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("userDTO", new UserDTO());
            theModel.addAttribute("addressDTO",new AddressDTO());
            theModel.addAttribute("registrationError", "User name already exists.");

            log.error("User name already exists.");
            return "login_signup";
        }


        theModel.addAttribute("userDTO",userDTO);
        theModel.addAttribute("addressDTO",addressDTO);
          authService.sendToken(userDTO.getPhoneNumber(),"sms");
        return "otp_page";




    }

@PostMapping("/verifyOTP")

        public String verifyOtp(@ModelAttribute("userDTO") UserDTO userDTO,@ModelAttribute("addressDTO") AddressDTO addressDTO,Model model, HttpServletRequest request) {
            String otp = request.getParameter("OTP");
    String phoneNumber = userDTO.getPhoneNumber();
    log.info("phonenumber:{}",phoneNumber);
    log.info(addressDTO.getCity());
            if(authService.verifyToken(otp,phoneNumber)){
            userDTO.setAddressDTO(addressDTO);
        addressDTO.setUserDTO(userDTO);

                userService.save(userDTO);
                return "registration-confirmation";

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










