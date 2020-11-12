package com.ivanqin.controllers;

import com.ivanqin.dataaccessor.DataGetter;
import com.ivanqin.model.DataListener;
import com.ivanqin.model.Project1;
import com.ivanqin.shared.Logger;

public class TeamMember2<Data extends Project1.ProvideProject1, Services extends DataGetter<Data>>
    implements DataListener<Data> {

  private Services mDataServices;

  public TeamMember2(Services dataServices) {
    mDataServices = dataServices;
  }

  public void onDataChanged(Data previousData) {
    Data currentData = mDataServices.getGlobalData();
    int currentWorkLoad = currentData.getProject1().getWorkLoad();
    int previousWorkLoad = previousData.getProject1().getWorkLoad();
    if (currentWorkLoad > previousWorkLoad) {
      Logger.getInstance()
          .speak(
              this.getClass(), "Workload is increased by " + (currentWorkLoad - previousWorkLoad));
    } else if (currentWorkLoad < previousWorkLoad) {
      Logger.getInstance()
          .speak(this.getClass(), "Workload is reduced by " + (previousWorkLoad - currentWorkLoad));
    } else {
      Logger.getInstance().speak(this.getClass(), "Nothing changed");
    }
  }
}
