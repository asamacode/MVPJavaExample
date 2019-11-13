package com.asama.luong.mvpjavaexample.data.network;

import com.asama.luong.mvpjavaexample.data.network.model.BlogResponse;
import com.asama.luong.mvpjavaexample.data.network.model.LoginRequest;
import com.asama.luong.mvpjavaexample.data.network.model.LoginResponse;
import com.asama.luong.mvpjavaexample.data.network.model.LogoutResponse;
import com.asama.luong.mvpjavaexample.data.network.model.OpenSourceResponse;

import io.reactivex.Single;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
