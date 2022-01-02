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
public class DiscountBirthdate extends DiscountDecorator{
    
    public DiscountBirthdate(Discount decoratedDiscount) {
        super(decoratedDiscount);
    }
    @Override
    public double discount(){
     System.out.println("price of trip after discount for your birthday is ");
      return (0.1-decoratedDiscount.discount());
    }
    
}
