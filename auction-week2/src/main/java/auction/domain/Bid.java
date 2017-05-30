package auction.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

@Entity
public class Bid {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private FontysTime time;
    
    @OneToOne
    private User buyer;
    
    private Money amount;
    
    @OneToOne
    private Item bettedItem;

    public Item getItem() {
        return bettedItem;
    }

    public void setItem(Item item) {
        this.bettedItem = item;
    }

    public Bid(User buyer, Money amount) {
        this.buyer = buyer;
        this.amount = amount;
        time = FontysTime.now();
    }
    
    public Bid(){
        
    }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getAmount() {
        return amount;
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
}
