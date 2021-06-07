package com.groupdocs.ui.util;

import com.google.common.collect.Lists;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.google.common.net.HttpHeaders.CONTENT_LENGTH;
import static com.google.common.net.MediaType.OCTET_STREAM;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static final FileNameComparator FILE_NAME_COMPARATOR = new FileNameComparator();
    public static final FileTypeComparator FILE_TYPE_COMPARATOR = new FileTypeComparator();

    private static final ZoneId GMT = ZoneId.of("GMT");

    /**
     * Fill header HTTP response with file data
     */
    public static void addFileDownloadHeaders(HttpServletResponse response, String fileName, Long fileLength) {
        Map<String, List<String>> fileDownloadHeaders = createFileDownloadHeaders(fileName, fileLength, OCTET_STREAM.toString());
        for (Map.Entry<String, List<String>> entry : fileDownloadHeaders.entrySet()) {
            for (String value : entry.getValue()) {
                response.addHeader(entry.getKey(), value);
            }
        }
    }

    /**
     * Set "Content-Length" header into response
     *
     * @param response http response
     * @param length   the length of file
     */
    public static void addFileDownloadLengthHeader(HttpServletResponse response, Long length) {
        if (length != null) {
            response.setHeader(CONTENT_LENGTH, Long.toString(length));
        }
    }

    /**
     * Upload the file
     *
     * @param documentStoragePath path for uploading the file
     * @param content             file data
     * @param url                 url of file
     * @param rewrite             flag of rewriting the file
     * @return path to uploaded file
     */
    public static String uploadFile(String documentStoragePath, Part content, String url, Boolean rewrite) {
        String filePath;
        try {
            String fileName;
            // save from file content
            if (StringUtils.isEmpty(url)) {
                fileName = content.getSubmittedFileName();
                try (InputStream inputStream = content.getInputStream()) {
                    filePath = uploadFileInternal(inputStream, documentStoragePath, fileName, rewrite);
                } catch (Exception ex) {
                    logger.error("Exception occurred while uploading document", ex);
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }
            } else { // save from url
                URL fileUrl = new URL(url);
                try (InputStream inputStream = fileUrl.openStream()) {
                    fileName = FilenameUtils.getName(fileUrl.getPath());
                    filePath = uploadFileInternal(inputStream, documentStoragePath, fileName, rewrite);
                } catch (Exception ex) {
                    logger.error("Exception occurred while uploading document", ex);
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }
            }
        } catch (Exception ex) {
            logger.error("Exception occurred while uploading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        return filePath;
    }

    /**
     * Upload file from input stream
     *
     * @param uploadedInputStream input stream of file
     * @param documentStoragePath path to storage
     * @param fileName            name of file
     * @param rewrite             flag for rewriting
     * @return path to file
     * @throws IOException
     */
    public static String uploadFileInternal(InputStream uploadedInputStream, String documentStoragePath, String fileName, boolean rewrite) throws IOException {
        String filePath = String.format("%s%s%s", documentStoragePath, File.separator, fileName);
        File file = new File(filePath);
        // check rewrite mode
        if (rewrite) {
            // save file with rewrite if exists
            Files.copy(uploadedInputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return filePath;
        } else {
            if (file.exists()) {
                // get file with new name
                file = getFreeFileName(documentStoragePath, fileName);
            }
            // save file without rewriting
            Path path = file.toPath();
            Files.copy(uploadedInputStream, path);
            return path.toString();
        }
    }

    /**
     * Get headers for downloading files
     */
    private static Map<String, List<String>> createFileDownloadHeaders(String fileName, Long fileLength, String mediaType) {
        Map<String, List<String>> httpHeaders = new HashMap<>();
        httpHeaders.put("Content-disposition", Lists.newArrayList("attachment; filename=" + fileName));
        httpHeaders.put("Content-Type", Lists.newArrayList(mediaType));
        httpHeaders.put("Content-Description", Lists.newArrayList("File Transfer"));
        httpHeaders.put("Content-Transfer-Encoding", Lists.newArrayList("binary"));
        httpHeaders.put("Expires", Lists.newArrayList(formatDate(0)));
        httpHeaders.put("Cache-Control", Lists.newArrayList("must-revalidate"));
        httpHeaders.put("Pragma", Lists.newArrayList("public"));
        if (fileLength != null) {
            httpHeaders.put("Content-Length", Lists.newArrayList(Long.toString(fileLength)));
        }
        return httpHeaders;
    }

    public static void setContentType(HttpServletResponse response, String mediaType) {
        response.setContentType(mediaType);
    }

    private static String formatDate(long date) {
        Instant instant = Instant.ofEpochMilli(date);
        ZonedDateTime time = ZonedDateTime.ofInstant(instant, GMT);
        return DATE_FORMATTERS[0].format(time);
    }

    /**
     * Date formats with time zone as specified in the HTTP RFC.
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-7.1.1.1">Section 7.1.1.1 of RFC 7231</a>
     */
    private static final DateTimeFormatter[] DATE_FORMATTERS = new DateTimeFormatter[] {
            DateTimeFormatter.RFC_1123_DATE_TIME,
            DateTimeFormatter.ofPattern("EEEE, dd-MMM-yy HH:mm:ss zz", Locale.US),
            DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy",Locale.US).withZone(GMT)
    };

    /**
     * Rename file if exist
     *
     * @param directory directory where files are located
     * @param fileName  file name
     * @return new file with new file name
     */
    public static File getFreeFileName(String directory, String fileName) {
        File file = null;
        try {
            File folder = new File(directory);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                int number = i + 1;
                String newFileName = FilenameUtils.removeExtension(fileName) + "-Copy(" + number + ")." + FilenameUtils.getExtension(fileName);
                file = new File(directory + File.separator + newFileName);
                if (file.exists()) {
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * FileNameComparator
     * Compare and sort file names alphabetically
     *
     * @author Aspose Pty Ltd
     */
    static class FileNameComparator implements Comparator<File> {

        /**
         * Compare two file names
         *
         * @param file1
         * @param file2
         * @return int
         */
        @Override
        public int compare(File file1, File file2) {

            return String.CASE_INSENSITIVE_ORDER.compare(file1.getName(),
                    file2.getName());
        }
    }

    /**
     * FileTypeComparator
     * Compare and sort file types - folders first
     *
     * @author Aspose Pty Ltd
     */
    static class FileTypeComparator implements Comparator<File> {

        /**
         * Compare two file types
         *
         * @param file1
         * @param file2
         * @return
         */
        @Override
        public int compare(File file1, File file2) {

            if (file1.isDirectory() && file2.isFile()) {
                return -1;
            }
            if (file1.isDirectory() && file2.isDirectory()) {
                return 0;
            }
            if (file1.isFile() && file2.isFile()) {
                return 0;
            }
            return 1;
        }
    }
}
