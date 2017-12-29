package com.landing;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by pipe on 12/29/17.
 */
public interface EmailService {
    void sendSimpleMessage(String[] to, String subject, String text);
    void sendSimpleMessageUsingTemplate(String[] to, String subject, SimpleMailMessage template, String... templateArgs);
}
