package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.aluno.AlunoCreateRequest;
import br.edu.uniesp.softfact.domain.aluno.Aluno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-03T16:15:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class AlunoCreateMapperImpl implements AlunoCreateMapper {

    @Override
    public Aluno toDomain(AlunoCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        return aluno;
    }
}
