package com.staffcasts.harmony;

public class Triad {
    private String root;
    private String third;
    private String fifth;
    private TriadQuality triadQuality;

    public Triad() {
        this("C", TriadQuality.MAJOR);
    }

    public Triad(String root, TriadQuality quality) {
        setRoot(root);
        setTriadQuality(quality);
        setThird();
        setFifth();
    }

    protected void setRoot(String root) {
        this.root = root;
    }

    protected void setThird() {
        this.third = switch (triadQuality) {
            case MAJOR, AUGMENTED -> calculateMajorThird(root);
            case MINOR, DIMINISHED -> calculateMinorThird(root);
        };
    }

    protected void setFifth() {
        this.fifth = switch (triadQuality) {
            case MAJOR, DIMINISHED -> calculateMinorThird(this.third);
            case MINOR, AUGMENTED -> calculateMajorThird(this.third);
        };
    }

    public String getChord() {
        return this.getRoot() + " " + this.getThird() + " " + this.getFifth();
    }

    public void setTriadQuality(TriadQuality quality) {
        this.triadQuality = quality;
    }

    public String getRoot() {
        return this.root;
    }

    public String getThird() {
        return this.third;
    }

    public String getFifth() {
        return this.fifth;
    }

    protected String calculateMajorThird(String note) {
        return switch (note) {
            case "C" -> "E";
            case "C#" -> "E#";
            case "Db" -> "F";
            case "C##" -> "E##";
            case "Dbb" -> "Fb";
            case "D" -> "F#";
            case "D#" -> "F##";
            case "Eb" -> "G";
            case "D##" -> "G";
            case "Ebb" -> "Gb";
            case "E" -> "G#";
            case "E#" -> "G##";
            case "Fb" -> "Ab";
            case "E##" -> "G###";
            case "F" -> "A";
            case "F#" -> "A#";
            case "Gb" -> "Bb";
            case "F##" -> "A##";
            case "Gbb" -> "Bbb";
            case "G" -> "B";
            case "G#" -> "B#";
            case "Ab" -> "C";
            case "G##" -> "B##";
            case "Abb" -> "Cb";
            case "A" -> "C#";
            case "A#" -> "C##";
            case "Bb" -> "D";
            case "A##" -> "C###";
            case "Bbb" -> "Db";
            case "B" -> "D#";
            case "B#" -> "D##";
            case "Cb" -> "Eb";
            case "B##" -> "D###";
            default -> throw new IllegalArgumentException("Invalid note: " + note);
        };
    }

    protected String calculateMinorThird(String note) {
        return switch (note) {
            case "C" -> "Eb";
            case "C#" -> "E";
            case "Db" -> "Fb";
            case "C##" -> "E#";
            case "Dbb" -> "Fbb";
            case "D" -> "F";
            case "D#" -> "F#";
            case "Eb" -> "Gb";
            case "D##" -> "F##";
            case "Ebb" -> "Gbb";
            case "E" -> "G";
            case "E#" -> "G#";
            case "Fb" -> "Abb";
            case "E##" -> "G##";
            case "F" -> "Ab";
            case "F#" -> "A";
            case "Gb" -> "Bbb";
            case "F##" -> "A#";
            case "Gbb" -> "Bbbb";
            case "G" -> "Bb";
            case "G#" -> "B";
            case "Ab" -> "Cb";
            case "G##" -> "B#";
            case "Abb" -> "Cbb";
            case "A" -> "C";
            case "A#" -> "C#";
            case "Bb" -> "Db";
            case "A##" -> "C##";
            case "Bbb" -> "Dbb";
            case "B" -> "D";
            case "B#" -> "D#";
            case "Cb" -> "Ebb";
            case "B##" -> "D##";
            default -> throw new IllegalArgumentException("Invalid note: " + note);
        };
    }

}