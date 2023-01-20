package net.ngaspar.urlshortener.service

import net.ngaspar.urlshortener.model.UrlEntry

interface UrlShortenerService {

    fun fetchOrCreateShortUrl(longUrl: String): UrlEntry?

    fun fetchLongUrlByHash(hash: String): UrlEntry?
}