
import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.sg.vendingmachine.service.InsuffecientFundsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author heath
 */
public class MainApp {

    public static void main(String[] args) throws VendingMachineDaoPersistenceException, 
            InsuffecientFundsException {

        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = 
                ctx.getBean("controller", VendingMachineController.class);
        controller.run();

    }

}
