package com.shorturl.urlshortenerapi.dto;


public class ShortUrlDTO {
	
	private String shortUrl;
	

	
	public ShortUrlDTO() {
		super();
	}

	public ShortUrlDTO(String shortUrl) {
		super();
		this.shortUrl = shortUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}
