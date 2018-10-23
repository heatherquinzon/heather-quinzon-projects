
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author heath
 */
public interface DVDdao {
    
    List<DVD> getAllDVD() throws DVDDaoException;
           
    DVD addDVD(String title, DVD dvd) throws DVDDaoException;
   
    DVD getDVD(String title) throws DVDDaoException;
    
    DVD removeDVD(String movie) throws DVDDaoException;
           
}
