package com.shorturl.urlshortenerapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "url_additional")
@Table(name="url_additional_details")
public class UrlAdditional {

		@Id
		@Column(name="url_id")
		private long id;

		@Column(name="long_url")
		private String longUrl;
		
		@Column(name="short_url")
		private String shortUrl;
		
		@Column(name="num_of_redirects", columnDefinition = "integer default 0")
		private int numOfRedirects;
		
		@CreationTimestamp
		@Column(name="created_date")
		private Timestamp createdDate;
		
		@Column(name="created_by")
		private String createdBy;
		
		

		public UrlAdditional() {
			super();
		}

		public UrlAdditional(long id, String longUrl, String shortUrl, String createdBy) {
			super();
			this.id = id;
			this.longUrl = longUrl;
			this.shortUrl = shortUrl;
			this.createdBy = createdBy;
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

		public String getShortUrl() {
			return shortUrl;
		}

		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}

		public Timestamp getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Timestamp createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		
		

}
