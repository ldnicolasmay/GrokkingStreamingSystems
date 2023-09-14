package com.streamwork.ch04.job;

import com.streamwork.ch04.api.Event;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple transaction event used in the fraud detection job.
 */
public class FatTransactionEvent extends TransactionEvent {
  public final String foo;

  public FatTransactionEvent(String transactionId, float amount, Date transactionTime, long merchandiseId, long userAccount, String foo) {
    super(transactionId, amount, transactionTime, merchandiseId, userAccount);
    this.foo = foo;
  }

  @Override
  public String toString() {
    return String.format("[transaction:%s; transactionTime: %s; merchandise: %d, user: %d, foo: %s]",
        transactionId, formatter.format(transactionTime), merchandiseId, userAccount, foo);
  }

}
