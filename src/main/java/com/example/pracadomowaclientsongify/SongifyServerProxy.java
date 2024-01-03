package com.example.pracadomowaclientsongify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "sample-server-songify-client")
public interface SongifyServerProxy {

    @GetMapping
    ServerSongifyGetResponseDto fetchAllSongs();

    @GetMapping
    ServerSongifyGetResponseDto fetchLimitedSongs(@RequestParam Integer limit);
    @GetMapping("/{id}")
    ServerSongifyGetSingleSongDto fetchSingleSong(@PathVariable Integer id);

    @PostMapping
    ServerSongifyPostResponseDto addSong(@RequestBody SongifyPostRequestDto request);

    @PutMapping("/{id}")
    ServerSongifyPutResponseDto updateEntireSong(@PathVariable Integer id, @RequestBody SongifyPutRequestDto request);

    @PatchMapping("/{id}")
    ServerSongifyPatchResponseDto partiallyUpdateSong(@PathVariable Integer id, @RequestBody SongifyPatchRequestDto request);

    @DeleteMapping("/{id}")
    ServerSongifyDeleteSingleSongDto deleteSingleSong(@PathVariable Integer id);


}
