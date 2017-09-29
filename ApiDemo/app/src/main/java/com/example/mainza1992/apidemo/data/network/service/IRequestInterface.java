package com.example.mainza1992.apidemo.data.network.service;

import com.example.mainza1992.apidemo.data.network.model.API_Constants;
import com.example.mainza1992.apidemo.data.network.model.CakeListModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by mainza1992 on 27/09/2017.
 */

public interface IRequestInterface {

    /**
     * list of all the requests you will be making to the webserver
     */

    @GET(API_Constants.CAKELIST_API)
    Observable<List<CakeListModel>> getCakeList();
}
