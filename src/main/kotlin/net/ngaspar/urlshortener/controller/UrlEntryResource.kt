package net.ngaspar.urlshortener.controller

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@EntityListeners(AuditingEntityListener::class)
class UrlEntry(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null, val hash: String, val url: String, val createdDate: CreatedDate, val lastModifiedDate: LastModifiedDate, val hits: Int) {
}