package com.exceptionless.Exceptionless;

import com.exceptionless.Exceptionless.Configuration.*;
import com.exceptionless.Exceptionless.Dependency.*;
import com.exceptionless.Exceptionless.Models.*;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Lukas on 19.07.2015.
 */
public class ExceptionlessClient implements AutoCloseable {
    public ExceptionlessClient() {
        this(new ExceptionlessConfiguration(DependencyResolver.CreateDefault()));
    }

    public ExceptionlessClient(String apiKey) {
        getConfiguration().ApiKey = apiKey;
        this(new ExceptionlessConfiguration(DependencyResolver.CreateDefault()));
    }

    public ExceptionlessClient(Consumer<ExceptionlessConfiguration> configure) {
        this(new ExceptionlessConfiguration(DependencyResolver.CreateDefault()));
        if (configure != null) {
            configure.accept(getConfiguration());
        }
    }

    public ExceptionlessClient(ExceptionlessConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("configuration");
        }
        setConfiguration(configuration);
        throw new UnsupportedOperationException("not finished implementing");

    }

    private ExceptionlessConfiguration configuration;

    public boolean updateUserEmailAndDescription(String referenceId, String email, String description) {
        throw new UnsupportedOperationException();
    }

    public Runnable processQueueAsyn() {
        throw new UnsupportedOperationException();
    }

    public void processQueue() {
        throw new UnsupportedOperationException();
    }

    public void submitEvent(Event e) {
        submitEvent(e, null);
    }

    public void submitEvent(Event e, ContextData pluginContextData) {
        throw new UnsupportedOperationException();
    }

    public void createEvent() {
        createEvent(null);
    }

    private void createEvent(ContextData pluginContextData) {
        throw new UnsupportedOperationException();
    }

    public String getLastReferenceId() {
        throw new UnsupportedOperationException();
    }

    //TODO: implement SubmittingEvent

    public boolean onSubmittingEvent(EventSubmittingEventArgs e) {
        throw new UnsupportedOperationException();
    }

    protected void OnSubmittingEvent(EventSubmittingEventArgs e) {
        throw new UnsupportedOperationException();
    }

    private static final Supplier<ExceptionlessClient> defaultClient = lazy(() -> new ExceptionlessClient());


    public static ExceptionlessClient Default() {
        return defaultClient.get();
    }

    @Override
    public void close() throws Exception {

    }

    public ExceptionlessConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ExceptionlessConfiguration configuration) {
        this.configuration = configuration;
    }

    static <Z> Supplier<Z> lazy(final Supplier<Z> supplier) {
        return new Supplier<Z>() {
            Z value; // = null
            @Override public Z get() {
                if (value == null)
                    value = supplier.get();
                return value;
            }
        };
    }
}
