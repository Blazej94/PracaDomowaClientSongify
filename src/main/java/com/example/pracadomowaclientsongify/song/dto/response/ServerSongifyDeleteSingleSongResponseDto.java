package com.example.pracadomowaclientsongify.song.dto.response;

import org.springframework.http.HttpStatus;

public record ServerSongifyDeleteSingleSongResponseDto(String message, HttpStatus status) {
}
