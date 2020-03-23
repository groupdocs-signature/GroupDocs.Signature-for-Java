package com.groupdocs.signature.examples.advanced_usage.custom_serialization;


import com.google.gson.Gson;
import com.groupdocs.signature.domain.extensions.serialization.IDataSerializer;


/**
 * Creates class that implements IDataSerializer interface
 * It cam support common serialization like JSon or custom data format
 */
public class CustomSerializationAttribute implements IDataSerializer{


    public <T> T deserialize(String source, Class<T> type)
    {
        return new Gson().fromJson(source, type);
    }
    public String serialize(Object data)
    {
        return new Gson().toJson(data);
    }

}