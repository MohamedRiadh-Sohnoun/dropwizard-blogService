package dropwizard;

import com.codahale.metrics.annotation.Timed;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import net.vz.mongodb.jackson.JacksonDBCollection;

@Path("/blogs")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BlogResource {

	private JacksonDBCollection<Blog, String> collection;

	public BlogResource(JacksonDBCollection<Blog, String> blogs) {
		this.collection = blogs;
	}

	@POST
	@Timed
	public Response publishNewBlog(@Valid Blog blog) {

		collection.insert(blog);
		return Response.noContent().build();

	}

}
