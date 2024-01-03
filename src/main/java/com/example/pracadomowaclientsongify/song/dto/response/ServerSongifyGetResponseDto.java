package com.example.pracadomowaclientsongify.song.dto.response;

import com.example.pracadomowaclientsongify.song.Song;

import java.util.Map;

public record ServerSongifyGetResponseDto(Map<Integer, Song> songs) {
}
