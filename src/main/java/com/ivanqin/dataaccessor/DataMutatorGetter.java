package com.ivanqin.dataaccessor;

import com.ivanqin.mutator.DataMutator;

public interface DataMutatorGetter<Mutation extends DataCanSave> {
  DataMutator<? extends Mutation> getDataMutator();
}
