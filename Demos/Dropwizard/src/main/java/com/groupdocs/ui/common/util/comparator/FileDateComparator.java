package com.groupdocs.ui.common.util.comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

public class FileDateComparator implements Comparator<File> {
    private static final Logger logger = LoggerFactory.getLogger(FileDateComparator.class);

    public static FileDateComparator instance = new FileDateComparator();

    /**
     * Compare two file names
     *
     * @param file1
     * @param file2
     * @return int
     */
    @Override
    public int compare(File file1, File file2) {

        try {
            BasicFileAttributes attr1 = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
            BasicFileAttributes attr2 = Files.readAttributes(file2.toPath(), BasicFileAttributes.class);
            return attr1.creationTime().compareTo(attr2.creationTime());
        } catch (IOException e) {
            logger.error("Error comparing files by creation date");
        }
        return 0;
    }
}
