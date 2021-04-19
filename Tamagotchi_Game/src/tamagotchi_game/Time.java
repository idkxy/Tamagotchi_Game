/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi_game;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author idkxy
 */
public class Time {
    private static LocalDateTime currentTime = LocalDateTime.now();
    private static long createdFor;
    private static long dInSec;
    private static long dInMin;
    private static long dInHr;
    private static long dInDay;
    
    
    
    public static String computeDifference(LocalDateTime created)
    {
       
        setCreatedFor(Duration.between(created, getCurrentTime()).toMillis());
        setdInSec((getCreatedFor() / 1000) % 60);
        setdInMin((getCreatedFor() / (100 * 60)) % 60);
        setdInHr((getCreatedFor() / (100 * 60 * 60)) % 24);
        setdInDay((getCreatedFor() / (100 * 60 * 60 * 24)) % 365);
        return  "The pet has been created for: " + getdInDay() + "days, "+ getdInHr() + "hours, " + getdInMin() +"minutes, "+ getdInSec() + "seconds";
       
    }
    
   /* public String toString()
    {
        return ("The pet has been created for: " + this.getdInDay() + "days, "+ this.getdInHr() + "hours, " + this.getdInMin() +"minutes, "+ this.getdInSec() + "seconds");
    }/*

    /**
     * @return the currentTime
     */
    public static LocalDateTime getCurrentTime() {
        return currentTime;
    }

    /**
     * @param aCurrentTime the currentTime to set
     */
    public static void setCurrentTime(LocalDateTime aCurrentTime) {
        currentTime = aCurrentTime;
    }

    /**
     * @return the createdFor
     */
    public static long getCreatedFor() {
        return createdFor;
    }

    /**
     * @param aCreatedFor the createdFor to set
     */
    public static void setCreatedFor(long aCreatedFor) {
        createdFor = aCreatedFor;
    }

    /**
     * @return the dInSec
     */
    public static long getdInSec() {
        return dInSec;
    }

    /**
     * @param adInSec the dInSec to set
     */
    public static void setdInSec(long adInSec) {
        dInSec = adInSec;
    }

    /**
     * @return the dInMin
     */
    public static long getdInMin() {
        return dInMin;
    }

    /**
     * @param adInMin the dInMin to set
     */
    public static void setdInMin(long adInMin) {
        dInMin = adInMin;
    }

    /**
     * @return the dInHr
     */
    public static long getdInHr() {
        return dInHr;
    }

    /**
     * @param adInHr the dInHr to set
     */
    public static void setdInHr(long adInHr) {
        dInHr = adInHr;
    }

    /**
     * @return the dInDay
     */
    public static long getdInDay() {
        return dInDay;
    }

    /**
     * @param adInDay the dInDay to set
     */
    public static void setdInDay(long adInDay) {
        dInDay = adInDay;
    }
}
