package com.sigsauer.asker.biz.shared;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @deprecated
 */
public class ApiFile {

    private String filename;
    private String directory;
    private FileType type;

    public ApiFile(String filename, String directory, FileType type) {
        this.filename = filename;
        this.directory = directory;
        this.type = type;
    }

    public ApiFile(String path, String type) {
        Path filepath = Paths.get(path);
        this.filename = filepath.getFileName().toString();
        this.directory = filepath.toFile().getPath().substring(0, filepath.toFile().getPath().indexOf(this.filename));
        this.type = FileType.valueOf(this.filename.substring(this.filename.indexOf('.')));
    }

    public ApiFile() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApiFile{" +
                "filename='" + filename + '\'' +
                ", directory='" + directory + '\'' +
                ", type=" + type +
                '}';
    }
}
