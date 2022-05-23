package com.shorturl.urlshortenerapi.dto;


public class LongUrlDTO {
	
	private String longUrl;

	

	public LongUrlDTO() {
		super();
	}

	public LongUrlDTO(String longUrl) {
		super();
		this.longUrl = longUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	

}
