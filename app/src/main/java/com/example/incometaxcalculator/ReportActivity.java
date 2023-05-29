package com.example.incometaxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReportActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView tvIncome, tvStandardDeduction, tvDeduction, tvTaxableIncome, tvTax, tvEducationalCess, tvOverallTax, tvExemptedHRA;
    TextView tvnIncome, tvnStandardDeduction, tvnDeduction, tvnTaxableIncome, tvnTax, tvnEducationalCess, tvnOverallTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        sharedPreferences = (SharedPreferences) getSharedPreferences("incometaxcalc", MODE_PRIVATE);
        int annual_income = sharedPreferences.getInt("annual_income", 0);
        int hra = sharedPreferences.getInt("hra", 0);
        int standard = sharedPreferences.getInt("standard", 50000);
        int ppf = sharedPreferences.getInt("ppf", 0);
        int life_insurance = sharedPreferences.getInt("life_insurance", 0);
        int DepositeofMutualfund = sharedPreferences.getInt("DepositeofMutualfund", 0);
        int Tutionfees = sharedPreferences.getInt("Tutionfees", 0);
        int Fixeddepositefor5yrs = sharedPreferences.getInt("Fixeddepositefor5yrs",0);
        int depositeunderseniorcitizen = sharedPreferences.getInt("depositeunderseniorcitizen",0);
        int InvestmentonNSCVIIIissue = sharedPreferences.getInt("InvestmentonNSCVIIIissue",0);
        int Employeecontributeanynationalscheme = sharedPreferences.getInt("Employeecontributeanynationalscheme",0);
        int housing_loan = sharedPreferences.getInt("housing_loan", 0);
        int NSCAccruedInterest =sharedPreferences.getInt("NSCAccruedInterest",0);
        int others = sharedPreferences.getInt("others", 0);

        int nps = sharedPreferences.getInt("nps", 0);
        int educational_loan = sharedPreferences.getInt("educational_loan", 0);
        int deposit_interest = sharedPreferences.getInt("deposit_interest", 0);
        int Interestseniorcitizen =sharedPreferences.getInt("Interestseniorcitizen",0);
        int medins_self = sharedPreferences.getInt("medins_self", 0);
        int medins_parent = sharedPreferences.getInt("medins_parent", 0);
        int Donation = sharedPreferences.getInt("Donation",0);
        int InterestPaidonelectricvehicles = sharedPreferences.getInt("InterestPaidonelectricvehicles",0);
        int Firsthomebuyers =sharedPreferences.getInt("Firsthomebuyers",0);
        int ProfessionalTax =sharedPreferences.getInt("ProfessionalTax",0);
        int Hraallowance =sharedPreferences.getInt("Hraallowance",0);
        int Basic =sharedPreferences.getInt("Basic",0);
        int Hrapaid =sharedPreferences.getInt("Hrapaid",0);
        int HomeLoan =sharedPreferences.getInt("HomeLoan",0);
        int Repair =sharedPreferences.getInt("Repair",0);



        int _80c = sharedPreferences.getInt("_80c", 0);
        int _80ccd1b = sharedPreferences.getInt("_80ccd1b", 0);
        int _80e = sharedPreferences.getInt("_80e", 0);
        int _80tta = sharedPreferences.getInt("_80tta", 0);
        int _80d_self = sharedPreferences.getInt("_80d_self", 0);
        int _80d_parent = sharedPreferences.getInt("_80d_parent", 0);
        int _80TTB = sharedPreferences.getInt("_80TTB", 0);
        int _80G = sharedPreferences.getInt("_80G", 0);
        int _80EEB= sharedPreferences.getInt("_80EEB", 0);
        int _80EE = sharedPreferences.getInt("_80EE", 0);
        int _ProfessionalTax = sharedPreferences.getInt("_ProfessionalTax", 0);
        int _Hraallowance = sharedPreferences.getInt("_Hraallowance", 0);
        int _Basic = sharedPreferences.getInt("_Basic", 0);
        int _Hrapaid = sharedPreferences.getInt("_Hrapaid", 0);
        int hrexception = sharedPreferences.getInt("hrexception", 0);
        int _HomeLoan = sharedPreferences.getInt("_HomeLoan", 0);
        int _Repair = sharedPreferences.getInt("_Repair", 0);




        int total_income = annual_income + hra;
        int _80u = sharedPreferences.getInt("_80u", 0);
        int _50B = sharedPreferences.getInt("_50B", 0);
        int _80DD = sharedPreferences.getInt("_80DD", 0);


        tvIncome = (TextView) findViewById(R.id.tvIncome);
        tvnIncome = (TextView) findViewById(R.id.tvnIncome);
        tvnTaxableIncome = (TextView) findViewById(R.id.tvnTaxableIncome);

        tvIncome.setText("Rs. " + String.valueOf(total_income));
        tvnIncome.setText("Rs. " + String.valueOf(total_income));


        tvnIncome = (TextView) findViewById(R.id.tvnIncome);

        tvStandardDeduction = (TextView) findViewById(R.id.tvStandardDeduction);
        tvStandardDeduction.setText("Rs. " + String.valueOf(standard));

        tvStandardDeduction = (TextView) findViewById(R.id.tvStandardDeduction);

        tvStandardDeduction.setText("Rs. " + String.valueOf(standard));

        tvExemptedHRA = (TextView) findViewById(R.id.tvExemptedHRA);
        tvExemptedHRA.setText("Rs. " + String.valueOf(hrexception));


        //Deduction
        int total_deduction = standard + _80c + _80ccd1b + _80e + _80tta + _80d_self + _80d_parent + _80u +_80TTB +_80G +_ProfessionalTax +_80EEB +_80EE +_50B +_80DD + hrexception +_HomeLoan +_Repair;
        tvDeduction = (TextView) findViewById(R.id.tvDeduction);
        tvDeduction.setText("Rs. " + String.valueOf(total_deduction));

        int taxable_income = total_income - total_deduction;
        int ntaxable_income = total_income - standard;
        int taxable_income_temp = total_income - total_deduction;
        tvTaxableIncome = (TextView) findViewById(R.id.tvTaxableIncome);
        tvTaxableIncome.setText("Rs. " + String.valueOf(taxable_income));




        tvnTaxableIncome.setText("Rs. " + String.valueOf(ntaxable_income));

        int tax = 0;

        if (taxable_income < 250000)
        {
            tax = 0;
        }
        else
        {
            if (taxable_income <= 500000)
            {
                tax = (taxable_income-250000) * 5/100;
            }
            else
            {
                tax += 12500;
                if (taxable_income <= 1000000)
                {
                    tax += (taxable_income-500000) * 20/100;
                }
                else
                {
                    tax += 100000;
                    tax += (taxable_income-1000000) * 30/100;
                }
            }
        }

        tvTax = (TextView) findViewById(R.id.tvTax);
        tvTax.setText("Rs. " + String.valueOf(tax));

        int eduCess = tax * 4/100;
        tvEducationalCess = (TextView) findViewById(R.id.tvEducationalCess);
        tvEducationalCess.setText("Rs. " + String.valueOf(eduCess));

        int overallTax = tax + eduCess;
        tvOverallTax = (TextView) findViewById(R.id.tvOverallTax);
        tvOverallTax.setText("Rs. " + String.valueOf(overallTax));

        int ntax = 0;
        if (ntaxable_income < 300000)
        {
            ntax = 0;
        }
        else
        {
            if (ntaxable_income <= 600000)
            {
                ntax = (ntaxable_income-300000) * 5/100;
            }
            else
            {
                ntax += 15000;
                if (ntaxable_income <= 900000)
                {
                    ntax += (ntaxable_income-600000) * 10/100;
                }
                else
                {
                    ntax += 30000;
                    if (ntaxable_income <= 1200000)
                    {

                        ntax += (ntaxable_income-900000) * 15/100;
                    }
                    else
                    {
                        ntax += 45000;
                        if (ntaxable_income <= 1500000)
                        {

                            ntax += (ntaxable_income-1200000) * 20/100;
                        }
                        else
                        {
                            ntax += 60000;
                            if (ntaxable_income > 1500000)
                            {
                                ntax += (ntaxable_income-1500000) * 30/100;
                            }
                        }
                    }
                }
            }
        }
        tvnTax = (TextView) findViewById(R.id.tvnTax);
        tvnTax.setText(String.valueOf("Rs. " + ntax));

        tvnEducationalCess = (TextView) findViewById(R.id.tvnEducationalCess);
        int nEduCess = ntax * 4 / 100;
        tvnEducationalCess.setText(String.valueOf("Rs. " + nEduCess));

        tvnOverallTax = (TextView) findViewById(R.id.tvnOverallTax);
        int nOverallTax = ntax + nEduCess;
        tvnOverallTax.setText("Rs. " + nOverallTax);
    }
}