package com.formatter.document.repositories

import com.formatter.document.model.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentRepository: MongoRepository<Document, String> {

    fun findByName(name: String): Document

}
