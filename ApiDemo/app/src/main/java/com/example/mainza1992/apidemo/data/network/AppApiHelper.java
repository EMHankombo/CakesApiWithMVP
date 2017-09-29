package com.example.mainza1992.apidemo.data.network;

import com.example.mainza1992.apidemo.data.network.model.CakeListModel;
import com.example.mainza1992.apidemo.data.network.service.ConnectionService;
import com.example.mainza1992.apidemo.data.network.service.IRequestInterface;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mainza1992 on 29/09/2017.
 */

public class AppApiHelper implements ApiHelper {

    private IRequestInterface requestInterface;

    //constructor to initliase request interface
    //make sure constrcutor is empty
    public AppApiHelper() {
        this.requestInterface = ConnectionService.getConnectionService();
    }

    @Override
    public Observable<List<CakeListModel>> useCaseCakeList() {
        //step 8 calling inteface
        return requestInterface.getCakeList();
    }
}
