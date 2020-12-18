package com.blf.gameservice.controller;

import com.blf.gameservice.entity.Event;
import com.blf.gameservice.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@WebMvcTest(controllers = EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService mockedService;

    private List<Event> events;

    @BeforeEach
    public void setUp() throws IllegalAccessException, NoSuchFieldException {
        Event event1 = Event.builder()
                .id(1L)
                .summary("test event")
                .build();

        Event event2 = Event.builder()
                .id(2L)
                .summary("második event")
                .build();

        events = Arrays.asList(event2, event1);


        Field[] fields = event1.getClass().getDeclaredFields();
        Field[] fields2 = event2.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields2[i].setAccessible(true);
            String idName = fields[i].getName();
            Object value = fields[i].get(event1);
            Object value2 = fields2[i].get(event2);

            if(value != value2 && value2 != null && !idName.equals("id"))
                value = value2;
        }

        /*for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(event1);
            System.out.println(value);
        }*/
    }

    @Test
    public void testAllEvents() throws Exception {
        String URI = "/event";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI);

        Mockito
                .when(mockedService.getAllEvents())
                .thenReturn(events);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //String outputJson = response.getContentAsString();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}