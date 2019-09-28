package com.formatter.document.services

import com.formatter.document.model.Document
import com.formatter.document.nfio.NfioApi
import com.formatter.document.repositories.DocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DocumentServiceImpl: DocumentService {

    @Autowired
    private lateinit var nfio: NfioApi

    @Autowired
    private lateinit var documentRepository: DocumentRepository

    override fun fetchDocument(): Document {
        val document: Document = nfio.getDocument()


        val saved = documentRepository.save(document)

        println(saved.id)
        println(saved.name)
        println(saved.items.size)

        return saved
    }

    override fun pullDocument(name: String): Document {
        return documentRepository.findByName(name)
    }

}