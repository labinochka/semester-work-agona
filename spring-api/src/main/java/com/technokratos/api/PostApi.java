package com.technokratos.api;

import com.technokratos.dto.request.PostRequest;
import com.technokratos.dto.response.PostResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Posts | Посты", value = "Пост")
@RequestMapping("/api/v1/posts")
public interface PostApi {

    @ApiOperation(value = "Получение поста по id", nickname = "post-get-by-id", response = PostResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пост получен", response = PostResponse.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    PostResponse getById(@PathVariable("post-id") UUID uuid);

    @ApiOperation(value = "Получение всех постов", nickname = "post-get-all", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Посты получены", response = List.class),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PostResponse> getAll();

    @ApiOperation(value = "Создание поста", nickname = "post-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Пост создан", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping("/{author-id}")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody PostRequest postRequest, @PathVariable("author-id") UUID authorUuuid);

    @ApiOperation(value = "Удаление поста по id", nickname = "post-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Пост удален", response = Void.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{post-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("post-id") UUID uuid);

    @ApiOperation(value = "Частичное обновление поста по id", nickname = "post-partial-update-by-id",
            response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пост обновлен", response = UUID.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PatchMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID updatePartial(@PathVariable("post-id") UUID uuid, @RequestBody PostRequest postRequest);
}
