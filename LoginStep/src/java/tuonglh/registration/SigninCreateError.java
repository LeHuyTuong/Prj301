/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class SigninCreateError implements Serializable{
    
    // co 4 loi do nguoi dung tao ra 
    private String PhoneNumberNotFormat;
    private String PasswordNotLengthErr;
    private String ConfirmNotMatch;
    private String FullNameNotLengthErr;
    private String PhoneNumberIsExist;

    public SigninCreateError() {
    }
 
    /**
     * @return the PhoneNumberNotFormat
     */
    public String getPhoneNumberNotFormat() {
        return PhoneNumberNotFormat;
    }

    /**
     * @param PhoneNumberNotFormat the PhoneNumberNotFormat to set
     */
    public void setPhoneNumberNotFormat(String PhoneNumberNotFormat) {
        this.PhoneNumberNotFormat = PhoneNumberNotFormat;
    }

    /**
     * @return the PasswordNotLengthErr
     */
    public String getPasswordNotLengthErr() {
        return PasswordNotLengthErr;
    }

    /**
     * @param PasswordNotLengthErr the PasswordNotLengthErr to set
     */
    public void setPasswordNotLengthErr(String PasswordNotLengthErr) {
        this.PasswordNotLengthErr = PasswordNotLengthErr;
    }

    /**
     * @return the ConfirmNotMatch
     */
    public String getConfirmNotMatch() {
        return ConfirmNotMatch;
    }

    /**
     * @param ConfirmNotMatch the ConfirmNotMatch to set
     */
    public void setConfirmNotMatch(String ConfirmNotMatch) {
        this.ConfirmNotMatch = ConfirmNotMatch;
    }

    /**
     * @return the FullNameNotLengthErr
     */
    public String getFullNameNotLengthErr() {
        return FullNameNotLengthErr;
    }

    /**
     * @param FullNameNotLengthErr the FullNameNotLengthErr to set
     */
    public void setFullNameNotLengthErr(String FullNameNotLengthErr) {
        this.FullNameNotLengthErr = FullNameNotLengthErr;
    }

    /**
     * @return the PhoneNumberIsExist
     */
    public String getPhoneNumberIsExist() {
        return PhoneNumberIsExist;
    }

    /**
     * @param PhoneNumberIsExist the PhoneNumberIsExist to set
     */
    public void setPhoneNumberIsExist(String PhoneNumberIsExist) {
        this.PhoneNumberIsExist = PhoneNumberIsExist;
    }
    
    
}
