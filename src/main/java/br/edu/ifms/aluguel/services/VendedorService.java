package br.edu.ifms.aluguel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.aluguel.dto.VendedorDTO;
import br.edu.ifms.aluguel.dto.ClienteDTO;
import br.edu.ifms.aluguel.entities.Vendedor;
import br.edu.ifms.aluguel.entities.Cliente;
import br.edu.ifms.aluguel.repositories.VendedorRepository;
import br.edu.ifms.aluguel.repositories.ClienteRepository;
import br.edu.ifms.aluguel.services.exceptions.EntityNotFoundException;

@Service
public class VendedorService {
	
	@Autowired
	
	private VendedorRepository repository;
	@Transactional(readOnly = true)
	public List<VendedorDTO> findAll(){
		List<Vendedor> list = repository.findAll();

		return list.stream().map(s -> new VendedorDTO(s)).collect(Collectors.toList());
	}
	
	@Transactional
	public VendedorDTO findById(Long id) {
		Optional<Vendedor> obj = repository.findById(id);
		Vendedor entity = obj.orElseThrow(() -> new EntityNotFoundException("A entidade consultada não foi localizada"));
		return new VendedorDTO(entity);
	}
	
	@Transactional
	public VendedorDTO insert(VendedorDTO dto) {
		Vendedor entity = new Vendedor();
		entity.setNome(dto.getNome());
		entity.setCodigo(dto.getCodigo());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity = repository.save(entity);
		return new VendedorDTO(entity);
	}
	@Transactional(readOnly = true)
	public Page<VendedorDTO> findAllPage(PageRequest pageRequest) {
		Page<Vendedor> list = repository.findAll(pageRequest);
		return list.map(x -> new VendedorDTO(x));
	}
}

