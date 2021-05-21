package com.htmlcomponent.domain.model.htmlcomponent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
public class HistoryAppender {
  private HistoryRepository historyRepository;

  public HistoryAppender(final HistoryRepository historyRepository) {
    this.historyRepository = historyRepository;
  }

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void appendHistoryBy(PageContentChanged event) {
    log.debug("HistoryAppender appendHistoryBy");
    History history = History
        .builder()
        .htmlComponent(event.getHtmlComponent())
        .type("Changed")
        .description(event.getAuthor() + " : " + event.getPageId())
        .build();

    historyRepository.save(history);
  }
}