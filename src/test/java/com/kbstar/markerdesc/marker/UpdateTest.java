package com.kbstar.markerdesc.marker;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads() {
        try {
            service.modify(new MarkerDesc(10,108,"양꼬치", 20000, "yang2.jpg"));
            service.get();
        } catch (Exception e) {
            log.info("오류");
        }

    }

}
