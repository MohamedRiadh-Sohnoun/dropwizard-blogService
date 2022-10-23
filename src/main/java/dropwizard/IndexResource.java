package dropwizard;

import java.util.ArrayList;
import java.util.List;

import com.codahale.metrics.annotation.Timed;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

@Path("/")
public class IndexResource {

	JacksonDBCollection<Blog, String> collection;

	public IndexResource(JacksonDBCollection<Blog, String> blogs) {
		this.collection = blogs;
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Timed
	public List<Blog> index() {

		DBCursor<Blog> cursor = collection.find();
		List<Blog> blogs = new ArrayList<>();

		while (cursor.hasNext()) {
			Blog blog = cursor.next();
			blogs.add(blog);
		}

		return blogs;
	}

}
