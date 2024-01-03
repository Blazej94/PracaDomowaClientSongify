package com.example.pracadomowaclientsongify.song;

import com.example.pracadomowaclientsongify.song.dto.request.SongifyPatchRequestDto;
import com.example.pracadomowaclientsongify.song.dto.request.SongifyPostRequestDto;
import com.example.pracadomowaclientsongify.song.dto.request.SongifyPutRequestDto;
import com.example.pracadomowaclientsongify.song.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "sample-server-songify-client")
public interface SongifyServerProxy {

    @GetMapping
    ServerSongifyGetResponseDto fetchAllSongs();

    @GetMapping
    ServerSongifyGetResponseDto fetchLimitedSongs(@RequestParam Integer limit);

    @GetMapping("/{id}")
    ServerSongifyGetSingleSongResponseDto fetchSingleSong(@PathVariable Integer id);

    @PostMapping
    ServerSongifyPostResponseDto addSong(@RequestBody SongifyPostRequestDto request);

    @PutMapping("/{id}")
    ServerSongifyPutResponseDto updateEntireSong(@PathVariable Integer id, @RequestBody SongifyPutRequestDto request);

    @PatchMapping("/{id}")
    ServerSongifyPatchResponseDto partiallyUpdateSong(@PathVariable Integer id, @RequestBody SongifyPatchRequestDto request);

    @DeleteMapping("/{id}")
    ServerSongifyDeleteSingleSongResponseDto deleteSingleSong(@PathVariable Integer id);
}
