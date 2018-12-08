package pkgApp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.poi.ss.formula.functions.FinanceLib;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import javafx.beans.value.*;

import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;
	@FXML
	private Labeled txtSaveEachMonth;
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private Labeled txtWhatYouNeedToSave;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private Labeled txtErrorMessage;

	private HashMap<TextField, String> hmTextFieldRegEx = new HashMap<TextField, String>();

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	public void initialize(URL location, ResourceBundle resources) {
}

	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		txtSaveEachMonth.setText("");
		txtWhatYouNeedToSave.setText("");
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		txtErrorMessage.setText("");
		Iterator it = hmTextFieldRegEx.entrySet().iterator();
		while (it.hasNext()) {
		Map.Entry pair = (Map.Entry) it.next();
		TextField txtField = (TextField) pair.getKey();
		txtField.clear();
		txtField.setDisable(false);
		}
	}
	@FXML
	public void btnCalculate() {
		try {
			int iYearstoWork = Integer.parseInt(txtYearsToWork.getText());
			double dAnnualReturnWorking = Double.parseDouble(txtAnnualReturnWorking.getText());
			int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
			double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
			double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
			double dMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
			Retirement ret = new Retirement();
			ret.setdAnnualReturnRetired(dAnnualReturnRetired);
			ret.setdAnnualReturnWorking(dAnnualReturnWorking);
			ret.setdMonthlySSI(dMonthlySSI);
			ret.setdRequiredIncome(dRequiredIncome);
			ret.setiYearsRetired(iYearsRetired);
			ret.setiYearsToWork(iYearstoWork);
			txtWhatYouNeedToSave.setText(Double.toString(ret.TotalAmountSaved()*-1));
			txtSaveEachMonth.setText(Double.toString(ret.AmountToSave()));
		}
		catch (NumberFormatException e) {
			txtErrorMessage.setText("PLEASE ENTER NUMBERS");
		}
		
		
	}
}