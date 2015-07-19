package com.exceptionless.Exceptionless;

/**
 * Created by Lukas on 19.07.2015.
 */
public class ExceptionlessClient implements AutoCloseable {
    public ExceptionlessClient() {
        this(new ExceptionlessConfiguration(DependencyResolver.CreateDefault()));
    }



    @Override
    public void close() throws Exception {

    }
}
