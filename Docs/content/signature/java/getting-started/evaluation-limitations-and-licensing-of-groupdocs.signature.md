---
id: evaluation-limitations-and-licensing-of-groupdocs-signature
url: signature/java/evaluation-limitations-and-licensing-of-groupdocs-signature
title: Evaluation Limitations and Licensing of GroupDocs.Signature
weight: 5
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}You can use GroupDocs.Signature without the license. The usage and functionalities are pretty much same as the licensed one but you will face few limitations while using the non-licensed API.{{< /alert >}}

## Evaluation Limitations

You can easily download GroupDocs.Signature for evaluation. The evaluation download is the same as the purchased download. The evaluation version simply becomes licensed when you add a few lines of code to apply the license. You will face following limitations while using the API without the license:  

*   Only first 2 pages are processed.
*   Trial badges are placed in the document on the top of each page.

## Licensing

The license file contains details such as the product name, number of developers it is licensed to, subscription expiry date and so on. It contains the digital signature, so don't modify the file. Even inadvertent addition of an extra line break into the file will invalidate it. You need to set a license before utilizing GroupDocs.Signature API if you want to avoid its evaluation limitations.   
The license can be loaded from a file or stream object. 

#### Setting License from File

The code below will explain how to set product license.

```java
// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
// Setup license.
License license = new License();
license.setLicense(licensePath);
```

#### Setting License from Stream

The following example shows how to load a license from a stream.

```java
// For complete examples and data files, please go to https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java
using (FileInputStream fileStream = new FileInputStream("GroupDocs.Signature.lic"))
{
    License license = new License();
    license.setLicense(fileStream);
}
```

#### Setting Metered License

{{< alert style="info" >}}
You can also set [Metered](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.metered/Metered) license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful for the customers who want to be billed based on the usage of the API features. For more details, please refer to [Metered Licensing FAQ](https://purchase.groupdocs.com/faqs/licensing/metered) section.
{{< /alert >}}

Here are the simple steps to use the `Metered` class.

1.  Create an instance of `Metered` class.
2.  Pass public & private keys to `SetMeteredKey` method.
3.  Do processing (perform task).
4.  call method `GetConsumptionQuantity` of the `Metered` class.
5.  It will return the amount/quantity of API requests that you have consumed so far.
6.  call method `GetConsumptionCredit` of the `Metered` class.
7.  It will return the credit that you have consumed so far.

Following is the sample code demonstrating how to use `Metered` class.

```java
// For complete examples and data files, please go to https://github.com/groupdocs-Signature/GroupDocs.Signature-for-Java
string publicKey = ""; // Your public license key
string privateKey = ""; // Your private license key

Metered metered = new Metered();
metered.setMeteredKey(publicKey, privateKey);

// Get amount (MB) consumed
double consumption = metered.getConsumptionQuantity();
System.out.print("Metered consumption = " + consumption);     

// Get count of credits consumed
double credit = metered.getConsumptionCredit();
System.out.print("Metered credit = " + credit);    
```
