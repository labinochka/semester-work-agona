package com.technokratos.api;

import com.technokratos.dto.request.UserRequest;
import com.technokratos.dto.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Users | Пользователи", value = "Юзер")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiOperation(value = "Получение юзера по id", nickname = "user-get-by-id", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Юзер получен", response = UserResponse.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getById(@PathVariable("user-id") UUID uuid);

    @ApiOperation(value = "Получение всех юзеров", nickname = "user-get-all", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Юзеры получены", response = List.class),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<UserResponse> getAll();

    @ApiOperation(value = "Создание юзера", nickname = "user-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Юзер создан", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody UserRequest userRequest);

    @ApiOperation(value = "Удаление юзера по id", nickname = "user-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Юзер удален", response = Void.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("user-id") UUID uuid);

    @ApiOperation(value = "Обновление юзера по id", nickname = "user-update-by-id", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Юзер обновлен", response = UUID.class),
            @ApiResponse(code = 400, message = "Не все данные введены"),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PutMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID update(@PathVariable("user-id") UUID uuid, @RequestBody UserRequest userRequest);

    @ApiOperation(value = "Частичное обновление юзера по id", nickname = "user-partial-update-by-id",
            response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Юзер частично обновлен", response = UUID.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PatchMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID updatePartial(@PathVariable("user-id") UUID uuid, @RequestBody UserRequest userRequest);
}
