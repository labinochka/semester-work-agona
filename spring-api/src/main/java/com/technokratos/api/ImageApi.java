package com.technokratos.api;

import com.technokratos.dto.request.ImageRequest;
import com.technokratos.dto.response.ImageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(tags = "Images | Изображения", value = "Изображения")
@RequestMapping("/api/v1/images")
public interface ImageApi {

    @ApiOperation(value = "Получение изображениия по id поста", nickname = "image-get-by-post-id",
            response = ImageResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Изображение получено", response = ImageResponse.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    ImageResponse getByPostId(@PathVariable("post-id") UUID uuid);

    @ApiOperation(value = "Создание изображения", nickname = "image-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Изображение создано", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping("/{post-id}")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@PathVariable("post-id") UUID postUuid, @RequestBody ImageRequest imageRequest);

    @ApiOperation(value = "Удаление изображения по id", nickname = "image-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Изображение удалено", response = Void.class),
            @ApiResponse(code = 404, message = "Не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{image-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("image-id") UUID uuid);
}
