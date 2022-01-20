package lv.hr.program;

import lv.hr.program.services.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ApplicationToRun implements CommandLineRunner {

    @Resource
    FilesStorageService storageService;

        public static void main(String[] args) {
        SpringApplication.run(ApplicationToRun.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }
}
