package com.example.pracadomowaclientsongify;

import com.example.pracadomowaclientsongify.song.dto.request.SongifyPatchRequestDto;
import com.example.pracadomowaclientsongify.song.dto.request.SongifyPostRequestDto;
import com.example.pracadomowaclientsongify.song.dto.request.SongifyPutRequestDto;
import com.example.pracadomowaclientsongify.song.SongifyServerProxy;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class PracaDomowaClientSongifyApplication {

    @Autowired
    SongifyServerProxy songifyServerClient;

    public static void main(String[] args) {
        SpringApplication.run(PracaDomowaClientSongifyApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {
            log.info(songifyServerClient.fetchAllSongs());
            log.info(songifyServerClient.fetchLimitedSongs(3));
            log.info(songifyServerClient.fetchSingleSong(3));
            log.info(songifyServerClient.addSong(new SongifyPostRequestDto("I love U", "Janusz")));
            log.info(songifyServerClient.fetchAllSongs());
            log.info(songifyServerClient.deleteSingleSong(5));
            log.info(songifyServerClient.updateEntireSong(1, new SongifyPutRequestDto("New song name", "Janusz")));
            log.info(songifyServerClient.partiallyUpdateSong(1, new SongifyPatchRequestDto("Tralalala", "Bonk")));
            log.info(songifyServerClient.fetchAllSongs());
        } catch (FeignException.FeignClientException feignException) {
            log.error("client exception: " + feignException.getMessage());
        } catch (FeignException.FeignServerException feignException) {
            System.out.println("server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            System.out.println("retryable exception " + retryableException.getMessage());
        } catch (FeignException feignException) {
            System.out.println(feignException.getMessage());
            System.out.println(feignException.status());
        }
    }
}
