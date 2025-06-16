package io.cjbdevlabs;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(AppStart.class, args);
    }

    public static class AppStart implements QuarkusApplication {
        
        @Override
        public int run(String... args) throws Exception {
            Quarkus.waitForExit();
            return 0;
        }
    }
}
