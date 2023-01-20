package net.ngaspar.urlshortener.model

import jakarta.persistence.*
import java.util.*

/*
 * UrlEntry entity - created and fetched from UrlEntryRepository
 */
@Entity
class UrlEntry(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null, val hash: String? = null, val url: String? = null, val createdDate: Date, val lastModifiedDate: Date?, val hits: Long?) {
}