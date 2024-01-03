package com.example.pracadomowaclientsongify;

import java.util.Map;

public record ServerSongifyGetResponseDto(Map<Integer, Song> songs) {
}
