package com.formatter.document.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ItemDto(
        var description: String? = null) {

    constructor(): this(null)
}