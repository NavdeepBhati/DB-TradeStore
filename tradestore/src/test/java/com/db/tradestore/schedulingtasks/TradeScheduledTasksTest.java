package com.db.tradestore.schedulingtasks;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.db.tradestore.TradeStoreApplication;
import com.db.tradestore.scheduler.TradeScheduledTasks;

@SpringJUnitConfig(TradeStoreApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeScheduledTasksTest {

    @SpyBean
    private TradeScheduledTasks TradeScheduledTasks;

    @Test
    public void whenWaitOneMinute_thenScheduledIsCalledAtLeastTwoTimes() {
        await()
                .atMost(1, TimeUnit.MINUTES)
                .untilAsserted(() -> verify(TradeScheduledTasks,atLeast(2)).reportCurrentTime());
    }

}