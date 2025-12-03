package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.UpdateProjetoService;
import br.edu.uniesp.softfact.infra.aluno.AlunoRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateProjetoServiceImpl implements UpdateProjetoService {

    private final ProjetoRepository repo;
    private final AlunoRepository alunoRepo;
    private final StackTecRepository stackRepo;
}
