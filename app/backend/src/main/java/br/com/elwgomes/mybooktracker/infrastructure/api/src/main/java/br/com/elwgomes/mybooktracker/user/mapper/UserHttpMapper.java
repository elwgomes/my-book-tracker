package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.user.mapper;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserDomain;
import br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.user.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserHttpMapper {
    UserHttpMapper INSTANCE = Mappers.getMapper(UserHttpMapper.class);
    UserDomain toDomain(UserRequest request);
}
