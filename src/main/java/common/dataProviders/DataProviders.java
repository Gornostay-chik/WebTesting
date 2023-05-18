package common.dataProviders;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

import static common.configPages.ConfigInventoryPage.*;
import static common.configPages.ConfigLoginPage.*;

public class DataProviders {

    @DataProvider(name="FailLoginData")
    public Iterator<Object[]> getFailLoginEmptyPassword(){

        var emptyLoginEmptyPassword = new FailLoginData().builder()
                .login("")
                .password("")
                .error_message(EMPTY_LOGIN_ERROR_TEXT)
                .build();

        var emptyLoginWithPassword = new FailLoginData().builder()
                .login("")
                .password(ALL_USERS_PASSWORD)
                .error_message(EMPTY_LOGIN_ERROR_TEXT)
                .build();
/*
        var emptyPasswordStandartUser = new FailLoginData().builder()
                .login(STANDART_USER_LOGIN)
                .password("")
                .error_message(EMPTY_PASSWORD_ERROR_TEXT)
                .build();

        var emptyPasswordLockedUser = new FailLoginData().builder()
                .login(LOCKED_OUT_USER)
                .password("")
                .error_message(EMPTY_PASSWORD_ERROR_TEXT)
                .build();

        var emptyPasswordNotExistsUser = new FailLoginData().builder()
                .login(NOT_EXISTS_USER)
                .password("")
                .error_message(EMPTY_PASSWORD_ERROR_TEXT)
                .build();
*/
        List<Object[]> listUsersEmptyPassword = List.of(new FailLoginData[]{emptyLoginEmptyPassword},
                new FailLoginData[]{emptyLoginWithPassword});

        return listUsersEmptyPassword.iterator();
    }

    @DataProvider(name="sortByName")
    public Object[][] sortByName(){
        //return new Object[][]{{DEFAULT_SORT}, {SORT_Z_A}, {SORT_PRICE_LOW_HIGH}, {SORT_PRICE_HIGH_LOW}};
        return new Object[][]{{DEFAULT_SORT}};
    }
}
