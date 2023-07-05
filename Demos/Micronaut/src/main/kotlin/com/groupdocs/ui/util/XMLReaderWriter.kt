package com.groupdocs.ui.util

import java.io.File

class XMLReaderWriter<T> {
    /**
     * read xml file into java object
     *
     * @param fileName the absolute path to xml file
     * @param clazz the class of returning object
     * @return java object created from file data
     * @throws JAXBException
     */
    @Throws(javax.xml.bind.JAXBException::class)
    fun read(fileName: String, clazz: Class<T>): Any? {
        val jc: javax.xml.bind.JAXBContext = javax.xml.bind.JAXBContext.newInstance(clazz)
        val unmarshaller: javax.xml.bind.Unmarshaller = jc.createUnmarshaller()
        val xml = File(fileName)
        return unmarshaller.unmarshal(xml)
    }

    /**
     * write java object into xml file
     *
     * @param fileName the absolute path to xml file
     * @param obj the java object for serialization
     * @throws JAXBException
     */
    @Throws(javax.xml.bind.JAXBException::class)
    fun write(fileName: String?, obj: T) {
        val file = File(fileName)
        val jaxbContext: javax.xml.bind.JAXBContext = javax.xml.bind.JAXBContext.newInstance(obj!!::class.java)
        val jaxbMarshaller: javax.xml.bind.Marshaller = jaxbContext.createMarshaller()
        jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true)
        jaxbMarshaller.marshal(obj, file)
    }
}