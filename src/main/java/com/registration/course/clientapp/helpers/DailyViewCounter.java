package com.registration.course.clientapp.helpers;

import org.springframework.stereotype.Component;

@Component
public class DailyViewCounter {
  private int count;

  public void increment() {
    count++;
  }

  public int getCount() {
    return count;
  }
}
