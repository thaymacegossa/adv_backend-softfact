package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.UpdateProjetoService;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.infra.aluno.AlunoRepository;
import br.edu.uniesp.softfact.infra.mapper.ProjetoEntityMapper;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateProjetoServiceImpl implements UpdateProjetoService {

    private final ProjetoRepository repo;
    private final AlunoRepository alunoRepo;
    private final StackTecRepository stackRepo;
    private final ProjetoEntityMapper mapper;


    @Override
    public ProjetoResponse criar(Projeto domain, Set<Long> alunosId, Set<Long> stacksId) {

        ProjetoEntity entity = mapper.toEntity(domain);

        entity.setAlunos(buscarAlunos(alunosId));
        entity.setStacks(buscarStacks(stacksId));

        entity = repo.save(entity);

        return mapper.toResponse(entity);
    }

    @Override
    public ProjetoResponse atualizar(Long id, Projeto domain, Set<Long> alunosId, Set<Long> stacksId) {

        ProjetoEntity existente = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado: " + id));

        existente.setNome(domain.getNome());
        existente.setDescricao(domain.getDescricao());
        existente.setAlunos(new HashSet<>(buscarAlunos(alunosId)));
        existente.setStacks(new HashSet<>(buscarStacks(stacksId)));

        return mapper.toResponse(existente);
    }


    @Override
    public Projeto buscarDomainPorId(Long id) {
        ProjetoEntity entity = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado: " + id));

        return mapper.toDomain(entity);
    }


    @Override
    public ProjetoResponse criar(Projeto dto) {
        throw new UnsupportedOperationException(
                "Este método não deve ser usado. Utilize criar(domain, alunosId, stacksId)."
        );
    }

    @Override
    public ProjetoResponse atualizar(Long id, Projeto dto) {
        throw new UnsupportedOperationException(
                "Este método não deve ser usado. Utilize atualizar(id, domain, alunosId, stacksId)."
        );
    }


    @Override
    public void excluir(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Projeto não encontrado. Id: " + id);
        }
        repo.deleteById(id);
    }


    private Set<AlunoEntity> buscarAlunos(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Set.of();
        return ids.stream()
                .map(id -> alunoRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado. Id: " + id)))
                .collect(Collectors.toSet());
    }

    private Set<StackTecnologia> buscarStacks(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Set.of();
        return ids.stream()
                .map(id -> stackRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Stack não encontrada. Id: " + id)))
                .collect(Collectors.toSet());
    }
}
