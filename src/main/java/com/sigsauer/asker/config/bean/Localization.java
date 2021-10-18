package com.sigsauer.asker.config.bean;

public enum Localization {

    EN("en.loc"),
    ;

    private final String bundles;

    Localization(String bundles) {
        this.bundles = bundles;
    }

    public String getBundles() {
        return bundles;
    }
}
