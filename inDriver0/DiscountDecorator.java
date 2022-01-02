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
public abstract class DiscountDecorator implements Discount {
   protected Discount decoratedDiscount;
    public   DiscountDecorator(Discount decoratedDiscount){
        this.decoratedDiscount=decoratedDiscount;
    }
   @Override
    public double discount(){
        return (decoratedDiscount.discount());
    } 
}