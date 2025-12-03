package br.edu.uniesp.softfact.domain.projeto;

import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
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
