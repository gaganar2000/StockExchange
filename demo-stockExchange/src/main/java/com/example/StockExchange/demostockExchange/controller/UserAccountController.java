package com.example.StockExchange.demostockExchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.StockExchange.demostockExchange.entity.ConfirmationToken;
import com.example.StockExchange.demostockExchange.entity.Users;
import com.example.StockExchange.demostockExchange.repository.ConfirmationTokenRepository;
import com.example.StockExchange.demostockExchange.repository.EmailService;
import com.example.StockExchange.demostockExchange.repository.Userrepository;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    private Userrepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

//    @RequestMapping(value="/register", method = RequestMethod.GET)
//    public ModelAndView displayRegistration(ModelAndView modelAndView, User userEntity)
//    {
//        modelAndView.addObject("userEntity", userEntity);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
    
    @GetMapping("/getAdmin/{email}")
    public Users getAdmin(@PathVariable String email)
    {
    	return userRepository.findByEmailIdIgnoreCase(email);
    }
    
    
//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    @ResponseBody
    @PostMapping("/register")
    @ResponseBody
    public String registerUser(@RequestBody Users userEntity)
    {

    	Users existingUser = userRepository.findByEmailIdIgnoreCase(userEntity.getEmail());
        if(existingUser != null)
        {
            return "This email already exists";
        }
        
        else
        {
            userRepository.save(userEntity);

            ConfirmationToken confirmationToken = new ConfirmationToken(userEntity);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userEntity.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("gaganarajashekar2000@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8082/user/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);


        }
        String ret = "Successful registration. Verification ID sent to "+userEntity.getEmail();
        return ret;
    }
    
   

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
        	Users user = userRepository.findByEmailIdIgnoreCase(token.getUser().getEmail());
            user.setConfirmed(true);
            userRepository.save(user);
            return "Account verified";
        }
        else
        {
            return "Error in verification";
        }
    }
}