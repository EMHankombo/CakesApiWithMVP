package com.example.mainza1992.apidemo.data;

import com.example.mainza1992.apidemo.data.network.ApiHelper;
import com.example.mainza1992.apidemo.data.network.AppApiHelper;
import com.example.mainza1992.apidemo.data.network.model.CakeListModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 29/09/2017.
 */

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;


    //empty constructor
    public AppDataManager() {
        this.apiHelper = new AppApiHelper();
    }

    @Override
    public Observable<List<CakeListModel>> useCaseCakeList() {
        return apiHelper.useCaseCakeList();
    }
}
