package com.ivanqin.mutator;

import com.ivanqin.dataaccessor.DataCanSave;

public interface DataMutator<Mutation extends DataCanSave> {
  Mutation mutate();

  Mutation mutateAllowRecursive();
}
