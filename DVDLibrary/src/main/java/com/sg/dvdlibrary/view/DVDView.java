
package com.sg.dvdlibrary.view;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author heath
 */
public class DVDView {

    private UserIO io;

    public DVDView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("===== MENU SELECTION =====");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Info");
        io.print("4. List All DVDs");
        io.print("5. Display DVD Info");
        io.print("6. Search For DVD");
        io.print("7. Exit");

        return io.readInt("Pick a selection from above :: ", 1, 7);
    }

    
    
    
    public DVD getNewDVDInfo() {
        io.print("\n=== ADDING NEW DVD ===");
        String title = io.readString("Enter DVD title: ");
        String releaseDate = io.readString("Enter DVD release date (month/day/year): ");
        String mpaaRating = io.readString("Enter MPAA Rating (G, PG, PG-13, R): ");
        String directorName = io.readString("Enter Director's name (first last): ");
        String studio = io.readString("Enter the studio: ");
        String extraNotes = io.readString("Extra Information: ");

        DVD newMovie = new DVD(title);

        newMovie.setTitle(title);
        newMovie.setReleaseDate(releaseDate);
        newMovie.setMpaaRating(mpaaRating);
        newMovie.setDirectorName(directorName);
        newMovie.setStudio(studio);
        newMovie.setExtraNotes(extraNotes);

        return newMovie;
    }
    public void displayNewDVDSucessBanner() {
        io.print("=== New DVD and DVD info succesfully created ===\n");
    }
    
    
    
    public void displayEditBanner(){
        io.print("\n=== EDIT INFO ===");
    }
    public String getEditDVDTitle(){
        return io.readString("What movie did you want to edit?: ");
    }
    public void editDVDInfo(DVD title){
        io.print("\n=== Current Info of " + title.getTitle() + ": ===");
        io.print("Realease Date: " + title.getReleaseDate());
        io.print("MPAA Rating: " + title.getMpaaRating());
        io.print("Director Name: " + title.getDirectorName());
        io.print("Studio: "+ title.getStudio());
        io.print("Extra Notes: " + title.getExtraNotes());
        
        boolean editMore = true;
        
        while(editMore){
        io.print("\nWhat did you want to edit? ");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director Name");
        io.print("5. Studio");
        io.print("6. Extra Notes");
        io.print("7. Nothing");
        int choice = io.readInt("Please pick from above: ", 1, 7);
        
        switch(choice){
            case 1:
                io.print("\n=== Changing Title ===");
                String newTitle = io.readString("New Title: ");
                title.setTitle(newTitle);
                break;
            case 2:
                io.print("\n=== Changing Release Date ===");
                String newDate = io.readString("New Date: ");
                title.setReleaseDate(newDate);
                break;
            case 3:
                io.print("\n=== Changing MPAA Rating ===");
                String newRating = io.readString("New Rating: ");
                title.setMpaaRating(newRating);
                break;
            case 4:
                io.print("\n=== Changing Director's Name ===");
                String newDirectorName = io.readString("New Director Name: ");
                title.setDirectorName(newDirectorName);
                break;
            case 5:
                io.print("\n=== Changing Studio ===");
                String newStudio = io.readString("New Studio: ");
                title.setStudio(newStudio);
                break;
            case 6:
                io.print("\n=== Changing Extra Notes ===");
                String newNotes = io.readString("New Notes: ");
                title.setExtraNotes(newNotes);
                break;
            case 7:
                editMore = false;
                break;
            default:
                io.print("Invalid choice");
                break;
                
        }
        }
        
        io.print("\n=== EDITED INFO ===");
        io.print("Title: " + title.getTitle());
        io.print("Realease Date: " + title.getReleaseDate());
        io.print("MPAA Rating: " + title.getMpaaRating());
        io.print("Director Name: " + title.getDirectorName());
        io.print("Studio: "+ title.getStudio());
        io.print("Extra Notes: " + title.getExtraNotes());
        io.print("");
        
    }
    
    
    public void displaySearchBanner(){
        io.print("\n=== MOVIE SEARCH ===");
    }
    public String getSearchDVDTitle(){
        return io.readString("Movie To Search For: ");
    }
    public void searchDVDTitle(DVD title){
        if (title != null){
            io.print(title.getTitle() + " found!\n");
        } else {
            io.print("No Title exist in the Library.\n");
        }
     }

    
    
    
    
    public void displayDVDList(List<DVD> dvdList) {
        io.print("\n=== LISTING ALL DVDs ===");
        if (dvdList != null) {
            for (DVD thisDVD : dvdList) {
                io.print(thisDVD.getTitle());
            }
        } else {
            io.print("There are currently no movies inside the library.");
        }
        io.print("");
    }

    
    
    
    public void displayGetDVDInfoBanner() {
        io.print("\n=== DISPLAYING MOVIE INFO ===");
    }
    public String getDVDTitle() {
        return io.readString("Enter movie title for movie details: ");
    }
    public void displayDVDInfo(DVD dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("Rated: " + dvd.getMpaaRating());
            io.print("Directed By: " + dvd.getDirectorName());
            io.print("Studio: " + dvd.getStudio());
            io.print("Extra Notes: " + dvd.getExtraNotes());
        } else {
            io.print("NO MOVIE FOUND");
        }
        io.readString("Press enter to continue");
    }

    
    
    
    public void displayRemovedBanner() {
        io.print("\n=== REMOVE MOVIE ===");
    }
    public String getRemovedTitle(){
        return io.readString("Enter movie you wish to remove from library: ");
    }
    public void displayRemovedSuccesful() {
        io.print("=== Movie succesfully removed from library. ===\n");
    }

    
    
    
    public void exitBanner(){
        io.print("THANK YOU");
    }
    
    public void unknownBanner(){
        io.print("UNKNOWN COMMAND");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
        
}
