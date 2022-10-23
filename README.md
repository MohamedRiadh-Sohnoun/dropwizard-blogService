***Dropwizard -- The Awesome Java REST Server Stack***

**An Example by Mohamed Riadh Sohnoun**

Dropwizard is an open source Java framework for developing ops-friendly, high-performance RESTful backends. It was developed by Yammer to power their JVM based backend.

Dropwizard provides best-of-breed Java libraries into one embedded application package. It consists of following components :

1- Embedded Jetty : Every application is packaged as a jar instead of war file and starts its own embedded jetty container. There is no WAR file and no external servlet container.

2- JAX-RS : Jersey(the reference implementation for JAX-RS) is used to write RESTful web services. So, your existing JAX-RS knowledge is not wasted.

3- JSON : The REST services speaks JSON. Jackson library is used to do all the JSON processing.

4- Logging : It is done using Logback and SLF4J.

5- Hibernate Validator : Dropwizard uses Hibernate Validator API for declarative validation.

6- Metrics : Dropwizard has support for monitoring using the metrics library. It provides unparalleled insight into what our code does in production.
