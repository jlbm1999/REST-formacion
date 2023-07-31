package com.mascotas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mascotas.data.MascotaRepository;
import com.mascotas.model.Mascota;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

	@Autowired
	MascotaRepository mascotaRepo;
	
	@ModelAttribute(name="mascota")
	public Mascota mascota() {
		return new Mascota();
	}
	
	/*
	@GetMapping
	public String showMascotaForm(Model model) {
		
	}*/
	
}
