
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class DVDdaoImpl implements DVDdao {

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> movie = new HashMap<>();
            
    @Override
    public List<DVD> getAllDVD() throws DVDDaoException {
        loadDVD();
        return new ArrayList<DVD>(movie.values());
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDDaoException {
        DVD newDVD = movie.put(title, dvd);
        writeDVD();
        return newDVD;
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoException {
        loadDVD();
        return movie.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoException {
        DVD removedMovie = movie.remove(title);
        writeDVD();
        return removedMovie;
    }

    private void loadDVD() throws DVDDaoException {
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(
                    new FileReader(DVD_FILE)));
        } catch (FileNotFoundException ex) {
            throw new DVDDaoException(
                    "-_- Could not load DVD data into memory.", ex);
        }

        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);

            currentDVD.setReleaseDate(currentTokens[1]);
            currentDVD.setMpaaRating(currentTokens[2]);
            currentDVD.setDirectorName(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            currentDVD.setExtraNotes(currentTokens[5]);

            movie.put(currentDVD.getTitle(), currentDVD);
        }
        sc.close();
    }

    private void writeDVD() throws DVDDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException ex) {
            throw new DVDDaoException("Could not save DVD data.", ex);
        }

        List<DVD> dvdList = this.getAllDVD();

        for (DVD currentDVD : dvdList) {
            out.println(currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseDate() + DELIMITER
                    + currentDVD.getMpaaRating() + DELIMITER
                    + currentDVD.getDirectorName() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getExtraNotes());
            out.flush();
        }
        out.close();
    }

}
