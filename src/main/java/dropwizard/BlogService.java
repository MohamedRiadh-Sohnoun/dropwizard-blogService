package dropwizard;

import com.mongodb.DB;
import com.mongodb.Mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import net.vz.mongodb.jackson.JacksonDBCollection;



public class BlogService extends Application<BlogConfiguration> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogService.class);
	public static void main(String[] args) throws Exception {
		new BlogService().run(new String[] { "server" });
	}

	@Override
	public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
		
	}

	@Override
	public void run(BlogConfiguration configuration, Environment environment) throws Exception {
		
		Mongo mongo = new Mongo(configuration.mongoHost, configuration.mongoPort);
		MongoManaged mongoManaged = new MongoManaged(mongo);
		
		environment.lifecycle().manage(mongoManaged);
		environment.healthChecks().register("Health Check",new MongoHealthCheck(mongo));
		
		DB db = mongo.getDB(configuration.mongoDb);
		JacksonDBCollection<Blog, String> blogs = JacksonDBCollection.wrap(db.getCollection("blogs"), Blog.class, String.class);
		
		
		LOGGER.info("Method App#run() called");
		System.out.println( "Hello world, by Dropwizard!" );
		
		environment.jersey().register(new IndexResource(blogs));
		environment.jersey().register(new BlogResource(blogs));
	}

}










