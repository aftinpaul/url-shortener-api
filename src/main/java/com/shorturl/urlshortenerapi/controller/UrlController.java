package com.shorturl.urlshortenerapi.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shorturl.urlshortenerapi.dto.LongUrlDTO;
import com.shorturl.urlshortenerapi.dto.ShortUrlDTO;
import com.shorturl.urlshortenerapi.service.UrlService;
import com.shorturl.urlshortenerapi.utils.UrlUtil;

@RestController
public class UrlController {
	
	Logger logger = LoggerFactory.getLogger(UrlController.class);
	
	@Autowired
	private UrlService service;
	
	
	@PostMapping("getShortUrl")
	public ResponseEntity<Object> getShorUrl(@RequestBody LongUrlDTO longUrl, HttpServletRequest request) {
		logger.info(String.format("Url to be shortened - %s", longUrl.getLongUrl()));
//        if (!UrlUtil.isValidUrl(longUrl.getLongUrl())) {
//            logger.error(String.format("Url provided is malformed - %s",longUrl.getLongUrl()));
//            return ResponseEntity.badRequest().body("Url provided is invalid");
//        }
        String baseUrl = null;

        try {
            baseUrl = UrlUtil.getBaseUrl(request.getRequestURL().toString());
            Enumeration<String> headers= request.getHeaderNames();
            Object obj = request.getAttribute("javax.servlet.forward.request_uri");
            request.getHeader("referer");
        } catch (MalformedURLException e) {
            logger.error("Malformed request url");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request url is invalid", e);
        }

        // Retrieving the Shortened url and concatenating with protocol://domain:port
        ShortUrlDTO shortUrl = service.getShortUrl(longUrl);
        shortUrl.setShortUrl(baseUrl + shortUrl.getShortUrl());
        logger.debug(String.format("Shortened Url for Url %s is %s", longUrl.getLongUrl(), shortUrl.getShortUrl()));
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }
	
    @GetMapping("/{shortenString}")
    public void redirectToFullUrl(HttpServletResponse response, @PathVariable String shortenString) {
        try {
        	logger.info(String.format("Url requested for the short url %s",shortenString));
        	LongUrlDTO fullUrl = service.getFullUrl(shortenString);

            logger.info(String.format("Redirecting to %s", fullUrl.getLongUrl()));

            // Redirects the reponse to the original url
            response.sendRedirect(fullUrl.getLongUrl());
        } catch (NoSuchElementException e) {
            logger.error(String.format("No URL found for %s in the db", shortenString));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not found", e);
        } catch (IOException e) {
            logger.error("Could not redirect to the full url");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not redirect to the full url", e);
        }
    }
	

}
