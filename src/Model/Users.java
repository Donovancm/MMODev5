/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Donovan
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByBalance", query = "SELECT u FROM Users u WHERE u.balance = :balance"),
    @NamedQuery(name = "Users.findByBanned", query = "SELECT u FROM Users u WHERE u.banned = :banned"),
    @NamedQuery(name = "Users.findByCharacterSlots", query = "SELECT u FROM Users u WHERE u.characterSlots = :characterSlots"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByIban", query = "SELECT u FROM Users u WHERE u.iban = :iban"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByLastPayment", query = "SELECT u FROM Users u WHERE u.lastPayment = :lastPayment"),
    @NamedQuery(name = "Users.findByMonthsPayed", query = "SELECT u FROM Users u WHERE u.monthsPayed = :monthsPayed"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "banned")
    private String banned;
    @Basic(optional = false)
    @Column(name = "character_slots")
    private int characterSlots;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "iban")
    private String iban;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "last_payment")
    @Temporal(TemporalType.DATE)
    private Date lastPayment;
    @Basic(optional = false)
    @Column(name = "months_payed")
    private int monthsPayed;
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Servers> serversCollection;
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Characters> charactersCollection;

    public Users() {
    }

    public Users(String userName) {
        this.userName = userName;
    }

    public Users(String userName, int characterSlots, int monthsPayed) {
        this.userName = userName;
        this.characterSlots = characterSlots;
        this.monthsPayed = monthsPayed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public int getCharacterSlots() {
        return characterSlots;
    }

    public void setCharacterSlots(int characterSlots) {
        this.characterSlots = characterSlots;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(Date lastPayment) {
        this.lastPayment = lastPayment;
    }

    public int getMonthsPayed() {
        return monthsPayed;
    }

    public void setMonthsPayed(int monthsPayed) {
        this.monthsPayed = monthsPayed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Servers> getServersCollection() {
        return serversCollection;
    }

    public void setServersCollection(Collection<Servers> serversCollection) {
        this.serversCollection = serversCollection;
    }

    @XmlTransient
    public Collection<Characters> getCharactersCollection() {
        return charactersCollection;
    }

    public void setCharactersCollection(Collection<Characters> charactersCollection) {
        this.charactersCollection = charactersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Users[ userName=" + userName + " ]";
    }
    
}
