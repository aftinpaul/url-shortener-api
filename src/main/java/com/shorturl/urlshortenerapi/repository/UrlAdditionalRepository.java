package com.shorturl.urlshortenerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shorturl.urlshortenerapi.model.UrlAdditional;

public interface UrlAdditionalRepository extends JpaRepository<UrlAdditional, Long> {

}
