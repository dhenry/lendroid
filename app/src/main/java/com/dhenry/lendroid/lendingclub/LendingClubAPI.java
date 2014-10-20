package com.dhenry.lendroid.lendingclub;

import com.dhenry.lendroid.lendingclub.models.AccountSummary;
import com.dhenry.lendroid.lendingclub.models.AvailableCash;
import com.dhenry.lendroid.lendingclub.models.DetailedOwnedNote;
import com.dhenry.lendroid.lendingclub.models.ListedNotes;
import com.dhenry.lendroid.lendingclub.models.OwnedNote;
import com.dhenry.lendroid.lendingclub.models.OwnedNotes;
import com.dhenry.lendroid.lendingclub.models.OrderExecutionResponse;
import com.dhenry.lendroid.lendingclub.models.OrderRequest;
import com.dhenry.lendroid.lendingclub.models.Portfolio;
import com.dhenry.lendroid.lendingclub.models.PortfolioRequest;
import com.dhenry.lendroid.lendingclub.models.Portfolios;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface LendingClubAPI {

    public static final String SERVER = "https://api.lendingclub.com/api/investor/v1";

    // Accounts resources

    @GET("/accounts/{investorId}/availablecash")
    AvailableCash getAvailableCash(@Path("investorId") String investorId);

    @GET("/accounts/{investorId}/summary")
    AccountSummary getAccountSummary(@Path("investorId") String investorId);

    @GET("/accounts/{investorId}/notes")
    OwnedNotes<OwnedNote> getOwnedNotes(@Path("investorId") String investorId);

    @GET("/accounts/{investorId}/detailednotes")
    OwnedNotes<DetailedOwnedNote> getDetailedOwnedNotes(@Path("investorId") String investorId);

    @GET("/accounts/{investorId}/portfolios")
    Portfolios getPortfolios(@Path("investorId") String investorId);

    @POST("/accounts/{investorId}/portfolios")
    Portfolio createPortfolio(@Body PortfolioRequest portfolioRequest, @Path("investorId") String investorId);

    @POST("/accounts/{investorId}/orders")
    OrderExecutionResponse createOrder(@Body OrderRequest orderRequest, @Path("investorId") String investorId);

    // Loans resources

    @GET("/loans/listing")
    ListedNotes getListedNotes();
}
