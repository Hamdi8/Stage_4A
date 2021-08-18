// copyright www.codejava.net
package net.codejava;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

 @Table (name= "Product" )
//@EntityListeners(AuditingEntityListener.class)
public class Product  implements Serializable {
	
	private static final long SerialVersionUID = 1L; 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int prix;
    private int prixAchat;
 
   
    public Product(String nom, int prix, int prixAchat) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}


	
    public Long getId() {
        return id;
    }
    @Column(name = "Nom", nullable = false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	 @Column(name = "Prix", nullable = false)
	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	@Column(name = "PrixAchat", nullable = false)
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

	public void setId(Long id) {
		this.id = id;
	}


    // other getters and setters are hidden for brevity
}