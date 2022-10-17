/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thanh_Tam
 */
@Entity
@Table(name = "unit")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
        @NamedQuery(name = "Unit.findById", query = "SELECT u FROM Unit u WHERE u.id = :id"),
        @NamedQuery(name = "Unit.findByUnitName", query = "SELECT u FROM Unit u WHERE u.unitName = :unitName")})
public class Unit implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id")
        private Integer id;
        
        @Size(max = 45)
        @Column(name = "unit_name")
        private String unitName;
        
        @JsonIgnore
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId", fetch = FetchType.LAZY)
        private Set<Medicine> medicineSet;

        public Unit() {
        }

        public Unit(Integer id) {
                this.id = id;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getUnitName() {
                return unitName;
        }

        public void setUnitName(String unitName) {
                this.unitName = unitName;
        }

        @XmlTransient
        public Set<Medicine> getMedicineSet() {
                return medicineSet;
        }

        public void setMedicineSet(Set<Medicine> medicineSet) {
                this.medicineSet = medicineSet;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (id != null ? id.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof Unit)) {
                        return false;
                }
                Unit other = (Unit) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.dev.pojo.Unit[ id=" + id + " ]";
        }
        
}
