    //package com.insurance.utils.mappers.dto.implementations;
    //
    //import com.insurance.utils.mappers.dto.GenericDTOMapper;
    //import org.springframework.beans.BeanUtils;
    //
    //import java.beans.PropertyDescriptor;
    //import java.lang.reflect.Method;
    //
    //public class GenericDTOMapperImpl implements GenericDTOMapper {
    //    /**
    //     * Convert an entity to a DTO using reflection.
    //     *
    //     * @param entity    The entity to be converted.
    //     * @param dtoClass  The class of the DTO.
    //     * @param <E>       The type of the entity.
    //     * @param <D>       The type of the DTO.
    //     * @return          The corresponding DTO.
    //     */
    //    public static <E, D> D toDto(E entity, Class<D> dtoClass) {
    //        try {
    //            D dto = dtoClass.getDeclaredConstructor().newInstance();
    //
    //            // Loop through the entity's fields using JavaBeans PropertyDescriptor
    //            for (PropertyDescriptor entityProp : BeanUtils.getPropertyDescriptors(entity.getClass())) {
    //                Method getter = entityProp.getReadMethod();
    //                Method setter = findSetterMethod(dtoClass, entityProp.getName(), entityProp.getPropertyType());
    //
    //                if (getter != null && setter != null) {
    //                    Object value = getter.invoke(entity);  // Get value from entity
    //                    setter.invoke(dto, value);             // Set value in DTO
    //                }
    //            }
    //            return dto;
    //
    //        } catch (Exception e) {
    //            throw new RuntimeException("Error occurred during entity-to-DTO mapping", e);
    //        }
    //    }
    //
    //    /**
    //     * Convert a DTO to an entity using reflection.
    //     *
    //     * @param dto       The DTO to be converted.
    //     * @param entityClass The class of the entity.
    //     * @param <E>       The type of the entity.
    //     * @param <D>       The type of the DTO.
    //     * @return          The corresponding entity.
    //     */
    //    public static <E, D> E toEntity(D dto, Class<E> entityClass) {
    //        try {
    //            E entity = entityClass.getDeclaredConstructor().newInstance();
    //
    //            // Loop through the DTO's fields using JavaBeans PropertyDescriptor
    //            for (PropertyDescriptor dtoProp : BeanUtils.getPropertyDescriptors(dto.getClass())) {
    //                Method getter = dtoProp.getReadMethod();
    //                Method setter = findSetterMethod(entityClass, dtoProp.getName(), dtoProp.getPropertyType());
    //
    //                if (getter != null && setter != null) {
    //                    Object value = getter.invoke(dto);  // Get value from DTO
    //                    setter.invoke(entity, value);       // Set value in Entity
    //                }
    //            }
    //            return entity;
    //
    //        } catch (Exception e) {
    //            throw new RuntimeException("Error occurred during DTO-to-entity mapping", e);
    //        }
    //    }
    //
    //    /**
    //     * Convert a list of entities to a list of DTOs.
    //     *
    //     * @param entities  The list of entities to convert.
    //     * @param dtoClass  The DTO class.
    //     * @param <E>       The entity type.
    //     * @param <D>       The DTO type.
    //     * @return          A list of DTOs.
    //     */
    //    public static <E, D> List<D> toDtoList(List<E> entities, Class<D> dtoClass) {
    //        List<D> dtoList = new ArrayList<>();
    //        for (E entity : entities) {
    //            dtoList.add(toDto(entity, dtoClass));
    //        }
    //        return dtoList;
    //    }
    //
    //    /**
    //     * Convert a list of DTOs to a list of entities.
    //     *
    //     * @param dtos      The list of DTOs to convert.
    //     * @param entityClass The entity class.
    //     * @param <E>       The entity type.
    //     * @param <D>       The DTO type.
    //     * @return          A list of entities.
    //     */
    //    public static <E, D> List<E> toEntityList(List<D> dtos, Class<E> entityClass) {
    //        List<E> entityList = new ArrayList<>();
    //        for (D dto : dtos) {
    //            entityList.add(toEntity(dto, entityClass));
    //        }
    //        return entityList;
    //    }
    //
    //    /**
    //     * Helper method to find the setter method in the target class by name.
    //     *
    //     * @param clazz     The class where the method should be located.
    //     * @param fieldName The name of the field to find the setter for.
    //     * @param fieldType The type of the field.
    //     * @param <T>       The target type (entity or DTO).
    //     * @return          The setter method.
    //     */
    //    private static <T> Method findSetterMethod(Class<T> clazz, String fieldName, Class<?> fieldType) {
    //        String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    //        try {
    //            return clazz.getMethod(setterName, fieldType);
    //        } catch (NoSuchMethodException e) {
    //            return null;  // Setter not found, can skip
    //        }
    //    }
    //}
