package com.staffcasts.harmony;

public class SeventhChord extends Triad{
    private String seventh;
    private SeventhChordQuality seventhChordQuality;

    public SeventhChord() {
        this("C", SeventhChordQuality.MAJORSEVENTH);
    }

    public SeventhChord(String root, SeventhChordQuality seventhChordQuality) {
        super(root, SeventhChord.determineTriadQuality(seventhChordQuality));
        setSeventhChordQuality(seventhChordQuality);
        setSeventh();
    }

    protected void setSeventh() {
        this.seventh = switch (seventhChordQuality) {
            case MAJORSEVENTH -> calculateMajorThird(this.getFifth());
            case DOMINANTSEVENTH, DIMINISHEDSEVENTH, MINORSEVENFLATFIVE, MINORSEVENTH -> calculateMinorThird(getFifth());
        };
    }

    @Override
    public String getChord() {
        return super.getChord() + " " + this.getSeventh();
    }


    protected void setSeventhChordQuality(SeventhChordQuality seventhChordQuality) {
        this.seventhChordQuality = seventhChordQuality;
    }

    private static TriadQuality determineTriadQuality(SeventhChordQuality seventhChordQuality) {
        return switch (seventhChordQuality) {
            case MAJORSEVENTH, DOMINANTSEVENTH -> TriadQuality.MAJOR;
            case MINORSEVENTH -> TriadQuality.MINOR;
            case MINORSEVENFLATFIVE, DIMINISHEDSEVENTH -> TriadQuality.DIMINISHED;
        };
    }

    public String getSeventh() {
        return this.seventh;
    }

}