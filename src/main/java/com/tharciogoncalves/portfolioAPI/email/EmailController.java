package com.tharciogoncalves.portfolioAPI.email;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailDTO email, HttpServletRequest request){
        try{
            this.emailService.sendEmail(email);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("erro: "+e);
        }

        var response = new EmailResponse(email.name(), email.emailFrom(), email.message(),
                "Mensagem enviada com sucesso!");
        return ResponseEntity.ok().body(response);
    }
}
