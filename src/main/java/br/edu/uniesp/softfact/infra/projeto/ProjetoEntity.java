package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_softfact_projeto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    private String descricao;


    @ManyToMany
    @JoinTable(
            name = "tb_softfact_projeto_aluno",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<AlunoEntity> alunos = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "tb_softfact_projeto_stack",
            joinColumns = @JoinColumn(name = "projeto_id"),
            inverseJoinColumns = @JoinColumn(name = "stack_id")
    )
    private Set<StackTecnologia> stacks = new HashSet<>();
}
