package pkgEmpty;

import static org.junit.Assert.*;
import pkgCore.Retirement;
import org.junit.Test;

public class RetirementTest {

	@Test
	public void Retirement() {
		Retirement r = new Retirement();
		r.setdAnnualReturnRetired(0.02);
		r.setdAnnualReturnWorking(0.07);
		r.setdMonthlySSI(2642);
		r.setdRequiredIncome(10000);
		r.setiYearsRetired(20);
		r.setiYearsToWork(40);
		assertEquals(r.AmountToSave(), 554.13,0.01);
		assertEquals(r.TotalAmountSaved(),-1454485.55,0.01);
	}

}
