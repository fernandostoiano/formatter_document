package com.formatter.document.nfio

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.formatter.document.dto.DocumentDto
import com.formatter.document.model.Document
import com.formatter.document.model.Item
import com.formatter.document.model.Type
import org.springframework.stereotype.Component
import java.io.File

@Component
class NfioApiImpl: NfioApi {

    override fun getDocument(): Document {
        val xmlMapper = XmlMapper()
        val document = xmlMapper.readValue(this.getXml(), DocumentDto::class.java)
        return this.convertDocument(document)
    }


    private fun getXml(): File {
        var xmlFile = System.getProperty("user.dir") + "/document.xml"
        var file: File = File(xmlFile)
        return file
    }

    private fun convertDocument(documentDto: DocumentDto): Document {
        val items: MutableList<Item> = ArrayList()
        for (itemDto in documentDto.items) {
            val item = Item(itemDto.description)
            items.add(item)
        }
        val document = Document(documentDto.name, Type.getTypeByName(documentDto.type), items)

        return document
    }

}
