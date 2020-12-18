package com.blf.gameservice.service.util;

import com.blf.gameservice.entity.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class UpdateValidator {

    private Object oldDataModifier(Object old, Object input) throws IllegalAccessException {

        Field[] oldFields = old.getClass().getDeclaredFields();
        Field[] updatedFields = input.getClass().getDeclaredFields();

        int oldFieldsLength = oldFields.length;

        for (int i = 0; i < oldFieldsLength; i++) {

            oldFields[i].setAccessible(true);
            updatedFields[i].setAccessible(true);

            String idName = oldFields[i].getName();

            Object value = oldFields[i].get(old);
            Object value2 = updatedFields[i].get(input);

            if (value != value2 && value2 != null && !idName.equals("id")) {
                oldFields[i].set(old, value2);
            }
        }
        return old;
    }

    public Event updater(Event old, Event input) throws IllegalAccessException {
        return (Event) oldDataModifier(old, input);
    }

    public League updater(League old, League input) throws IllegalAccessException {
        return (League) oldDataModifier(old, input);
    }

    public Player updater(Player old, Player input) throws IllegalAccessException {
        return (Player) oldDataModifier(old, input);
    }

    public Team updater(Team old, Team input) throws IllegalAccessException {
        return (Team) oldDataModifier(old, input);
    }

    public TeamMember updater(TeamMember old, TeamMember input) throws IllegalAccessException {
        return (TeamMember) oldDataModifier(old, input);
    }

    public StatisticalRow updater(StatisticalRow old, StatisticalRow input) throws IllegalAccessException {
        return (StatisticalRow) oldDataModifier(old, input);
    }

    public Season updater(Season old, Season input) throws IllegalAccessException {
        return (Season) oldDataModifier(old,input);
    }

}
