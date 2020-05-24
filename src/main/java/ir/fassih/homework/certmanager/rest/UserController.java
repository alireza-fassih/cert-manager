package ir.fassih.homework.certmanager.rest;


import ir.fassih.homework.certmanager.entities.UserEntity;
import ir.fassih.homework.certmanager.manager.UserManager;
import ir.fassih.homework.certmanager.rest.mapper.UserDtoMapper;
import ir.fassih.homework.certmanager.rest.model.ActionResult;
import ir.fassih.homework.certmanager.rest.model.user.UserListDto;
import ir.fassih.homework.certmanager.rest.model.user.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserController {


    private final UserManager userManager;


    @PostMapping
    public ActionResult<String> save(@RequestBody UserSaveDto dto) {
        UserEntity userEntity = UserDtoMapper.INSTANCE.userSaveDtoToUserEntity(dto);
        userManager.save(userEntity);
        return new ActionResult<>("success");
    }

    @GetMapping("/search")
    public List<UserListDto> search() {
        return userManager.search()
                .stream().map(UserDtoMapper.INSTANCE::userToUserListDto)
                .collect(Collectors.toList());
    }

}
