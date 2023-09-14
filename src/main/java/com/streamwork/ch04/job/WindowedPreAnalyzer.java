package com.streamwork.ch04.job;

import com.streamwork.ch04.api.Event;
import com.streamwork.ch04.api.EventCollector;
import com.streamwork.ch04.api.GroupingStrategy;
import com.streamwork.ch04.api.Operator;

class WindowedPreAnalyzer extends Operator {
  private static final long serialVersionUID = 302238920663638527L;
  private int instance;

  public WindowedPreAnalyzer(String name, int parallelism, GroupingStrategy grouping) {
    super(name, parallelism, grouping);
  }

  @Override
  public void setupInstance(int instance) {
    this.instance = instance;
  }

  @Override
  public void apply(Event transaction, EventCollector eventCollector) {
    TransactionEvent e = ((TransactionEvent)transaction);
    // Dummy analyzer. Allow all transactions.
    //eventCollector.add(new TransactionScoreEvent(e, 0.0f));
    // Just pass along the transaction event downstream w/o any transformation
    eventCollector.add(transaction);
  }
}
