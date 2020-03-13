package service;

import service.impl.PisicaServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {

    private Map<Class, Object> registry = new HashMap<>();

    private ServiceProvider() {
        registry.put(PisicaService.class, new PisicaServiceImpl());
    }

    private final static class SingletonHolder {
        public final static ServiceProvider INSTANCE = new ServiceProvider();
    }

    public static ServiceProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T get(Class<T> clazz) {
        Object service = registry.get(clazz);

        return clazz.cast(service);
        // return (PisicaService) service;
    }
}
