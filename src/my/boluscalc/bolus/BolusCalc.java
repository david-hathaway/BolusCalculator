/*
 * BolusCalc 
 * 
 * Written by David S. Hathaway 2012
 * 
 * Written to aid diabetes patients calculate an insulin bolus based either on a carbohydrate correction
 * (carbs / ratio), blood sugar correction(blood sugar - target blood  sugar / insulin tolerance) or a combination
 * of the two.
 * 
 */
package my.boluscalc.bolus;

import java.text.NumberFormat;


public class BolusCalc {
    // Instance vairiables
    private double glucose,carbs,target,tolerance,ratio,Max;
        
    //constructor
    public BolusCalc(String glucose,String carbs, String target, 
                        String tolerance, String ratio,String Max){
        this.glucose = Double.parseDouble(glucose);
        this.carbs = Double.parseDouble(carbs);
        this.target = Double.parseDouble(target);
        this.tolerance = Double.parseDouble(tolerance);
        this.ratio = Double.parseDouble(ratio);
        this.Max = Double.parseDouble(Max);
    }
    //calculation method returns a string representing the insulin dosage to be called from the UI
    public String doCalc(){
        String bls;
        //create a NumberFormat object used to limit the display value of the return string to 1 decimal place
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        nf.setMinimumFractionDigits(1);
        //if the blood sugar is above maximum threshold use both formulas else just correct for carbs
        if(glucose>Max) {
            
            bls = nf.format((glucose-target)/tolerance+carbs/ratio);        
        }        
        
        else{
            bls = nf.format(carbs/ratio);        
        }
        //return the result
        return bls;
    
    }
    
}
