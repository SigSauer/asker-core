package com.sigsauer.asker.biz.shared;

/**
 * @deprecated
 */
public enum FileType {

    LOCALIZATION(".loc"),
    IMAGE(".jpg");

    String ectension;

    FileType(String extension) {
        this.ectension = extension;
    }

    public String getEctension() {
        return ectension;
    }

}
