/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tuonglh.registration;

import java.util.List;

/**
 *
 * @author USER
 */
public interface SigninBLI {
    Signin checkLogin(String phoneNumber, String password);
    List<Signin> searchLastName(String searchValue);
    boolean deleteValue(String phoneNumber);
    boolean updateAccount(String phone, String password, boolean role);
    boolean createAccount(Signin accounts);
}
