package dropwizard;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.URL;

public class Blog {
	
	private String id = UUID.randomUUID().toString();
	
	
	@JsonProperty("_id")
	private String _id;
	
	@NotBlank
	private String title;
	

	@NotBlank
	@URL
	private String url;
	
	private final Date publishedOn = new Date();
	
	public Blog() {
		
	}

	public Blog(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}
}
