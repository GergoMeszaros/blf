package com.blf.gameservice.service;

import com.blf.gameservice.entity.DataModel;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;


@Service
public class UpdateValidator {

    /**
     * This method is using generics and to accept only the required class types, it extends
        the parent class of all entities.
     * Firstly it creates two arrays from the fields of the parameter objects.
     * After that the loop makes the values accessible regardless of their access modifier.
     * Finally compares the values of the fields and only if these values are different and not named as "id" and
        the updatedField's value is not "null" replaces the old vale.
     */
    protected <Type extends DataModel> Type updater(Type old, Type input) throws IllegalAccessException {

        Field[] oldFields = old.getClass().getDeclaredFields();
        Field[] updatedFields = input.getClass().getDeclaredFields();

        int numberOfFields = oldFields.length;

        for (int i = 0; i < numberOfFields; i++) {

            oldFields[i].setAccessible(true);
            updatedFields[i].setAccessible(true);

            String idName = oldFields[i].getName();

            Object oldValue = oldFields[i].get(old);
            Object inputValue = updatedFields[i].get(input);

            if (oldValue != inputValue && inputValue != null && !idName.equals("id")) {
                oldFields[i].set(old, inputValue);
            }
        }
        return old;
    }
}
