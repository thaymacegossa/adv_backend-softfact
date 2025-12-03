package br.edu.uniesp.softfact.domain.projeto;

import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Projeto {

    private Long id;
    private String nome;
    private String descricao;
    private Set<Aluno> alunos = new HashSet<>();
    private Set<StackTecnologia> stacks = new HashSet<>();
}
