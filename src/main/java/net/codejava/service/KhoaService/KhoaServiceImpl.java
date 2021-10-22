package net.codejava.service.KhoaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Khoa;
import net.codejava.repositories.KhoaRepository;

@Service
public class KhoaServiceImpl implements KhoaService {
	@Autowired
	private KhoaRepository khoaRepository;
	@Override
	public List<Khoa> getAllKhoa() {
		List<Khoa> listKhoa = khoaRepository.findAll();
		return listKhoa;
	}
}
