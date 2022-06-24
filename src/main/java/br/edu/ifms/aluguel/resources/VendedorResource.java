package br.edu.ifms.aluguel.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.aluguel.dto.VendedorDTO;
import br.edu.ifms.aluguel.services.VendedorService;

@RestController
@RequestMapping(value ="/setor")
public class VendedorResource {
	@Autowired
	private VendedorService service;
	
	@GetMapping
	public ResponseEntity<Page<VendedorDTO>> findAllPaged(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , orderBy);
		
		
		Page<VendedorDTO> list = service.findAllPage(pageRequest);	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VendedorDTO> findById(@PathVariable Long id){
	VendedorDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<VendedorDTO> insert(@RequestBody VendedorDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.ok().body(dto);
	}
}
