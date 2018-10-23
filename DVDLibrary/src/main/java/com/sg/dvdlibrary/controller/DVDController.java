
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDDaoException;
import com.sg.dvdlibrary.dao.DVDdao;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.view.DVDView;
import java.util.List;

/**
 *
 * @author heath
 */
public class DVDController {

    DVDView view;
    DVDdao dao;

    public DVDController(DVDdao dao, DVDView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean repeat = true;
        int choice = 0;

        try{
        while (repeat) {

            choice = getMenuSelection();

            switch (choice) {
                case 1:
                    addNewDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVDInfo();
                    break;
                case 4:
                    listAllDVDs();
                    break;
                case 5:
                    dvdInfo();
                    break;
                case 6:
                    searchDVD();
                    break;
                case 7:
                    repeat = false;
                    break;
                default:
                    unknownMessage();
                    break;
            }
        }
        exitMessage();
        } catch (DVDDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addNewDVD() throws DVDDaoException{
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayNewDVDSucessBanner();
    }

    private void listAllDVDs() throws DVDDaoException{
        List<DVD> dvdList = dao.getAllDVD();
        view.displayDVDList(dvdList);
    }

    private void dvdInfo() throws DVDDaoException{
        view.displayGetDVDInfoBanner();
        String dvd = view.getDVDTitle();
        DVD newDvd = dao.getDVD(dvd);
        view.displayDVDInfo(newDvd);
    }
    
    private void editDVDInfo()throws DVDDaoException{
        view.displayEditBanner();
        String dvd = view.getEditDVDTitle();
        DVD newDvd = dao.getDVD(dvd);
        view.editDVDInfo(newDvd);
        dao.addDVD(dvd, newDvd);
    }
    

    private void removeDVD() throws DVDDaoException{
        view.displayRemovedBanner();
        String dvd = view.getRemovedTitle();
        dao.removeDVD(dvd);
        view.displayRemovedSuccesful();
    }
    
    private void searchDVD()throws DVDDaoException{
        view.displaySearchBanner();
        String movie = view.getSearchDVDTitle();
        DVD dvd = dao.getDVD(movie);
        view.searchDVDTitle(dvd);
    }

    private void exitMessage() {
        view.exitBanner();
    }

    private void unknownMessage() {
        view.unknownBanner();
    }

}
