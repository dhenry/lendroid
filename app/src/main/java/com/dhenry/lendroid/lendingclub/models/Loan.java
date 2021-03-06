package com.dhenry.lendroid.lendingclub.models;

import org.jetbrains.annotations.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Loan {

    int id;
    int memberId;
    @NotNull Number loanAmount;
    @NotNull Number  fundedAmount;
    int term;
    @NotNull Number intRate;
    @NotNull Number expDefaultRate;
    @NotNull Number serviceFeeRate;
    @NotNull Number installment;
    @NotNull String grade;
    @NotNull String subGrade;
    int empLength;
    @NotNull String homeOwnership;
    @NotNull Number annualInc;
    @NotNull String isIncV;
    @NotNull String acceptD;
    @NotNull String expD;
    @NotNull String listD;
    @NotNull String creditPullD;
    @NotNull String reviewStatusD;
    @NotNull String reviewStatus;
    @NotNull String desc;
    @NotNull String purpose;
    @NotNull String addrCity;
    @NotNull String addrState;
    int investorCount;
    @NotNull String ilsExpD;
    @NotNull String initialListStatus;
    @NotNull String empTitle;
    int accNowDelinq;
    int accOpenPast24Mths;
    int bcOpenToBuy;
    @NotNull Number percentBcGt75;
    @NotNull Number bcUtil;
    @NotNull Number dti;
    int delinq2Yrs;
    @NotNull Number delinqAmnt;
    @NotNull String earliestCrLine;
    int ficoRangeLow;
    int ficoRangeHigh;
    int inqLast6Mths;
    int mthsSinceLastDelinq;
    int mthsSinceLastRecord;
    int mthsSinceRecentInq;
    int mthsSinceRecentRevolDelinq;
    int mthsSinceRecentBc;
    int mortAcc;
    int openAcc;
    int pubRec;
    int totalBalExMort;
    @NotNull Number revolBal;
    @NotNull Number revolUtil;
    int totalBcLimit;
    int totalAcc;
    int totalIlHighCreditLimit;
    int numRevAccts;
    int mthsSinceRecentBcDlq;
    int pubRecBankruptcies;
    int numAcctsEver120Ppd;
    int chargeoffWithin12Mths;
    int collections12MthsExMed;
    int taxLiens;
    int mthsSinceLastMajorDerog;
    int numSats;
    int numTlOpPast12m;
    int moSinRcntTl;
    int totHiCredLim;
    int totCurBal;
    int avgCurBal;
    int numBcTl;
    int numActvBcTl;
    int numBcSats;
    int pctTlNvrDlq;
    int numTl90gDpd24m;
    int numTl30dpd;
    int numTl120dpd2m;
    int numIlTl;
    int moSinOldIlAcct;
    int numActvRevTl;
    int moSinOldRevTlOp;
    int moSinRcntRevTlOp;
    int totalRevHiLim;
    int numRevTlBalGt0;
    int numOpRevTl;
    int totCollAmt;
}
