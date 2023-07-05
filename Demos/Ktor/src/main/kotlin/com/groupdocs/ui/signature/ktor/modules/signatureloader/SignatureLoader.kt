package com.groupdocs.ui.modules.signatureloader

import com.groupdocs.ui.signature.ktor.model.FileDescriptionEntity
import com.groupdocs.ui.signature.ktor.model.SignatureFileDescriptionEntity
import com.groupdocs.ui.util.PathConstants.DATA_PREVIEW_FOLDER
import com.groupdocs.ui.util.PathConstants.DATA_XML_FOLDER
import com.groupdocs.ui.util.SignatureType.TEXT
import java.io.*
import java.util.*

open class SignatureLoader
/**
 * Constructor
 *
 */
{


    /**
     * load text signatures
     *
     * @param currentPath
     * @param dataPath
     * @return
     */
    fun loadTextSignatures(currentPath: String, dataPath: String): List<SignatureFileDescriptionEntity> {
        val xmlPath = currentPath + DATA_XML_FOLDER
        return try {
            val filesList = Arrays.asList(*File(xmlPath).listFiles())
            getResultFileList(dataPath, TEXT, filesList, false)
        } catch (ex: Exception) {
            throw RuntimeException(ex.message, ex)
        }
    }


    //@Throws(IOException::class, javax.xml.bind.JAXBException::class)
    private fun getResultFileList(
        path: String,
        signatureType: String,
        filesList: List<File>,
        withImage: Boolean
    ): List<SignatureFileDescriptionEntity> {
        var filesList = filesList
        val fileList: MutableList<SignatureFileDescriptionEntity> = ArrayList<SignatureFileDescriptionEntity>()

        return fileList
    }

    companion object {
        /**
         * Load image signatures
         *
         * @return List<SignatureFileDescriptionEntity>
        </SignatureFileDescriptionEntity> */
        fun loadImageSignatures(currentPath: String, dataPath: String): List<FileDescriptionEntity> {
            val directory = File(currentPath)
            val fileList = ArrayList<FileDescriptionEntity>()
            var filesList = directory.listFiles()?.toList()
            return try {
                // sort list of files and folders
                if (filesList != null) {
                    for (file in filesList) {
                        // check if current file/folder is hidden
                        if (!file.isDirectory && checkFile(dataPath, file)) {
                            val fileDescription: FileDescriptionEntity = getSignatureFileDescriptionEntity(file, true)
                            // add object to array list
                            fileList.add(fileDescription)
                        }
                    }
                }
                fileList
            } catch (ex: Exception) {
                throw RuntimeException(ex.message, ex)
            }
        }

        private fun checkFile(path: String, file: File): Boolean {
            return !file.isHidden && file.toPath().toString() != path
        }

        fun getXmlFilePath(file: File): String {
            return file.absolutePath.replace(DATA_PREVIEW_FOLDER, DATA_XML_FOLDER)
                .replace(file.extension, "xml")
        }


        /**
         * Create file description
         *
         * @param file      file
         * @param withImage set image
         * @return signature file description
         * @throws IOException
         */
        @Throws(IOException::class)
        private fun getSignatureFileDescriptionEntity(file: File, withImage: Boolean): FileDescriptionEntity {
            var imageBytesString = ""
            if (withImage) {
                // get image Base64 encoded String
                val fileInputStreamReader = FileInputStream(file)
                imageBytesString = getStringFromStream(fileInputStreamReader)
            }

            return FileDescriptionEntity(
                guid = file.absolutePath,
                name = file.name,
                 //set is directory true/false
                directory = file.isDirectory,
                 //set file size
                size = file.length(),
                image = imageBytesString
            )



        }

        /**
         * Read stream and convert to string
         *
         * @param inputStream
         * @return
         * @throws IOException
         */
        @Throws(IOException::class)
        fun getStringFromStream(inputStream: InputStream): String {
            val outputStream = ByteArrayOutputStream()
            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
            val byteArray = outputStream.toByteArray()
            // encode ByteArray into String
            return Base64.getEncoder().encodeToString(byteArray)
        }
    }
}