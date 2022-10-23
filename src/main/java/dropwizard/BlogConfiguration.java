package dropwizard;

import io.dropwizard.core.Configuration;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import org.codehaus.jackson.annotate.JsonProperty;

public class BlogConfiguration extends Configuration{

	@JsonProperty
	@NotEmpty
	public String mongoHost = "127.0.0.1";
	
	@JsonProperty
	@Min(1)
	@Max(65535)
	public int mongoPort = 27017;
	
	@JsonProperty
	@NotEmpty
	public String mongoDb = "blogdatabase";
	
	
}
