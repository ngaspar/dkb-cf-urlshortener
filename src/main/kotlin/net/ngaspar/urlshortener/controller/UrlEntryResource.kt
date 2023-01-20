package net.ngaspar.urlshortener.controller

import net.ngaspar.urlshortener.model.UrlEntry
import net.ngaspar.urlshortener.model.UrlEntryRequest
import net.ngaspar.urlshortener.service.UrlShortenerServiceDirtyImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class UrlEntryResource @Autowired constructor(private val service: UrlShortenerServiceDirtyImpl){

    /*
     * Returns the original URL corresponding to a given hash
     */
    @GetMapping("/stretch/{hash}")
    fun getUrlFromHash(@PathVariable hash: String): String {
        return service.fetchLongUrlByHash(hash)?.url ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No URL exists for the hash $hash")
    }

    /*
     * Returns the UrlEntry object corresponding to a given hash
     */
    @GetMapping("/stats/{hash}")
    fun getUrlStatsFromHash(@PathVariable hash: String): UrlEntry {
        return service.fetchUrlEntryByHash(hash)?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No URL exists for the hash $hash")
    }

    /*
     * Creates and returns a new hash from a given URL, if it does not exist
     * in the repository; otherwise returns existing one
     */
    @PostMapping("/shrink/")
    fun createOrGetHashFromUrl(@RequestBody request: UrlEntryRequest): String {
        return service.fetchOrCreateShortUrl(request.url)?.hash ?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating hash for URL ${request.url}")
    }
}