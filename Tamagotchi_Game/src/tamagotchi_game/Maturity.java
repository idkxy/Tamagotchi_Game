/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;

import java.util.Date;

/**
 *
 * @author daisyxiao
 */
public class Maturity {
    
    private final Pet pet;
    private Date currentTime;
    private long createdFor;
    private long dInSec;
    private long dInMin;
    private long dInHr;
    private long dInDay;
    
    public Maturity(Pet pet)
    {
        this.pet = pet;
    }
    
    public void computeTimeDifference()
    {
       this.createdFor =  currentTime.getTime() - pet.getCreated().getTime();
       this.dInSec = (createdFor / 1000) % 60;
       this.dInMin = (createdFor / (100 * 60)) % 60;
       this.dInHr = (createdFor / (100 * 60 * 60)) % 24;
       this.dInDay = (createdFor / (100 * 60 * 60 * 24)) % 365;
    }
    
    public void maturityCheck()
    {
        if(this.dInDay >= 3)
        {
            pet.setMaturity(true);
        }
        else
        {
            pet.setMaturity(false);
        }
    }
  
    public String toString()
    {
        return ("The pet has been created for: " + this.dInDay + this.dInHr + this.dInMin + this.dInSec);
    }
    
    
}
