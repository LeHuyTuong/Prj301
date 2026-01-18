/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.utils;

/**
 *
 * @author USER
 */
public class MyApplicationConstants {

    public class DispatchFeature {

        public static final String LOGIN_PAGE = "";
        public static final String LOGIN_CONTROLLER = "loginController";
        public static final String LOGOUT_CONTROLLER = "logoutController";
        public static final String SEARCH_CONTROLLER = "searchController";
        public static final String CREATE_CONTROLLER = "createController";
        public static final String UPDATE_CONTROLLER = "updateController";
        public static final String DELETE_CONTROLLER = "deleteController";
        public static final String CHECK_CONTROLLER = "checkController";

    }

    public class LoginFeature {

        public static final String SEARCH_PAGE = "searchPage";  // moi nguoi dung laf username khac nhau nen phai la trang dong 
        public static final String INVALID_PAGE = "invalidPage";
    }

    public class LogoutFeature {

        public static final String LOGIN_PAGE = "";
    }

    public class SearchFeature {

        public static final String SEARCH_PAGE = "searchPage";
        public static final String INVALID_PAGE = "searchPage";
    }

    public class DeleteFeature {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class UpdateFeature {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class CheckFeature {

        public static final String LOGIN_PAGES = "";
        public static final String SEARCH_PAGES = "searchPage";
    }

    public class CreateFeature {

        public static final String USERNAME_LEN_ERR = "usernameError";
        public static final String PASSWORD_LEN_ERR = "passwordErr";
        public static final String CONFIRM_ERR = "confirmErr";
        public static final String FULLNAME_LEN_ERR = "fullName";

        public static final String ERROR_PAGES = "createAccountErrPage";
        public static final String LOGIN_PAGES = "";
    }
}
