package com.insurance.utils.reflection;

public class ReflectionUtils {
    public static String getClassName(Object object) {
        return object.getClass().getSimpleName();
    }

    public static <T> boolean checkInstanceOf(Object instance, Class<T> clazz) {
        return clazz.isInstance(instance);
    }
}