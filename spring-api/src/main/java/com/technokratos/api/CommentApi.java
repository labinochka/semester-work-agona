package com.technokratos.api;

import com.technokratos.dto.request.CommentRequest;
import com.technokratos.dto.response.CommentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "Comments | Комментарии", value = "Комментарий")
@RequestMapping("/api/v1/comments")
public interface CommentApi {

    @ApiOperation(value = "Получение комментариев по id поста", nickname = "comment-get-by-post-id",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комментарии получены", response = List.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    List<CommentResponse> getByPostId(@PathVariable("post-id") UUID uuid);

    @ApiOperation(value = "Создание комментария", nickname = "comment-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Комментарий создан", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping("/{post-id}/{author-id}")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@PathVariable("post-id") UUID postUuid, @PathVariable("author-id") UUID authorUuid,
                @RequestBody CommentRequest commentRequest);

    @ApiOperation(value = "Удаление комментария по id", nickname = "comment-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Комментарий удален", response = Void.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("comment-id") UUID uuid);

    @ApiOperation(value = "Обновление комментария по id", nickname = "comment-update-by-id", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комментарий обновлен", response = UUID.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PutMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.OK)
    UUID update(@PathVariable("comment-id") UUID uuid, @RequestBody CommentRequest commentRequest);
}
