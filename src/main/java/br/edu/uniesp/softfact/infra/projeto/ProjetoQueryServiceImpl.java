package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.ProjetoQueryService;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import br.edu.uniesp.softfact.zo.old.stack.dto.StackResumo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjetoQueryServiceImpl implements ProjetoQueryService {

    private final ProjetoRepository repo;

    @Override
    @Transactional(readOnly = true)
    public ProjetoResponse buscarPorId(Long id) {
        ProjetoEntity projeto = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado: " + id));

        return toResponse(projeto);
    }

    @Override
    public Page<ProjetoResponse> listar(String termo, Pageable pageable) {
        return null;
    }

    @Transactional(readOnly = true)
    public Page<ProjetoResponse> listar(Pageable pageable) {
        return repo.findAll(pageable).map(this::toResponse);
    }

    private ProjetoResponse toResponse(ProjetoEntity p) {
        return new ProjetoResponse(
                p.getId(),
                p.getNome(),
                p.getDescricao(),

                p.getAlunos().stream()
                        .map(this::toAlunoResponse)
                        .collect(Collectors.toSet()),

                p.getStacks().stream()
                        .map(this::toStackResumo)
                        .collect(Collectors.toSet())
        );
    }

    private AlunoResponse toAlunoResponse(AlunoEntity a) {
        return new AlunoResponse(
                a.getId(),
                a.getNome(),
                a.getEmail(),
                a.getTelefone(),
                a.getCurso(),
                a.getMatricula(),
                a.getPeriodo(),
                a.getStacks() == null ? Set.of() :
                        a.getStacks().stream()
                                .map(StackTecnologia::getId)
                                .collect(Collectors.toSet())
        );
    }


    private StackResumo toStackResumo(StackTecnologia s) {
        return new StackResumo(
                s.getId(),
                s.getNome(),
                s.getCategoria()
        );
    }
}
