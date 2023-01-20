package net.ngaspar.urlshortener.service

import net.ngaspar.urlshortener.model.UrlEntry
import net.ngaspar.urlshortener.repository.UrlEntryRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UrlShortenerServiceDirtyImplTests {

    @Mock
    private val repository: UrlEntryRepository? = null

    @Test
    fun `when a UrlEntry for a given URL exists in the repository, fetchOrCreateShortUrl should return the existing UrlEntry`() {
        val url = "https://www.example.com"
        Mockito.`when`(repository!!.getByUrl(url)).thenReturn(UrlEntry(123, "hash", "url", Date(), Date(), 1))
        val urlEntry = UrlShortenerServiceDirtyImpl(repository).fetchOrCreateShortUrl(url)
        assertEquals("hash", urlEntry?.hash)
        assertEquals("url", urlEntry?.url)
    }

    @Test
    fun `when a UrlEntry for a given URL does not exist in the repository, fetchOrCreateShortUrl should create a new UrlEntry and return it`() {
        val url = "https://www.example.com"
        Mockito.`when`(repository!!.getByUrl(url)).thenReturn(null)
        val urlEntry = UrlShortenerServiceDirtyImpl(repository).fetchOrCreateShortUrl(url)
        //NG: Can only test url here, hashes are randomized
        assertEquals(url, urlEntry?.url)
    }

    @Test
    fun `when a UrlEntry for a given hash exists in the repository, fetchLongUrlByHash should return the existing UrlEntry and increment its clicks`() {
        val url = "https://www.example.com"
        Mockito.`when`(repository!!.getByUrl(url)).thenReturn(UrlEntry(123, "hash", "url", Date(), Date(), 1))
        val urlEntry = UrlShortenerServiceDirtyImpl(repository).fetchLongUrlByHash("hash")
        val urlEntry2ndCall = UrlShortenerServiceDirtyImpl(repository).fetchLongUrlByHash("hash")
        println("********** HEY! $urlEntry2ndCall?.hits")
        assertEquals("hash", urlEntry?.hash)
        assertEquals(url, urlEntry?.url)
        assertEquals(urlEntry2ndCall?.hits, 2)
    }

    @Test
    fun `when a UrlEntry for a given hash does not exist in the repository, fetchLongUrlByHash should not return the existing UrlEntry`() {
        val url = "https://www.example.com"
        Mockito.`when`(repository!!.getByUrl(url)).thenReturn(null)
        val urlEntry = UrlShortenerServiceDirtyImpl(repository).fetchLongUrlByHash("hash")
        assertEquals(null, urlEntry)
    }
}