package ME;

import java.util.Scanner;

class CmConversion {
	private double centimeter;
	private double feet;
	private double yard;
	private double inch;
	
	public CmConversion() {
		this.centimeter  = 0;
		this.feet = 0;
		this.yard = 0;
		this.inch = 0;
	}
	
	public CmConversion(double cm, double ft, double yd, double in) {
		this.centimeter = cm;
		this.feet = ft;
		this.yard = yd;
		this.inch= in;
	}
	
	public void setCentimeter(double cm) {
		this.centimeter = cm;
	}
	
	public void setFeet(double ft) {
		this.feet = ft;
	}
	
	public void setYard(double yd) {
		this.yard = yd;
	}
	
	public void setInch(double in) {
		this.inch = in;
	}
	
	public double getCentimeter() {
		return this.centimeter;
	}
	
	public double getFeet() {
		return this.feet;
	}
	
	public double getYard() {
		return this.yard;
	}
	
	public double getInch() {
		return this.inch;
	}
	
	public double centimeterToInch() {
		this.inch = this.centimeter / 2.54;
		
		return this.inch;
	}
	
	public double centimeterToYard() {
		this.inch = centimeterToInch();
		this.feet = this.inch / 12;
		this.yard = this.feet / 3;
		
		return yard;
	}
}

public class CmConversionTest {
	public static void main(String[] args) {
		CmConversion cmConversion = new CmConversion();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Centimeter Conversion");
		System.out.print("\nEnter a number: ");
		double numToConvert  = scanner.nextDouble();
		scanner.nextLine();
		
		cmConversion.setCentimeter(numToConvert);
		cmConversion.centimeterToInch();
		double inch = cmConversion.getInch();
		
		cmConversion.setCentimeter(numToConvert);
		cmConversion.centimeterToYard();
		double yard = cmConversion.getYard();
		
		cmConversion.setCentimeter(numToConvert);
		cmConversion.centimeterToYard();
		double foot = cmConversion.getFeet();
		
		System.out.println(numToConvert + " cm/s is " + inch + " inch/es");
		System.out.println(numToConvert + " cm/s is " + yard + " yard/s");
		System.out.println(numToConvert + " cm/s is " + foot + " foot/s");
		
		scanner.close();
	}
}
