package com.formatter.document.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Document(
        @Id val id: String? = null,
        val name: String? = null,
        val type: Type? = null,
        var items: List<Item> = emptyList()) {

    constructor(name: String?, type: Type, items: List<Item>): this(null, name, type, items)
}
