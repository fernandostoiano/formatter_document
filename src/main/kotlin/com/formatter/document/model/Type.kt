package com.formatter.document.model

enum class Type {

    INVOICE;

    companion object {
        fun getTypeByName(name: String?) = valueOf(name?.toUpperCase())

        private fun valueOf(value: String?): Type {
            return INVOICE
        }
    }
}