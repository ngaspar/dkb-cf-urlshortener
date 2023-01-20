package net.ngaspar.urlshortener.service

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import jakarta.transaction.Transactional
import net.ngaspar.urlshortener.model.UrlEntry
import net.ngaspar.urlshortener.repository.UrlEntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Date

/*
 * UrlShortenerService implementation specific to this solution
 */
@Service
class UrlShortenerServiceDirtyImpl @Autowired constructor(private val repository: UrlEntryRepository): UrlShortenerService {
    @Transactional
    override fun fetchOrCreateShortUrl(longUrl: String): UrlEntry? {
        var urlEntry = repository.getByUrl(longUrl)
        if(urlEntry == null) {
            val now = Date()
            urlEntry = UrlEntry(null, NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, NanoIdUtils.DEFAULT_ALPHABET,10), longUrl, now, now, 1)
            repository.save(urlEntry)
        }
        else {
            urlEntry.hash?.let { incrementHitsByHash(it) }
        }
        return urlEntry
    }

    @Transactional
    override fun fetchLongUrlByHash(hash: String): UrlEntry? {
        val urlEntry = repository.getByHash(hash)
        urlEntry?.apply {
            urlEntry.hash?.let { incrementHitsByHash(hash) }
        }
        return urlEntry
    }

    @Transactional
    private fun incrementHitsByHash(hash: String) {
        repository.incrementHits(hash)
    }

    fun fetchUrlEntryByHash(hash: String): UrlEntry? {
        return repository.getByHash(hash)
    }
}