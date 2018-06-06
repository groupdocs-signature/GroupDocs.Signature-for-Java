package com.groupdocs.signature.examples;

import com.groupdocs.signature.domain.extensions.serialization.FormatAttribute;
import com.groupdocs.signature.domain.extensions.serialization.SkipSerializationAttribute;

public class DocumentSignature
{
    public String getVersion(){ return Version; }
    public void setVersion(String value){ Version = value; }
        // specify SkipSerialization attribute to skip this field on serialization
        @SkipSerializationAttribute()
    public String Version;
 
    public boolean isProcessed(){ return IsProcessed; }
    public void setProcessed(boolean value){ IsProcessed = value; }
        // specify SkipSerialization attribute to skip this field on serialization
        @SkipSerializationAttribute()
    public boolean IsProcessed;
 
    public String getID(){ return ID; }
    public void setID(String value){ ID = value; }
        @FormatAttribute (propertyName = "SignatureID")
    public String ID;
 
 
    public String getAuthor(){ return Author; }
    public void setAuthor(String value){ Author = value; }
        @FormatAttribute (propertyName = "Author")
    public String Author;
 
 
    public java.util.Date getSigned() { return Signed; }
    public void setSigned(java.util.Date value) { Signed = value; }
        @FormatAttribute (propertyName = "SignatureDate",propertyFormat = "yyyy-MM-dd")
    public java.util.Date Signed = new java.util.Date();
 
 
    public java.math.BigDecimal getDataFactor() { return DataFactor; }
    public void setDataFactor(java.math.BigDecimal value) { DataFactor = value; }
        @FormatAttribute (propertyName = "Factor", propertyFormat = "N2")
    public java.math.BigDecimal DataFactor = new java.math.BigDecimal(0.01);
}