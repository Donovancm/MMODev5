/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Donovan
 */
@Entity
@Table(name = "servers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servers.findAll", query = "SELECT s FROM Servers s"),
    @NamedQuery(name = "Servers.findByAddress", query = "SELECT s FROM Servers s WHERE s.address = :address"),
    @NamedQuery(name = "Servers.findByConnectedUsers", query = "SELECT s FROM Servers s WHERE s.connectedUsers = :connectedUsers"),
    @NamedQuery(name = "Servers.findByLocation", query = "SELECT s FROM Servers s WHERE s.location = :location"),
    @NamedQuery(name = "Servers.findByMaxUsers", query = "SELECT s FROM Servers s WHERE s.maxUsers = :maxUsers"),
    @NamedQuery(name = "Servers.findByName", query = "SELECT s FROM Servers s WHERE s.name = :name")})
public class Servers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "connected_users")
    private int connectedUsers;
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "max_users")
    private int maxUsers;
    @Column(name = "name")
    private String name;
    @JoinTable(name = "stores", joinColumns = {
        @JoinColumn(name = "address", referencedColumnName = "address")}, inverseJoinColumns = {
        @JoinColumn(name = "user_name", referencedColumnName = "user_name")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public Servers() {
    }

    public Servers(String address) {
        this.address = address;
    }

    public Servers(String address, int connectedUsers, int maxUsers) {
        this.address = address;
        this.connectedUsers = connectedUsers;
        this.maxUsers = maxUsers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getConnectedUsers() {
        return connectedUsers;
    }

    public void setConnectedUsers(int connectedUsers) {
        this.connectedUsers = connectedUsers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (address != null ? address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servers)) {
            return false;
        }
        Servers other = (Servers) object;
        if ((this.address == null && other.address != null) || (this.address != null && !this.address.equals(other.address))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Servers[ address=" + address + " ]";
    }
    
}