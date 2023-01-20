package net.ngaspar.urlshortener.controller

import org.junit.jupiter.api.Test

class UrlEntryResourceTests {

    @Test
    fun `shrink POST call with an existing URL should return an existing hash from the repository`() {
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