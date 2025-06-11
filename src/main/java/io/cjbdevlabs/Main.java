package io.cjbdevlabs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {
        
        @Override
        public int run(String... args) throws Exception {
            log.info("Starting Quarkus App");
            Contract contract = new Implementation();
            printTerms(contract);


            List<String> c = new ArrayList<>();
            c.add("foo");
            c.add("bar");

            Set<String> s = new HashSet<>(c);
            log.infof("the set is %s", s.toString());

            Quarkus.waitForExit();
            return 0;
        }

        private static void printTerms(Contract contract) {
            contract.term1();
            contract.term2();
        }
    }
}
