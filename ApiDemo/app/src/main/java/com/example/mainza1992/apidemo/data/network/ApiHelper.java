package com.example.mainza1992.apidemo.data.network;

import com.example.mainza1992.apidemo.data.network.model.CakeListModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 29/09/2017.
 */

public interface ApiHelper {

    Observable<List<CakeListModel>> useCaseCakeList();
}
