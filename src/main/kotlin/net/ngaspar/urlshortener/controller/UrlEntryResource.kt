package net.ngaspar.urlshortener.controller

import jakarta.persistence.*
import net.ngaspar.urlshortener.model.UrlEntry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlEntryResource {

    /*
     * Returns the original URL corresponding to a given hash
     */
    @GetMapping("/stretch/{hash}")
    fun getUrlFromHash(@PathVariable hash: String): String {
        TODO("Not implemented yet")
    }

    /*
     * Returns the UrlEntry object corresponding to a given hash
     */
    @GetMapping("/stats/{hash}")
    fun getUrlStatsFromHash(@PathVariable hash: String): UrlEntry {
        TODO("Not implemented yet")
    }

    /*
     * Creates and returns a new hash from a given URL, if it does not exist
     * in the repository; otherwise returns existing one
     */
    @PostMapping("/shrink/")
    fun createOrGetHashFromUrl(@RequestBody request: String): String {
        TODO("Not implemented yet")
    }
}

