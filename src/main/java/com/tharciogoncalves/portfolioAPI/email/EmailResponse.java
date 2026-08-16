package com.tharciogoncalves.portfolioAPI.email;

import jakarta.validation.constraints.Email;

public record EmailResponse(String name ,@Email String emailFrom, String emailSendedMessage, String message) {
}
