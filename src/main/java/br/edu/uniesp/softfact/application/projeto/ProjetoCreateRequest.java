package br.edu.uniesp.softfact.application.projeto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

public record ProjetoCreateRequest (
    @NotBlank String nome,
    String descricao,
    @NotNull Set<Long> alunosIds,
    @NotNull Set<Long> stacksIds
){
}
