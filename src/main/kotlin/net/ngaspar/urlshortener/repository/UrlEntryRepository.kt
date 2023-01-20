package net.ngaspar.urlshortener.repository

import net.ngaspar.urlshortener.model.UrlEntry
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

/*
 * Repository for UrlEntries
 */
interface UrlEntryRepository: CrudRepository<UrlEntry, Long> {

    @Query("SELECT ue FROM UrlEntry ue WHERE ue.hash = :hash")
    fun getByHash(hash: String): UrlEntry?

    @Query("SELECT ue FROM UrlEntry ue WHERE ue.url = :url")
    fun getByUrl(url: String): UrlEntry?

    @Modifying
    @Query("INSERT INTO url_entry(url, hash, create_date, last_modified_date) VALUES (:url, :hash, :createdDate, :createdDate) RETURNING id, hash, url", nativeQuery = true)
    fun create(hash: String, url: String, createdDate: Date): UrlEntry

    @Modifying
    @Query("UPDATE url_entry SET hits = hits + 1, last_modified_date = :date WHERE hash = :hash", nativeQuery = true)
    fun incrementHits(hash: String, date: Date? = Date())
}