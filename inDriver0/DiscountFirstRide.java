/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inDriver0;

/**
 *
 * @author Lap Smart
 */
public class DiscountFirstRide extends DiscountDecorator{
    
    public DiscountFirstRide(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }
    @Override
    public double discount(){
     System.out.println("price of trip after discount on first ride is ");
      return (0.1-decoratedDiscount.discount());
    }
 
}
