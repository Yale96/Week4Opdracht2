/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author yanni
 */
@Entity
public class Furniture extends Item implements Serializable{
    private String material;
    
    public Furniture(User seller, Category category, String description, String material)
    {
        super(seller, category, description);
        this.material = material;
    }
    
    public Furniture()
    {
        
    }
}
