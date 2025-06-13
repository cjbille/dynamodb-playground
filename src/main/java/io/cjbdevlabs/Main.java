package io.cjbdevlabs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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

            List<String> someList = new ArrayList<>();
            someList.add("foo");
            someList.add("bar");
            someList.add("zar");
            someList.add("car");
            someList.add("jar");

            Iterator<String> iterator = someList.iterator(); // creates a new iterator instance

            // this was popular prior to java 5 (when enhanced for loop was introduced)
            // while (iterator.hasNext()) {
            //     log.infof("element iterator is: %s", iterator.next());
            // }

            // for (var e : someList) {
            //     log.infof("element in enhanced for loop is: %s", e);
            // }

            // concurrent modification exception
            // to avoid, create a new collection with items to be removed, and then run a removeAll() on original collection
            // or use an iterator
            /*
            for (var e : someList) {
                if (e.equals("zar")) {
                    someList.remove(e);
                }
            }
             */

            //  while (iterator.hasNext()) {
            //     if (iterator.next().equals("jar")) {
            //         iterator.remove();
            //     }
            //  }
            
            //  log.infof("elements in someList after iterator for are: %s", someList.toString());

            var elementsToRemove = new ArrayList<String>();
            for (var e : someList) {
                if (e.equals("zar")) {
                    elementsToRemove.add(e);
                }
            }
            // someList.removeAll(elementsToRemove);

            // log.infof("elements in someList after enhanced for are: %s", someList.toString());

            var newList = someList
                .stream()
                .peek(e -> log.infof("element in stream is: %s", e))
                .filter(e -> !e.equals("zar"))
                .toList();

            log.infof("elements in newList after stream are: %s", newList.toString());

            Quarkus.waitForExit();
            return 0;
        }
    }
}
