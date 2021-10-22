package net.codejava.service.KhoaService;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.codejava.model.Khoa;

@Component
@Service
public interface KhoaService {
	public List<Khoa> getAllKhoa();
}
