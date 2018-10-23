
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author heath
 */
public class MainApp {
    public static void main(String[] args) {
        
//        UserIO myIo = new UserIOConsoleImpl();
//        DVDView myView = new DVDView(myIo);
//        
//        DVDdao myDao = new DVDdaoImpl();
//        DVDController controller = 
//                new DVDController(myDao, myView);
//        controller.run();

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        DVDController controller =
                ctx.getBean("controller", DVDController.class);
        controller.run();
        
        
    }
    
}
