package io.cjbdevlabs;

import lombok.extern.jbosslog.JBossLog;

@JBossLog
public class Implementation implements Contract {

    @Override
    public void term1() {
        log.info("term1 implmentation");
    }

    @Override
    public void term2() {
        log.info("term2 implmentation");
    }

    @Override
    public void extendedTerm() {
        log.info("extended term implementation");
    }
    
    
}
