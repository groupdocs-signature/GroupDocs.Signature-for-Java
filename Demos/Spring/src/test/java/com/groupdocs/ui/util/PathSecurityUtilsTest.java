package com.groupdocs.ui.util;

import com.groupdocs.ui.exception.TotalGroupDocsException;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PathSecurityUtilsTest {

    @Test
    public void resolveInsideBaseDirectory_allowsRelativeFile() throws Exception {
        Path base = Files.createTempDirectory("gd-signature-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "sample.docx");
            assertEquals(base.resolve("sample.docx").normalize(), resolved);
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test
    public void resolveInsideBaseDirectory_allowsNestedRelativeFile() throws Exception {
        Path base = Files.createTempDirectory("gd-signature-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "folder/sample.pdf");
            assertEquals(base.resolve("folder/sample.pdf").normalize(), resolved);
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test
    public void resolveInsideBaseDirectoryOrRoot_allowsRootListing() throws Exception {
        Path base = Files.createTempDirectory("gd-signature-base").toAbsolutePath();
        try {
            Path resolved = PathSecurityUtils.resolveInsideBaseDirectoryOrRoot(base.toString(), "");
            assertEquals(base.normalize(), resolved);
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test
    public void resolveInsideBaseDirectory_rejectsPathTraversal() throws Exception {
        Path base = Files.createTempDirectory("gd-signature-base").toAbsolutePath();
        try {
            assertThrows(TotalGroupDocsException.class, () ->
                    PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "../../../etc/passwd"));
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test
    public void resolveInsideBaseDirectory_rejectsAbsolutePath() throws Exception {
        Path base = Files.createTempDirectory("gd-signature-base").toAbsolutePath();
        try {
            assertThrows(TotalGroupDocsException.class, () ->
                    PathSecurityUtils.resolveInsideBaseDirectory(base.toString(), "/etc/passwd"));
        } finally {
            Files.deleteIfExists(base);
        }
    }

    @Test
    public void resolveInsideBaseDirectory_rejectsFileUri() {
        assertThrows(TotalGroupDocsException.class, () ->
                PathSecurityUtils.resolveInsideBaseDirectory("/home/groupdocs/app/DocumentSamples", "file:///etc/passwd"));
    }

    @Test
    public void sanitizeFileName_stripsDirectorySegments() {
        assertEquals("passwd", PathSecurityUtils.sanitizeFileName("../../etc/passwd"));
    }

    @Test
    public void sanitizeFileName_rejectsParentDirectoryName() {
        assertThrows(TotalGroupDocsException.class, () -> PathSecurityUtils.sanitizeFileName(".."));
    }
}
