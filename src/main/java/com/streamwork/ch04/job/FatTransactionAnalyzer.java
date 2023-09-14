package com.streamwork.ch04.job;

import com.streamwork.ch04.api.Event;
import com.streamwork.ch04.api.EventCollector;
import com.streamwork.ch04.api.GroupingStrategy;
import com.streamwork.ch04.api.Operator;

class FatTransactionAnalyzer extends Operator {
  // private static final long serialVersionUID = 0L;
  private int instance;

  public FatTransactionAnalyzer(String name, int parallelism, GroupingStrategy grouping) {
    super(name, parallelism, grouping);
  }

  @Override
  public void setupInstance(int instance) {
    this.instance = instance;
  }

  @Override
  public void apply(Event transaction, EventCollector eventCollector) {
    FatTransactionEvent e = (FatTransactionEvent) transaction;
    // Dummy analyzer. Allow all transactions.
    eventCollector.add(new TransactionScoreEvent(e, 1.0f));
  }
}
