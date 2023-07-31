package com.mascotas.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mascotas.data.MascotaRepository;
import com.mascotas.model.Mascota;

@RestController
@RequestMapping(path="/rest/mascotas", produces="application/json")
@CrossOrigin(origins="*")
public class MascotaControllerApi {
	
	@Autowired
	MascotaRepository mascotaRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<Mascota> MascotaById(@PathVariable("id") Long id) {
		
		Optional<Mascota> optMascota = mascotaRepo.findById(id);
		
		if (optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK); // 200
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // 201
	public void postMascota(@RequestBody Mascota mascota) {
		mascotaRepo.save(mascota);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void removeMascota(@PathVariable("id") Long id){
		mascotaRepo.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Mascota updateMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}
	
	@GetMapping
	public Iterable<Mascota> allMascotas(){
		return mascotaRepo.findAll();
	}
	
	@GetMapping("/races")
	public Iterable<Mascota> findMascotasByRace(){
		return mascotaRepo.findAll(Sort.by("race"));
		
	}
	
	@GetMapping("/ages")
	public Iterable<Mascota> findMascotasByAge(){
		return mascotaRepo.findAll(Sort.by("birthDate").ascending());
	}

}
