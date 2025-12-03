package br.edu.uniesp.softfact.boundaries.rest.projeto;

import br.edu.uniesp.softfact.application.mappers.ProjetoCreateMapper;
import br.edu.uniesp.softfact.application.mappers.ProjetoUpdateMapper;
import br.edu.uniesp.softfact.application.projeto.ProjetoCreateRequest;
import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.application.projeto.ProjetoUpdateRequest;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.UpdateProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projetos")
@RequiredArgsConstructor
public class ProjetoCommandController {
    private UpdateProjetoService updateProjetoService;
    private ProjetoCreateMapper projetoCreateMapper;
    private ProjetoUpdateMapper projetoUpdateMapper;

    @PostMapping
    public ProjetoResponse criar(@RequestBody @Valid ProjetoCreateRequest request) {
        var dominio = projetoCreateMapper.toDomain(request);
        return updateProjetoService.criar(dominio, request.alunosIds(), request.stacksIds());
    }

    @PutMapping("/{id}")
    public ProjetoResponse atualizar(@PathVariable Long id, @RequestBody @Valid ProjetoUpdateRequest request) {
        var dominio = updateProjetoService.buscarDomainPorId(id);
        projetoUpdateMapper.updateDomainFromRequest(request, (Projeto) dominio);
        return updateProjetoService.atualizar(id, (Projeto) dominio, request.alunosIds(), request.stacksIds());
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        updateProjetoService.excluir(id);
    }
}
