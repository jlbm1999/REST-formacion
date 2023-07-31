package com.mascotas.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mascotas.model.Mascota;


public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long>{

}
