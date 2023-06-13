package common.dataProviders;

import common.objectValue.FailLoginData;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

import static common.configs.InventoryPageConfig.*;
import static common.configs.LoginPageConfig.*;

public class DataProviders {

    @DataProvider(name="FailLoginData")
    public Iterator<Object[]> getFailLoginEmptyPassword(){

        var emptyLoginEmptyPassword = FailLoginData.builder()
                .login("")
                .password("")
                .error_message(EMPTY_LOGIN_ERROR_TEXT)
                .build();

        var emptyLoginWithPassword = FailLoginData.builder()
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

    @DataProvider(name="previewItemCard")
    public Object[][] checkPreviewItem(){
        return new Object[][]{{previewItem1}, {previewItem2}, {previewItem3}, {previewItem4}, {previewItem5}, {previewItem6}};
    }
}
