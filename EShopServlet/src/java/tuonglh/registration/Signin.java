/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Signin", catalog = "Sinhvien", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Signin.findAll", query = "SELECT s FROM Signin s"),
    @NamedQuery(name = "Signin.findByPhoneNumber", query = "SELECT s FROM Signin s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Signin.findByPassword", query = "SELECT s FROM Signin s WHERE s.password = :password"),
    @NamedQuery(name = "Signin.findByRole", query = "SELECT s FROM Signin s WHERE s.role = :role"),
    @NamedQuery(name = "Signin.findByName", query = "SELECT s FROM Signin s WHERE s.name = :name")})
public class Signin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "phoneNumber", nullable = false, length = 15)
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 15)
    private String password;
    @Basic(optional = false)
    @Column(name = "role", nullable = false)
    private boolean role;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public Signin() {
    }

    public Signin(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Signin(String phoneNumber, String password, boolean role, String name) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Signin)) {
            return false;
        }
        Signin other = (Signin) object;
        if ((this.phoneNumber == null && other.phoneNumber != null) || (this.phoneNumber != null && !this.phoneNumber.equals(other.phoneNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tuonglh.registration.Signin[ phoneNumber=" + phoneNumber + " ]";
    }
    
}
