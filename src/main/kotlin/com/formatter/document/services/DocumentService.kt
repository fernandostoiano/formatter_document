package com.formatter.document.services

import com.formatter.document.model.Document

interface DocumentService {

    fun fetchDocument(): Document

    fun pullDocument(name: String): Document
}