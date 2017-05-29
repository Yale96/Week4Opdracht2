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
@PrimaryKeyJoinColumn(name = "parent_id", referencedColumnName = "id")
public class Painting extends Item implements Serializable{
    
    @PrimaryKeyJoinColumn(name = "parent_id", referencedColumnName = "id")
    private String title;
    private String painter;
    
    public Painting(String title, String painter, User seller, Category category, String description)
    {
        super(seller, category, description);
        this.title = title;
        this.painter = painter;
    }
    
    public Painting()
    {
        
    }
    
    public String getTitle() {
        return title;
    }

    public String getPainter() {
        return painter;
    }
}
