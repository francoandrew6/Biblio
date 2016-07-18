package org.emmanuelfranco.biblio.lib.base;

/**
 * Created by ACE.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
