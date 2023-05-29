package com.example.incometaxcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etAnnualIncome, etHRA, etStandardDeduction, etPPF, etLifeInsurance, etHousingLoan, etOthers;
    EditText etNPS, etEduLoan, etDepositInterest, etMedInsSelf, etMedInsParent;
    EditText etInvestmentonNSCVIIIissue;
    EditText etDepositeofMutualfund;
    EditText etTutionfees;
    EditText etFixeddepositefor5yrs;
    EditText etdepositeunderseniorcitizen;
    EditText etEmployeecontributeanynationalscheme;

    EditText etNSCAccruedInterest;
    EditText etInterestseniorcitizen;
    EditText etDonation;
    EditText etInterestPaidonelectricvehicles;
    EditText etRepaymentofHouseLoan;
    EditText etProfessionalTax;
    EditText et80U;
    EditText et50B;
    EditText et80DD;
    EditText etHraallowance;
    EditText etBasic;
    EditText etHrapaid;
    EditText etHomeLoan;
    EditText etRepair;




    Spinner sp80U;
    Spinner sp50B;
    Spinner sp80DD;

    Button btnCalculate;
    SharedPreferences sharedPreferences;

    TextView tv80C;

    int annual_income, hra, standard, ppf, life_insurance, DepositeofMutualfund, Tutionfees, Fixeddepositefor5yrs, depositeunderseniorcitizen, InvestmentonNSCVIIIissue, Employeecontributeanynationalscheme, housing_loan, NSCAccruedInterest, others, nps, educational_loan, deposit_interest, Interestseniorcitizen, medins_self, medins_parent, Donation, InterestPaidonelectricvehicles, RepaymentofHouseLoan, ProfessionalTax, Hraallowance, Basic, Hrapaid, HomeLoan, Repair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = (SharedPreferences) getSharedPreferences("incometaxcalc", MODE_PRIVATE);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        etAnnualIncome = (EditText) findViewById(R.id.etAnnualIncome);
        etHRA = (EditText) findViewById(R.id.etHRA);

        etStandardDeduction = (EditText) findViewById(R.id.etStandardDeduction);

        etPPF = (EditText) findViewById(R.id.etPPF);
        etLifeInsurance = (EditText) findViewById(R.id.etLifeInsurance);
        etDepositeofMutualfund = (EditText)findViewById(R.id.etDepositeofMutualfund);
        etTutionfees = (EditText)findViewById(R.id.etTutionfees);
        etFixeddepositefor5yrs = (EditText)findViewById(R.id.etFixeddepositefor5yrs);
        etdepositeunderseniorcitizen = (EditText)findViewById(R.id.etdepositeunderseniorcitizen);
        etInvestmentonNSCVIIIissue = (EditText) findViewById(R.id.etInvestmentonNSCVIIIissue);
        etEmployeecontributeanynationalscheme = (EditText) findViewById(R.id.etEmployeecontributeanynationalscheme);
        etHousingLoan = (EditText) findViewById(R.id.etHousingLoan);
        etNSCAccruedInterest =(EditText) findViewById(R.id.etNSCAccruedInterest);
        etOthers = (EditText) findViewById(R.id.etOthers);

        etNPS = (EditText) findViewById(R.id.etNPS);

        etEduLoan = (EditText) findViewById(R.id.etEduLoan);

        etDepositInterest = (EditText) findViewById(R.id.etDepositInterest);

        etInterestseniorcitizen =(EditText) findViewById(R.id.etInterestseniorcitizen);

        etMedInsSelf = (EditText) findViewById(R.id.etMedInsSelf);
        etMedInsParent = (EditText) findViewById(R.id.etMedInsParent);

        etDonation =(EditText) findViewById(R.id.etDonation);

        etInterestPaidonelectricvehicles =(EditText) findViewById(R.id.etInterestPaidonelectricvehicles);

        etRepaymentofHouseLoan =(EditText) findViewById(R.id.etRepaymentofHouseLoan);
        etProfessionalTax =(EditText) findViewById(R.id.etProfessionalTax);
        etHraallowance =(EditText) findViewById(R.id.etHraallowance);
        etBasic =(EditText) findViewById(R.id.etBasic);
        etHrapaid =(EditText) findViewById(R.id.etHrapaid);
        etHomeLoan =(EditText) findViewById(R.id.etHomeLoan);
        etRepair =(EditText) findViewById(R.id.etRepair);




        tv80C = (TextView) findViewById(R.id.tv80C);

        sp80U = (Spinner) findViewById(R.id.sp80U);
        et80U = (EditText) findViewById(R.id.et80U);

        sp50B = (Spinner) findViewById(R.id.sp50B);
        et50B = (EditText) findViewById(R.id.et50B);

        sp80DD = (Spinner) findViewById(R.id.sp80DD);
        et80DD = (EditText) findViewById(R.id.et80DD);


        etdepositeunderseniorcitizen = (EditText) findViewById(R.id.etdepositeunderseniorcitizen);

        annual_income = sharedPreferences.getInt("annual_income", 0);
        hra = sharedPreferences.getInt("hra", 0);
        standard = sharedPreferences.getInt("standard", 50000);
        ppf = sharedPreferences.getInt("ppf", 0);
        life_insurance = sharedPreferences.getInt("life_insurance", 0);
        DepositeofMutualfund = sharedPreferences.getInt("DepositeofMutualfund", 0);
        Tutionfees = sharedPreferences.getInt("Tutionfees", 0);
        Fixeddepositefor5yrs = sharedPreferences.getInt("Fixeddepositefor5yrs",0);
        depositeunderseniorcitizen = sharedPreferences.getInt("depositeunderseniorcitizen",0);
        InvestmentonNSCVIIIissue = sharedPreferences.getInt("InvestmentonNSCVIIIissue",0);
        Employeecontributeanynationalscheme = sharedPreferences.getInt("Employeecontributeanynationalscheme",0);
        housing_loan = sharedPreferences.getInt("housing_loan", 0);
        NSCAccruedInterest =sharedPreferences.getInt("NSCAccruedInterest",0);
        others = sharedPreferences.getInt("others", 0);

        nps = sharedPreferences.getInt("nps", 0);
        educational_loan = sharedPreferences.getInt("Eduloan", 0);

        deposit_interest = sharedPreferences.getInt("deposit_interest", 0);
        Interestseniorcitizen =sharedPreferences.getInt("Interestseniorcitizen",0);

        medins_self = sharedPreferences.getInt("medins_self", 0);
        medins_parent = sharedPreferences.getInt("medins_parent", 0);
        Donation = sharedPreferences.getInt("Donation",0);
        InterestPaidonelectricvehicles = sharedPreferences.getInt("InterestPaidonelectricvehicles",0);
        RepaymentofHouseLoan =sharedPreferences.getInt("RepaymentofHouseLoan",0);
        ProfessionalTax =sharedPreferences.getInt("ProfessionalTax",0);
        Hraallowance =sharedPreferences.getInt("Hraallowance",0);
        Basic =sharedPreferences.getInt("Basic",0);
        Hrapaid =sharedPreferences.getInt("Hrapaid",0);
        HomeLoan =sharedPreferences.getInt("HomeLoan",0);
        Repair =sharedPreferences.getInt("Repair",0);




        etAnnualIncome.setText(String.valueOf(annual_income));
        etHRA.setText(String.valueOf(hra));
        etStandardDeduction.setText(String.valueOf(standard));
        etPPF.setText(String.valueOf(ppf));
        etLifeInsurance.setText(String.valueOf(life_insurance));
        etDepositeofMutualfund.setText(String.valueOf(DepositeofMutualfund));
        etTutionfees.setText(String.valueOf(Tutionfees));
        etFixeddepositefor5yrs.setText(String.valueOf(Fixeddepositefor5yrs));
        etDepositeofMutualfund.setText(String.valueOf(DepositeofMutualfund));
        etdepositeunderseniorcitizen.setText(String.valueOf(depositeunderseniorcitizen));
        etInvestmentonNSCVIIIissue.setText(String.valueOf(InvestmentonNSCVIIIissue));
        etEmployeecontributeanynationalscheme.setText(String.valueOf(Employeecontributeanynationalscheme));
        etHousingLoan.setText(String.valueOf(housing_loan));
        etNSCAccruedInterest.setText(String.valueOf(NSCAccruedInterest));
        etOthers.setText(String.valueOf(others));

        etNPS.setText(String.valueOf(nps));
        etEduLoan.setText(String.valueOf(educational_loan));
        etDepositInterest.setText(String.valueOf(deposit_interest));
        etInterestseniorcitizen.setText(String.valueOf(Interestseniorcitizen));
        etMedInsSelf.setText(String.valueOf(medins_self));
        etMedInsParent.setText(String.valueOf(medins_parent));
        etDonation.setText(String.valueOf(Donation));
        etInterestPaidonelectricvehicles.setText(String.valueOf(InterestPaidonelectricvehicles));
        etRepaymentofHouseLoan.setText(String.valueOf(RepaymentofHouseLoan));
        etProfessionalTax.setText(String.valueOf(ProfessionalTax));
        etHraallowance.setText(String.valueOf(Hraallowance));
        etBasic.setText(String.valueOf(Basic));
        etHrapaid.setText(String.valueOf(Hrapaid));
        etHomeLoan.setText(String.valueOf(HomeLoan));
        etRepair.setText(String.valueOf(Repair));












        etPPF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });

        etLifeInsurance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });

        etTutionfees.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });

        etDepositeofMutualfund.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });
        etEmployeecontributeanynationalscheme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });
        etdepositeunderseniorcitizen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });
        etFixeddepositefor5yrs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });
        etRepaymentofHouseLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });

        etEmployeecontributeanynationalscheme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });

        etHousingLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });
        etInvestmentonNSCVIIIissue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int
                    start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });
        etOthers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Calculate80C();
            }
        });






        etNPS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int nps = Integer.parseInt(etNPS.getText().toString());
                    if (nps > 50000) {
                        etNPS.setText("50000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });

        etDepositInterest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int deposit_interest = Integer.parseInt(etDepositInterest.getText().toString());
                    if (deposit_interest > 10000) {
                        etDepositInterest.setText("10000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });


        etEduLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int EduLoan = Integer.parseInt(etEduLoan.getText().toString());
                    if (EduLoan > 40000) {
                        etEduLoan.setText("40000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });


        etInterestPaidonelectricvehicles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int InterestPaidonelectricvehicles = Integer.parseInt(etInterestPaidonelectricvehicles.getText().toString());
                    if (InterestPaidonelectricvehicles > 150000) {
                        etInterestPaidonelectricvehicles.setText("150000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });


        etInterestseniorcitizen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int Interestseniorcitizen = Integer.parseInt(etInterestseniorcitizen.getText().toString());
                    if (Interestseniorcitizen > 50000) {
                        etInterestseniorcitizen.setText("50000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });
        etInterestseniorcitizen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int Interestseniorcitizen = Integer.parseInt(etInterestseniorcitizen.getText().toString());
                    if (Interestseniorcitizen > 50000) {
                        etInterestseniorcitizen.setText("50000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });
        etRepaymentofHouseLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int RepaymentofHouseLoan = Integer.parseInt(etRepaymentofHouseLoan.getText().toString());
                    if (RepaymentofHouseLoan > 100000) {
                        etRepaymentofHouseLoan.setText("100000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });
        etInterestPaidonelectricvehicles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int InterestPaidonelectricvehicles = Integer.parseInt(etInterestPaidonelectricvehicles.getText().toString());
                    if (InterestPaidonelectricvehicles > 150000) {
                        etInterestPaidonelectricvehicles.setText("150000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });
        etProfessionalTax.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int ProfessionalTax = Integer.parseInt(etProfessionalTax.getText().toString());
                    if (ProfessionalTax > 2500) {
                        etProfessionalTax.setText("2500");
                    }
                }
                catch (Exception ex) {

                }
            }
        });




















        etMedInsSelf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int medins_self = Integer.parseInt(etMedInsSelf.getText().toString());
                    if (medins_self > 25000) {
                        etMedInsSelf.setText("25000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });






        etMedInsParent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int medins_parent = Integer.parseInt(etMedInsParent.getText().toString());
                    if (medins_parent > 50000) {
                        etMedInsParent.setText("50000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });


        etHomeLoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int HomeLoan = Integer.parseInt(etHomeLoan.getText().toString());
                    if (HomeLoan > 200000) {
                        etHomeLoan.setText("200000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });






        etRepair.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int Repair = Integer.parseInt(etRepair.getText().toString());
                    if (Repair > 30000) {
                        etRepair.setText("30000");
                    }
                }
                catch (Exception ex) {

                }
            }
        });


        sp80U.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {
                    et80U.setText("0");
                }
                if (i == 1)
                {
                    et80U.setText("75000");
                }
                if (i == 2)
                {
                    et80U.setText("125000");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp80DD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {
                    et80DD.setText("0");
                }
                if (i == 1)
                {
                    et80DD.setText("75000");
                }
                if (i == 2)
                {
                    et80DD.setText("125000");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });












        sp50B.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {
                    et50B.setText("0");
                }
                if (i == 1)
                {
                    et50B.setText("40000");
                }
                if (i == 2)
                {
                    et50B.setText("100000");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveRecords();
                int annual_income = Integer.parseInt(etAnnualIncome.getText().toString());
                int hra = Integer.parseInt(etHRA.getText().toString());

                int ppf = Integer.parseInt(etPPF.getText().toString());
                int life_insurance = Integer.parseInt(etLifeInsurance.getText().toString());
                int DepositeofMutualfund = Integer.parseInt(etDepositeofMutualfund.getText().toString());
                int Tutionfees = Integer.parseInt(etTutionfees.getText().toString());
                int Fixeddepositefor5yrs = Integer.parseInt(etFixeddepositefor5yrs.getText().toString());
                int depositeunderseniorcitizen = Integer.parseInt(etdepositeunderseniorcitizen.getText().toString());
                int InvestmentonNSCVIIIissue = Integer.parseInt(etInvestmentonNSCVIIIissue.getText().toString());
                int Employeecontributeanynationalscheme = Integer.parseInt(etEmployeecontributeanynationalscheme.getText().toString());
                int housing_loan = Integer.parseInt(etHousingLoan.getText().toString());
                int NSCAccruedInterest = Integer.parseInt(etNSCAccruedInterest.getText().toString());
                int others = Integer.parseInt(etOthers.getText().toString());

                int nps = Integer.parseInt(etNPS.getText().toString());
                int Eduloan = Integer.parseInt(etEduLoan.getText().toString());
                int deposit_interest = Integer.parseInt(etDepositInterest.getText().toString());
                int Interestseniorcitizen =Integer.parseInt(etInterestseniorcitizen.getText().toString());

                int medins_self = Integer.parseInt(etMedInsSelf.getText().toString());
                int medins_parent = Integer.parseInt(etMedInsParent.getText().toString());
                int Donation = Integer.parseInt(etDonation.getText().toString());
                int Interestpaidonelectricvehicles = Integer.parseInt(etInterestPaidonelectricvehicles.getText().toString());
                int RepaymentofHouseLoan = Integer.parseInt(etRepaymentofHouseLoan.getText().toString());
                int ProfessionalTax = Integer.parseInt(etProfessionalTax.getText().toString());
                int Hraallowance = Integer.parseInt(etHraallowance.getText().toString());
                int Basic = Integer.parseInt(etBasic.getText().toString());
                int Hrapaid = Integer.parseInt(etHrapaid.getText().toString());
                int HomeLoan = Integer.parseInt(etHomeLoan.getText().toString());
                int repair = Integer.parseInt(etHrapaid.getText().toString());


                int _80ctotal = ppf + life_insurance + housing_loan + others +Fixeddepositefor5yrs +InvestmentonNSCVIIIissue +DepositeofMutualfund +Tutionfees +Employeecontributeanynationalscheme +NSCAccruedInterest +depositeunderseniorcitizen;

                int standard = Integer.parseInt(etStandardDeduction.getText().toString());
                int _80c = (_80ctotal<150000)?_80ctotal:150000;
                int _80ccd1b = (nps<50000)?nps:50000;
                int _80e = Eduloan;
                int _80tta = (deposit_interest<10000)?deposit_interest:10000;

                int _80d_self = (medins_self<25000)?medins_self:25000;
                int _80d_parent = (medins_parent<50000)?medins_parent:50000;
                int _80TTB = Interestseniorcitizen;
                int _80G = Donation;

                int _80EEB = Interestpaidonelectricvehicles;
                int _80EE = RepaymentofHouseLoan;
                int _ProfessionalTax = ProfessionalTax;
                int _Hraallowance = Hraallowance;
                int _Basic = Basic;
                int _Hrapaid = Hrapaid;
                int _HomeLoan = HomeLoan;
                int _Repair = Repair;



                int _80u = Integer.parseInt(et80U.getText().toString());
                int _50B = Integer.parseInt(et50B.getText().toString());
                int _80DD = Integer.parseInt(et80DD.getText().toString());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("_80c", _80c);
                editor.putInt("_80ccd1b", _80ccd1b);
                editor.putInt("_80e", _80e);
                editor.putInt("_80tta", _80tta);
                editor.putInt("_80d_self", _80d_self);
                editor.putInt("_80d_parent", _80d_parent);
                editor.putInt("_80u", _80u);
                editor.putInt("_50B", _50B);
                editor.putInt("_80DD",_80DD);
                editor.putInt("_80TTB", _80TTB);
                editor.putInt("_80G", _80G);
                editor.putInt("_80EEB", _80EEB);
                editor.putInt("_80EE", _80EE);
                editor.putInt("_ProfessionalTax", _ProfessionalTax);
                editor.putInt("_Hraallowance", _Hraallowance);
                editor.putInt("_Basic", _Basic);
                editor.putInt("_Hrapaid", _Hrapaid);
                editor.putInt("_HomeLoan", _HomeLoan);
                editor.putInt("_Repair", _Repair);


                editor.commit();

                Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });


    }

    void Calculate80C()
    {
        try {
            ppf = Integer.parseInt(etPPF.getText().toString());
            life_insurance = Integer.parseInt(etLifeInsurance.getText().toString());
            DepositeofMutualfund = Integer.parseInt(etDepositeofMutualfund.getText().toString());
            Tutionfees = Integer.parseInt(etTutionfees.getText().toString());
            Fixeddepositefor5yrs = Integer.parseInt(etFixeddepositefor5yrs.getText().toString());
            depositeunderseniorcitizen = Integer.parseInt(etdepositeunderseniorcitizen.getText().toString());
            InvestmentonNSCVIIIissue = Integer.parseInt(etInvestmentonNSCVIIIissue.getText().toString());
            Employeecontributeanynationalscheme = Integer.parseInt(etEmployeecontributeanynationalscheme.getText().toString());
            housing_loan = Integer.parseInt(etHousingLoan.getText().toString());
            others = Integer.parseInt(etOthers.getText().toString());
            NSCAccruedInterest = Integer.parseInt(etNSCAccruedInterest.getText().toString());




            int total = ppf + life_insurance + housing_loan + others +NSCAccruedInterest +DepositeofMutualfund +Tutionfees +Fixeddepositefor5yrs +Employeecontributeanynationalscheme +NSCAccruedInterest +depositeunderseniorcitizen +InvestmentonNSCVIIIissue;
            if (total < 150000) {
                tv80C.setText("80C - (Rs." + String.valueOf(total) + ")");
            } else {
                tv80C.setText("80C - (Rs.150000)");
            }
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    void SaveRecords()
    {
        int annual_income = Integer.parseInt(etAnnualIncome.getText().toString());
        int hra = Integer.parseInt(etHRA.getText().toString());
        int standard = Integer.parseInt(etStandardDeduction.getText().toString());
        int ppf = Integer.parseInt(etPPF.getText().toString());
        int life_insurance = Integer.parseInt(etLifeInsurance.getText().toString());
        int Tution_fees = Integer.parseInt(etTutionfees.getText().toString());
        int Fixeddeposite = Integer.parseInt(etFixeddepositefor5yrs.getText().toString());
        int depositeunderseniorcitizen = Integer.parseInt(etdepositeunderseniorcitizen.getText().toString());
        int InvestmentonNSCVIIIissue = Integer.parseInt(etInvestmentonNSCVIIIissue.getText().toString());
        int Employeecontributeanynationalscheme = Integer.parseInt(etEmployeecontributeanynationalscheme.getText().toString());
        int housing_loan = Integer.parseInt(etHousingLoan.getText().toString());
        int NSCAccruedInterest = Integer.parseInt(etNSCAccruedInterest.getText().toString());
        int others = Integer.parseInt(etOthers.getText().toString());

        int nps = Integer.parseInt(etNPS.getText().toString());

        int Eduloan = Integer.parseInt(etEduLoan.getText().toString());

        int deposit_interest = Integer.parseInt(etDepositInterest.getText().toString());

        int Interestseniorcitizen = Integer.parseInt(etInterestseniorcitizen.getText().toString());

        int medins_self = Integer.parseInt(etMedInsSelf.getText().toString());
        int medins_parent = Integer.parseInt(etMedInsParent.getText().toString());

        int HomeLoan = Integer.parseInt(etHomeLoan.getText().toString());
        int Repair = Integer.parseInt(etRepair.getText().toString());

        int Donation = Integer.parseInt(etDonation.getText().toString());

        int InterestPaidonelectricvehicles = Integer.parseInt(etInterestPaidonelectricvehicles.getText().toString());


        int ProfessionalTax = Integer.parseInt(etProfessionalTax.getText().toString());
        int Hraallowance = Integer.parseInt(etHraallowance.getText().toString());
        int Basic = Integer.parseInt(etBasic.getText().toString());
        int Hrapaid = Integer.parseInt(etHrapaid.getText().toString());

        int hrexception = Hrapaid - (Basic * 10/100);







        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("annual_income", annual_income);
        editor.putInt("hra", hra);

        editor.putInt("standard", standard);
        editor.putInt("ppf", ppf);
        editor.putInt("life_insurance", life_insurance);

        editor.putInt("Tution_fees", Tution_fees);
        editor.putInt("Fixeddeposite", Fixeddeposite);
        editor.putInt("depositeunderseniorcitizen", depositeunderseniorcitizen);
        editor.putInt("InvestmentonNSCVIIIissue", InvestmentonNSCVIIIissue);
        editor.putInt("Employeecontributeanynationalscheme", Employeecontributeanynationalscheme);
        editor.putInt("housing_loan", housing_loan);
        editor.putInt("NSCAccruedInterest", NSCAccruedInterest);
        editor.putInt("others", others);

        editor.putInt("nps", nps);
        editor.putInt("Eduloan", Eduloan);
        editor.putInt("deposit_interest", deposit_interest);
        editor.putInt("Interestseniorcitizen", Interestseniorcitizen);

        editor.putInt("medins_self", medins_self);
        editor.putInt("medins_parent", medins_parent);
        editor.putInt("Donation", Donation);

        editor.putInt("InterestPaidonelectricvehicles", InterestPaidonelectricvehicles);
        editor.putInt("RepaymentofHouseLoan", RepaymentofHouseLoan);

        editor.putInt("ProfessionalTax", ProfessionalTax);
        editor.putInt("Hraallowance", Hraallowance);
        editor.putInt("Basic", Basic);
        editor.putInt("hrexception", hrexception);
        editor.putInt("HomeLoan", HomeLoan);
        editor.putInt("Repair", Repair);









        editor.commit();
        Toast.makeText(getApplicationContext(), "Saved...", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuSave)
        {
            SaveRecords();
        }
        return super.onOptionsItemSelected(item);
    }
}