package net.ngaspar.urlshortener.controller

import net.ngaspar.urlshortener.model.UrlEntry
import net.ngaspar.urlshortener.repository.UrlEntryRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import java.util.*

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlEntryResourceTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var repository: UrlEntryRepository

    @Test
    fun `shrink POST call with an existing URL should return an existing hash from the repository`() {
        val url = "https://www.example.com"
        Mockito.`when`(repository!!.getByUrl(url)).thenReturn(UrlEntry(123, "hash", url, Date(), Date(), 1))
        val responseBody =
            mockMvc.perform(MockMvcRequestBuilders.post("/shrink").contentType(APPLICATION_JSON_VALUE).content(url))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful).andReturn().response.contentAsString
        assertEquals("hash", responseBody?.trim())
    }

    @Test
    fun `shrink POST call with non-existing URL should create a new hash in the repository`() {
    }

    @Test
    fun `stretch GET call with an existing hash string should return an existing URL from the repository`() {
    }

    @Test
    fun `stretch GET call with a non-existing hash string should not return any URL from the repository`() {
    }

    @Test
    fun `stats GET call with an existing hash string should return an existing UrlEntry from the repository`() {
    }

    @Test
    fun `stats GET call with a non-existing hash string should not return any UrlEntry from the repository`() {
    }
}