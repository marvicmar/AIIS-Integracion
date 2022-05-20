package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.BookResource;
import aiss.api.resources.BooklistResource;
import aiss.api.resources.GameResource;
import aiss.api.resources.GamelistResource;
import aiss.api.resources.MovieResource;
import aiss.api.resources.UserResource;



public class AiisrateApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public AiisrateApplication() {

		singletons.add(BooklistResource.getInstance());
		singletons.add(BookResource.getInstance());
		singletons.add(MovieResource.getInstance());
		singletons.add(UserResource.getInstance());
		singletons.add(GameResource.getInstance());
		singletons.add(GamelistResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
