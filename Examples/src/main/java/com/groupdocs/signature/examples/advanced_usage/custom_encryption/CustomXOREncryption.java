package com.groupdocs.signature.examples.advanced_usage.custom_encryption;


import com.groupdocs.signature.domain.extensions.encryption.IDataEncryption;

public class CustomXOREncryption implements IDataEncryption
{
    /**
     * <p>
     * Gets or sets non empty key for encryption (at least one character)
     * </p>
     */
    public final int getKey(){ return auto_Key; }
    /**
     * <p>
     * Gets or sets non empty key for encryption (at least one character)
     * </p>
     */
    public final void setKey(int value){ auto_Key = value; }
    private int auto_Key;

    /**
     * <p>
     * Encode method to encrypt string.
     * </p>
     * @return Returns enccrypted string
     * @param source Source string to encode.
     */
    public final String encode(String source)
    {
        return process(source);
    }

    /**
     * <p>
     * Decode method to obtain decrypted string.
     * </p>
     * @return Returns decrypted string
     * @param source Source string to decode.
     */
    public final String decode(String source)
    {
        return process(source);
    }

    /**
     * <p>
     * Using XOR operation get encoded / decoded string
     * </p>
     * @return
     * @param source
     */
    private String process(String source)
    {
        StringBuilder src = new StringBuilder(source);
        StringBuilder dst = new StringBuilder(src.length());
        char chTmp;
        for (int index = 0; index < src.length(); ++index)
        {
            chTmp = src.charAt(index);
            chTmp = (char)(chTmp ^ this.getKey());
            dst.append(chTmp);
        }
        return dst.toString();
    }
}