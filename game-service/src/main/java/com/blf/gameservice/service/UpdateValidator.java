package com.blf.gameservice.service;

import com.blf.gameservice.entity.DataModel;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class UpdateValidator {

    protected <Type extends DataModel> Type updater(Type old, Type input) throws IllegalAccessException {

        Field[] oldFields = old.getClass().getDeclaredFields();
        Field[] updatedFields = input.getClass().getDeclaredFields();

        int oldFieldsLength = oldFields.length;

        for (int i = 0; i < oldFieldsLength; i++) {

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
