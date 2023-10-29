package kz.pandev.legrambotapi.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Utility class for generating unique names
 *
 * @author ezuykow
 */
public final class UniqueNameGenerator {

    private UniqueNameGenerator() {}

    /**
     * Storage of used name prefixes and its counters
     */
    private static final ConcurrentHashMap<String, AtomicInteger> namesMap = new ConcurrentHashMap<>();

    /**
     * @param namePrefix prefix for new unique name
     * @return generated unique name
     */
    public static String next(String namePrefix) {
        AtomicInteger counter = namesMap.computeIfAbsent(namePrefix, v -> new AtomicInteger());
        return namePrefix + counter.incrementAndGet();
    }

    /**
     * Reset names generator
     */
    public static void reset() {
        namesMap.clear();
    }
}