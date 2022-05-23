package com.shorturl.urlshortenerapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "url")
@Table(name="url_details")
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="url_id")
	private long id;

	@Column(name="long_url")
	private String longUrl;
	

	public Url() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
}
