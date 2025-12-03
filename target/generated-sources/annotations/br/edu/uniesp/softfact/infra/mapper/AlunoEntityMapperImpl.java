package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.aluno.AlunoResponse;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.shared.enums.Curso;
import br.edu.uniesp.softfact.shared.enums.Periodo;
import br.edu.uniesp.softfact.zo.old.stack.dto.StackResumo;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-02T17:06:56-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class AlunoEntityMapperImpl implements AlunoEntityMapper {

    @Override
    public AlunoEntity toEntity(Aluno dto) {
        if ( dto == null ) {
            return null;
        }

        AlunoEntity alunoEntity = new AlunoEntity();

        return alunoEntity;
    }

    @Override
    public AlunoResponse toResponse(AlunoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String email = null;
        String telefone = null;
        Curso curso = null;
        String matricula = null;
        Periodo periodo = null;
        Set<StackResumo> stacks = null;

        AlunoResponse alunoResponse = new AlunoResponse( id, nome, email, telefone, curso, matricula, periodo, stacks );

        return alunoResponse;
    }
}
