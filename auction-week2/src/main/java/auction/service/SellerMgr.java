package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import auction.domain.Category;
import auction.domain.Furniture;
import auction.domain.Item;
import auction.domain.Painting;
import auction.domain.User;
import javax.persistence.Persistence;

public class SellerMgr {

    private final ItemDAO itemDAO = new ItemDAOJPAImpl(Persistence.createEntityManagerFactory("nl.fhict.se42_auction_jar_1.0-SNAPSHOTPU").createEntityManager());
    /**
     * @param seller
     * @param cat
     * @param description
     * @return het item aangeboden door seller, behorende tot de categorie cat
     *         en met de beschrijving description
     */
//    public Item offerItem(User seller, Category cat, String description) {
//        // TODO 
//        Item toReturn = new Item(seller, cat, description);
//        seller.addItem(toReturn);
//        itemDAO.create(toReturn);
//        return toReturn;
//    }
    
     /**
     * @param item
     * @return true als er nog niet geboden is op het item. Het item word verwijderd.
     *         false als er al geboden was op het item.
     */
    public boolean revokeItem(Item item) {
        // TODO 
        if(item.getHighestBid() == null)
        {
            itemDAO.remove(item);
            return true;
        }
        else
            return false;
    }
    
    public Painting offerPainting(User user, Category category, String description, String painter, String title)
    {
        Painting p = new Painting(user, category, description, title, painter);
        itemDAO.create(p);
        user.addItemToThisUser(p);
        return p;
    }
    
    public Furniture offerFurniture(User user, Category category, String description, String material)
    {
        Furniture f = new Furniture(user, category, description, material);
        itemDAO.create(f);
        user.addItemToThisUser(f);
        return f;
    }
}
