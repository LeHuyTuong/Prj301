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
    private String phoneNumberNotFormat;
    private String passwordNotLengthErr;
    private String confirmNotMatch;
    private String fullNameNotLengthErr;
    private String phoneNumberIsExist;

    public SigninCreateError() {
    }

    /**
     * @return the phoneNumberNotFormat
     */
    public String getPhoneNumberNotFormat() {
        return phoneNumberNotFormat;
    }

    /**
     * @param phoneNumberNotFormat the phoneNumberNotFormat to set
     */
    public void setPhoneNumberNotFormat(String phoneNumberNotFormat) {
        this.phoneNumberNotFormat = phoneNumberNotFormat;
    }

    /**
     * @return the passwordNotLengthErr
     */
    public String getPasswordNotLengthErr() {
        return passwordNotLengthErr;
    }

    /**
     * @param passwordNotLengthErr the passwordNotLengthErr to set
     */
    public void setPasswordNotLengthErr(String passwordNotLengthErr) {
        this.passwordNotLengthErr = passwordNotLengthErr;
    }

    /**
     * @return the confirmNotMatch
     */
    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    /**
     * @param confirmNotMatch the confirmNotMatch to set
     */
    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    /**
     * @return the fullNameNotLengthErr
     */
    public String getFullNameNotLengthErr() {
        return fullNameNotLengthErr;
    }

    /**
     * @param fullNameNotLengthErr the fullNameNotLengthErr to set
     */
    public void setFullNameNotLengthErr(String fullNameNotLengthErr) {
        this.fullNameNotLengthErr = fullNameNotLengthErr;
    }

    /**
     * @return the phoneNumberIsExist
     */
    public String getPhoneNumberIsExist() {
        return phoneNumberIsExist;
    }

    /**
     * @param phoneNumberIsExist the phoneNumberIsExist to set
     */
    public void setPhoneNumberIsExist(String phoneNumberIsExist) {
        this.phoneNumberIsExist = phoneNumberIsExist;
    }
 
    
    
}
