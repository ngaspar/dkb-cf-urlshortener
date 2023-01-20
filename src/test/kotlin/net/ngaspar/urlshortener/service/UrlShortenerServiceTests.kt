package net.ngaspar.urlshortener.service

import org.junit.jupiter.api.Test

class UrlShortenerServiceTests {

    @Test
    fun `when a UrlEntry for a given URL exists in the repository, fetchOrCreateShortUrl should return the existing UrlEntry`() {
    }

    @Test
    fun `when a UrlEntry for a given URL does not exist in the repository, fetchOrCreateShortUrl should create a new UrlEntry and return it`() {
    }

    @Test
    fun `when a UrlEntry for a given hash exists in the repository, fetchLongUrlByHash should return the existing UrlEntry and increment its clicks`() {
    }

    @Test
    fun `when a UrlEntry for a given hash does not exist in the repository, fetchLongUrlByHash should not return the existing UrlEntry`() {
    }
}