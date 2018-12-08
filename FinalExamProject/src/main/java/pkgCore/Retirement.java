package pkgCore;
import org.apache.poi.ss.formula.functions.FinanceLib;
public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	public Retirement() {
	}
	
	public int getiYearsToWork() {
		return iYearsToWork;
	}



	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}



	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}



	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}



	public int getiYearsRetired() {
		return iYearsRetired;
	}



	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}



	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}



	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}



	public double getdRequiredIncome() {
		return dRequiredIncome;
	}



	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}



	public double getdMonthlySSI() {
		return dMonthlySSI;
	}



	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}



	public double AmountToSave()
	{
		double pmt = FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, TotalAmountSaved(), false);
		return pmt;
	}
	
	public double TotalAmountSaved()
	{
		double pv = FinanceLib.pv(dAnnualReturnRetired / 12, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false);
		return pv;
	}
}
