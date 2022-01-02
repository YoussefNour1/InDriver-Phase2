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
public class DiscountMorePassenger extends DiscountDecorator{
    
    public DiscountMorePassenger(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }
    @Override
    public double discount(){
     System.out.println("price of trip after discount for more than passenger in the trip is ");
      return (0.05-decoratedDiscount.discount());
    }
    
}
