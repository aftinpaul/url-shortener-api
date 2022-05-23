package com.shorturl.urlshortenerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shorturl.urlshortenerapi.model.Url;

public interface UrlRepository extends JpaRepository<Url, Long>{
	
    @Query("SELECT u FROM url u WHERE u.longUrl = ?1")
    List<Url> findByLongUrl(String longUrl);

}
