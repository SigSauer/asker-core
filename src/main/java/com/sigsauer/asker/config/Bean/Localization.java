package com.sigsauer.asker.config.Bean;

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
