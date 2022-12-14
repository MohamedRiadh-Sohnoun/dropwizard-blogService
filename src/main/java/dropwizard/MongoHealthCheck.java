package dropwizard;

import com.mongodb.Mongo;

import com.codahale.metrics.health.HealthCheck;

public class MongoHealthCheck extends HealthCheck{

	private Mongo mongo;
	
	public MongoHealthCheck(Mongo mongo) {
		super();
		this.mongo = mongo;
	}

	@Override
	protected Result check() throws Exception {
		mongo.getDatabaseNames();

        return Result.healthy();
	}
}
