package com.blogs.enums;

public enum Category {
    SCIENCE_AND_TECHNOLOGY("Science & Technology"),
    SPORTS("Sports"),
    NEWS("News"),
    HUMANITIES("Humanities"),
    FINANCE("Finance");

    private final String displayName;

    // Constructor to set the display name
    Category(String displayName) {
        this.displayName = displayName;
    }

    // Getter to access the display name
    public String getDisplayName() {
        return displayName;
    }
}
