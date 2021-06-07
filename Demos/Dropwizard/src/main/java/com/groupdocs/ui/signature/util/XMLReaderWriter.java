package com.groupdocs.ui.signature.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLReaderWriter<T> {

    /**
     * read xml file into java object
     *
     * @param fileName the absolute path to xml file
     * @param clazz the class of returning object
     * @return java object created from file data
     * @throws JAXBException
     */
    public T read(String fileName, Class<T> clazz) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File(fileName);
        T obj = (T) unmarshaller.unmarshal(xml);
        return obj;
    }

    /**
     * write java object into xml file
     *
     * @param fileName the absolute path to xml file
     * @param obj the java object for serialization
     * @throws JAXBException
     */
    public void write(String fileName, T obj) throws JAXBException {
        File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(obj, file);
    }
}
