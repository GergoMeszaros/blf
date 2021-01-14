package com.blf.gameservice.controller;

import com.blf.gameservice.model.entity.Event;
import com.blf.gameservice.service.EventService;
import org.junit.jupiter.api.BeforeAll;
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

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService mockedService;

    private static final List<Event> events = new ArrayList<>();


    @BeforeAll
    static void setUp(){

        Event event = Event.builder()
                .address("Jókai utca")
                .summary("Test 1")
                .id(1L)
                .build();
        events.add(event);

        Event event2 = Event
                .builder()
                .address("Nagymező utca")
                .summary("Test 2")
                .id(2L)
                .build();

        events.add(event2);
    }


    @Test
    public void smokeTest() {
        assertThat(mockedService).isNotNull();
    }


    @Test
    public void testWrongEndpoint() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/wrongUrl"))
                .andDo(print())
                .andExpect(status().isNotFound());
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