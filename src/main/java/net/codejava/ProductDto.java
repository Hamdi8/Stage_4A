package net.codejava;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class ProductDto {

    private int id;
	
    private String nom;
	
    private int prix;
	
    private int prixAchat;
    
    public int getId() {
        return id;
    }
    public String getNom() {
		return nom;
	}
    
    public int getPrix() {
		return prix;
	}
    
    public int getPrixAchat() {
		return prixAchat;
	}
    public void setId(int id) {
		this.id = id;
	}
    
    public void setNom(String nom) {
		this.nom = nom;
	}

    public void setPrix(int prix) {
		this.prix = prix;
	}
    
    public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}
	
}