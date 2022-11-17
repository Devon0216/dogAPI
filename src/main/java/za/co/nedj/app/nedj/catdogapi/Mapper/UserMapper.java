package za.co.nedj.app.nedj.catdogapi.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.nedj.app.nedj.catdogapi.model.User;
import za.co.nedj.app.nedj.catdogapi.model.UserDTO;

@Mapper
public interface UserMapper {
    UserDTO getModelFromEntity(User user);

    User getEntityFromModel(UserDTO userDTO);
}
