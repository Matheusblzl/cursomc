package com.maiconsantos.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.maiconsantos.cursomc.domain.Pedido;


public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
