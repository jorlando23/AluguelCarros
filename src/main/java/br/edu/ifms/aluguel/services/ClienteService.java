package br.edu.ifms.aluguel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.aluguel.dto.ClienteDTO;
import br.edu.ifms.aluguel.entities.Cliente;
import br.edu.ifms.aluguel.repositories.ClienteRepository;
import br.edu.ifms.aluguel.services.exceptions.EntityNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	
	private ClienteRepository repository;
	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll(){
		List<Cliente> list = repository.findAll();
		
		return list.stream().map(t -> new ClienteDTO(t)).collect(Collectors.toList());
	}
	
	@Transactional
	public ClienteDTO findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.orElseThrow(() -> new EntityNotFoundException("A entidade consultada não foi localizada"));
		return new ClienteDTO(entity);
	}
	
	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setEndereco(dto.getEndereco());
		entity = repository.save(entity);
		return new ClienteDTO(entity);
	}
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPage(Object pageRequest) {
		Page<Cliente> list = (Page<Cliente>) repository.findAll((Sort) pageRequest);
		return list.map(x -> new ClienteDTO(x));
	}
}

