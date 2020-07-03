---
id: groupdocs-signature-for-java-19-5-release-notes
url: signature/java/groupdocs-signature-for-java-19-5-release-notes
title: GroupDocs.Signature for Java 19.5 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 19.5{{< /alert >}}

## Major Features

There are few new features, improvements and bug fixes in this regular release. Summary the most notable changes are:

*   Added support of rounded corners for Stamp inner lines
*   Fixed Barcode and QR-code singing with wide borders for better recognition
*   Improved signatures options detection

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-1856 | Fix Stamp generation processing for wide areas | Bug |
| SIGNATURENET-1851 | QR/Bar code with wide border cannot be read | Bug |
| SIGNATURENET-1786 | Implement Rounded corners for Rectangle Stamp Signature Types | New Feature |
| SIGNATURENET-1871 | Improve Image Metadata type conversion | Improvement |
| SIGNATURENET-1858 | Optimize Document options type detection for handler processes (Sign/Verify/Search) | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 19.5. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  com.groupdocs.signature.domain.helpers.stamp.Corners
    
    New public class **Corners **was added to implement storage for square corners radius values. Zero value means no rounded corner.
    
    This class is able to contain data about four corners of square object.
    
    **Corners class properties**
    
    ```java
    /**
     * <p>
     * Represents corners of a square graphical object.
     * </p>
     */
    public class Corners implements ICloneable, Cloneable
    { 
        /**
         * <p>
         * Provides a Corners object with no data.
         * </p>
         */
        public static final Corners Empty;
     
        /**
         * <p>
         * Gets or sets the value for all corners.
         * Changing of any partial corner like top right makes this property equal 0;
         * </p>
         */   
        public final double getAll(); 
     
        /**
         * <p>
         * Gets or sets the value for all corners.
         * Changing of any partial corner like top right makes this property equal 0;
         * </p>
         */  
        public final void setAll(double value);
     
        /**
         * <p>
         * Gets or sets top left corner value.
         * </p>
         */  
        public final double getTopLeft(); 
     
        /**
         * <p>
         * Gets or sets top left corner value.
         * </p>
         */   
        public final void setTopLeft(double value);
     
        /**
         * <p>
         * Gets or sets top right corner value.
         * </p>
         */   
        public final double getTopRight();
     
        /**
         * <p>
         * Gets or sets top right corner value.
         * </p>
         */   
        public final void setTopRight(double value);
     
        /**
         * <p>
         * Gets or sets bottom left corner value.
         * </p>
         */  
        public final double getBottomLeft() ;
     
        /**
         * <p>
         * Gets or sets bottom left corner value.
         * </p>
         */  
        public final void setBottomLeft(double value);
     
        /**
         * <p>
         * Gets or sets bottom right corner value.
         * </p>
         */  
        public final double getBottomRight();
     
        /**
         * <p>
         * Gets or sets bottom right corner value.
         * </p>
         */  
        public final void setBottomRight(double value);   
     
        /**
         * <p>
         * Initializes a new instance of Corners class using zero values.
         * </p>
         */  
        public Corners();
     
        /**
         * <p>
         * Initializes a new instance of the Corners class using the supplied value for all corners.
         * </p>
         * @param all The value to be used for padding for all corners.
         */   
        public Corners(int all);
     
        /**
         * <p>
         * Initializes a new instance of the Corners class using the supplied values.
         * </p>
         * @param topLeft Top left corner value.
         * @param topRight Top right corner value.
         * @param bottomLeft Bottom left corner value.
         * @param bottomRight Bottom right corner value.
         */   
        public Corners(int topLeft, int topRight, int bottomLeft, int bottomRight);
    } 
    ```
    
2.  com.groupdocs.signature.domain.helpers.stamp.SquareBorderLine  
    
    New public class **SquareBorderLine** inherits **BorderLine** and was added to implement square signature with rounded corners.
    
    This class is able to contain data about radius of square signature corners.
    
    **SquareBorderLine class properties**
    
    ```java
    /**
     * <p>
     * Instance to keep Border line properties for square stamp line.
     * </p>
     */
    public class SquareBorderLine extends BorderLine
    {
        /**
         * <p>
         * Gets or sets the radius of square corners.
         * </p>
         */
        public final Corners getRadius();
     
        /**
         * <p>
         * Gets or sets the radius of square corners.
         * </p>
         */
        public final void setRadius(Corners value);
        private Corners auto_Radius;
     
        /**
         * <p>
         * Create SquareBorderLine with rounded corner radius.
         * </p>
         * @param radius Radius of square corners.
         */  
        public SquareBorderLine(double radius);
         
        /**
         * <p>
         * Create SquareBorderLine with corner radius values.
         * </p>
         * @param corners Radius of square corners.
         */  
        public SquareBorderLine(Corners corners);
    }
    ```
    
    **SquareBorderLine example**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath("\\Storage");
    signConfig.setOutputPath("\\Output");
     
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
    // setup options
    ImagesStampSignOptions signOptions = new ImagesStampSignOptions();
    signOptions.setHeight(100);
    signOptions.setWidth(300);
     
    signOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
     
    //Inner square lines
    StampLine line0 = new StampLine();
    line0.setText("PAID");
    line0.setTextColor(Color.WHITE);
    line0.getFont().setFontSize(32);
    line0.getFont().setBold(true);
    line0.setHeight(100);
    //Set radius of square corner
    line0.setOuterBorder(new SquareBorderLine(new Corners(25))); //This type is supported starting from version 19.5
    line0.getOuterBorder().setColor(Color.GRAY);
    line0.getOuterBorder().setWeight(2);
    line0.setBackgroundColor(Color.GRAY);
    signOptions.getInnerLines().add(line0);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("DocImages_Stamp_RoundedCorners");
     
    // sign document
    String signedPath = handler.<String>sign("test.png", signOptions, tmp0);
    System.out.println("Signed file path is: " +  signedPath);
    ```
