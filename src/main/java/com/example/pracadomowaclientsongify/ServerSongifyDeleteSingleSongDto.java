package com.example.pracadomowaclientsongify;

import org.springframework.http.HttpStatus;

public record ServerSongifyDeleteSingleSongDto(String message, HttpStatus status) {
}
