package com.example;

import com.example.readinglist.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }

    @Test
    public void homepage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/readingList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingListqq"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/readingList")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "BOOK TITLE")
                .param("author", "BOOK AUTHOR")
                .param("isbn", "1234567890")
                .param("description", "DESCRIPTION"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.header().string("Location", "/readingList"));

        Book expectBook = new Book();
        expectBook.setId(1L);
        expectBook.setReader("readingList");
        expectBook.setTitle("BOOK TITLE");
        expectBook.setAuthor("BOOK AUTHOR");
        expectBook.setIsbn("1234567890");
        expectBook.setDescription("DESCRIPTION");

        mockMvc.perform(MockMvcRequestBuilders.get("/readingList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", hasSize(1)))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.contains(samePropertyValuesAs(expectBook))));
    }

    @Test
    public void contextLoads() {
    }

}
