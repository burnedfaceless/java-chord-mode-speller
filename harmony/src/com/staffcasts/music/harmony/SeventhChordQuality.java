package com.staffcasts.music.harmony;

public enum SeventhChordQuality {
    MAJORSEVENTH,
    DOMINANTSEVENTH,
    MINORSEVENTH,
    DIMINISHEDSEVENTH,
    MINORSEVENFLATFIVE;

    @Override
    public String toString() {
        return switch (this) {
            case MAJORSEVENTH -> "Major Seventh";
            case DOMINANTSEVENTH -> "Dominant Seventh";
            case MINORSEVENTH -> "Minor Seventh";
            case DIMINISHEDSEVENTH -> "Diminished Seventh";
            case MINORSEVENFLATFIVE -> "Minor Seven Flat Five";
        };
    }
}
