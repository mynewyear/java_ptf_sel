package selenium.tests;

import org.junit.Test;
import selenium.models.AccountCreationData;

public class CreateCustomerAccountTest extends TestBaseCustomer{

    @Test
    public void createCustomerAccount(){
        long i =System.currentTimeMillis();
        String email = "test" + i + "@ya.ru";
        String password = "secret";


        app.goTo().customerMainPage();
        app.getAccountCreationHelper().clickCreateNewAccount();
       app.getAccountCreationHelper().createAccount(
               "Nata",
               "Ya",
                "1 street",
               "123456",
               "Moscow",
               "Russian Federation",
                email,
               "1234567899",
               password);

        app.getAccountCreationHelper().logout();
        app.getAccountCreationHelper().loginToLiteCart(email, password);
        app.getAccountCreationHelper().logout();

    }
}
