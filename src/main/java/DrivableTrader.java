/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

class DrivableTrader extends Trader<Drivable>{

    /**
     * Construct a DrivableTrader, giving them the
     * given inventory, wishlist, and money.
     * The inventory and wishlist will only have Drivable objects.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    List<Drivable> inventory;
    List<Drivable> wishlist;

    public DrivableTrader(int money) {
        super(money);
        this.inventory = new ArrayList<Drivable>(0);
        this.wishlist = new ArrayList<Drivable>(0);
    }

    @Override
    public int getSellingPrice(Drivable item) {
        int super_price = super.getSellingPrice(item);

        if (item instanceof  Tradable) {
            return super_price + item.getMaxSpeed();
        }
        else {
            return Tradable.MISSING_PRICE;
        }
    }

}
