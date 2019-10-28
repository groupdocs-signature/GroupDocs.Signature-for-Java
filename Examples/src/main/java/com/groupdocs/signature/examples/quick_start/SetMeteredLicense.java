package com.groupdocs.signature.examples.quick_start;


import com.groupdocs.signature.metered.Metered;

public class SetMeteredLicense {
    /**
     * This example demonstrates how to set license from stream.
     */
    public static void run() throws Exception
    {
        String publicKey = "*****";
        String privateKey = "*****";

        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);

        System.out.print("License set successfully.");
    }
}