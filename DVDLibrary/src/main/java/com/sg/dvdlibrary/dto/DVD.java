
package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author heath
 */
public class DVD {

    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String extraNotes;

    public DVD() {

    }

    public DVD(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MM/dd/yyyy");
        LocalDate ld = LocalDate.parse(releaseDate, formatter);
        String formatted = ld.format(formatter);
        return formatted;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getExtraNotes() {
        return extraNotes;
    }

    public void setExtraNotes(String extraNotes) {
        this.extraNotes = extraNotes;
    }

    @Override
    public String toString(){
        return "DVD Name: " + title + " |Release Date: "
                + releaseDate + " |MPAA Rating: " +
                mpaaRating + " |Director Name: " +
                directorName + " |Studio: " + studio +
                " |Notes: " + extraNotes;
                
    }
    
}
