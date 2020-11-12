package com.ivanqin.system;

import com.ivanqin.model.DataListener;
import com.ivanqin.model.DataModel;
import com.ivanqin.mutator.DataMutator;
import com.ivanqin.mutator.DataMutatorImpl;

/** DataService -> DataSystem(optional) -> DataMutator */
public class DataSystem {

  private DataMutatorImpl mDataMutatorImpl;

  public DataSystem(DataMutatorImpl dataMutatorImpl) {
    mDataMutatorImpl = dataMutatorImpl;
  }

  public DataModel getGlobalData() {
    return mDataMutatorImpl.getDataModel();
  }

  public DataMutator getDataMutator() {
    return mDataMutatorImpl;
  }

  public void addDataListener(DataListener<DataModel> dataListener) {
    mDataMutatorImpl.addDataListener(dataListener);
  }

  public void removeDataListener(DataListener dataListener) {
    mDataMutatorImpl.removeDataListener(dataListener);
  }
}
