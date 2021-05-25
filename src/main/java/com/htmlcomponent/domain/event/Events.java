package com.htmlcomponent.domain.event;

import org.springframework.context.ApplicationEventPublisher;

public class Events {
    private static ThreadLocal<ApplicationEventPublisher> publisherLocal = new ThreadLocal<>();

    public static void publish(DomainEvent event) {
      if (event == null) {
        return;
      }
      if (publisherLocal.get() != null) {
        publisherLocal.get().publishEvent(event);
      }
    }

    static void setPublisher(ApplicationEventPublisher publisher) {
      publisherLocal.set(publisher);
    }

    static void reset() {
      publisherLocal.remove();
    }
}