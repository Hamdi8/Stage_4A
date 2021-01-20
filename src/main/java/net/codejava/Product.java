// copyright www.codejava.net
package net.codejava;
 
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/*
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
*/
/*
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
*/
@Entity 
 @Table (name= "product" )
//@EntityListeners(AuditingEntityListener.class)
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private int prix;
    private int prixAchat;
 
    public Product(String nom, int prix, int prixAchat) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}

	protected Product() {
    }
  
    public Product(int id, String nom, int prix, int prixAchat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}
	
    public int getId() {
        return id;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + ", prixAchat=" + prixAchat + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
     
    // other getters and setters are hidden for brevity
}