package com.formatter.document.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DocumentDto(
        var name: String? = null,
        var type: String? = null,
        var items: List<ItemDto> = emptyList()){

    constructor(): this(null, null, emptyList())
}