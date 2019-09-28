package com.formatter.document.controller

import com.formatter.document.model.Document
import com.formatter.document.services.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller("/document")
class DocumentController {

    @Autowired
    private lateinit var documentService: DocumentService

    @PostMapping(name="/fetch", consumes=[MediaType.APPLICATION_JSON_UTF8_VALUE], produces=[MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun fetchDocument(): ResponseEntity<Document> {

        val document = documentService.fetchDocument()

        return ResponseEntity<Document>(document, HttpStatus.OK)
    }

    @GetMapping(name="/pull", consumes=[MediaType.APPLICATION_JSON_UTF8_VALUE], produces=[MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun pullDocument(@RequestParam("name") name: String): ResponseEntity<Document> {

        val document = documentService.pullDocument(name)

        return ResponseEntity<Document>(document, HttpStatus.OK)
    }

}
