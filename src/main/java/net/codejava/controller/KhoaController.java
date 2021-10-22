package net.codejava.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import net.codejava.exception.ResourceNotFoundException;
import net.codejava.model.Khoa;
import net.codejava.repositories.KhoaRepository;
import net.codejava.service.KhoaService.KhoaService;


@RestController
@RequestMapping("api")
public class KhoaController {
	
	@Autowired
	
	private KhoaService	khoaService;
	
	@GetMapping("/khoa")
	public ResponseEntity<List<Khoa>> getAll(){
		List<Khoa> listkhoa = khoaService.getAllKhoa();
		return new ResponseEntity<List<Khoa>>(listkhoa, HttpStatus.OK);
	}
	/* @RequestMapping(value = "/khoa", 
	            method = RequestMethod.POST,
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody             
	    public Khoa createKhoa(@Valid @RequestBody Khoa khoa) {
	        return khoaRepository.save(khoa);
	    }
	    @DeleteMapping("/Khoa/{KhoaId}")
	    public ResponseEntity<?> deleteKhoa(@PathVariable Long khoaId) {
	        return khoaRepository.findById(khoaId).map(khoa -> {
	        	khoaRepository.delete(khoa);
	            return ResponseEntity.ok().build();
	        }).orElseThrow(() -> new ResourceNotFoundException("KhoaId " + khoaId + " not found"));
	    }*/

}
