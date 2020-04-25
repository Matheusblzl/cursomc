package com.maiconsantos.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.maiconsantos.cursomc.security.UserSS;

//pegar o usuário logado
public class UserService {
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
