package com.abhisek.asep.generator.ir.symbol;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Compiler symbol table.
 */
public class SymbolTable {

    /**
     * Registered compiler symbols.
     */
    private final Map<String, Symbol> symbols =
            new LinkedHashMap<>();

    /**
     * Register a symbol.
     */
    public void register(Symbol symbol) {

        if (symbols.containsKey(symbol.getName())) {

            throw new DuplicateSymbolException(symbol.getName());

        }

        symbols.put(symbol.getName(), symbol);

    }

    /**
     * Lookup by name.
     */
    public Optional<Symbol> resolve(String name) {

        return Optional.ofNullable(symbols.get(name));

    }

    /**
     * Check existence.
     */
    public boolean contains(String name) {

        return symbols.containsKey(name);

    }

    /**
     * Total registered symbols.
     */
    public int size() {

        return symbols.size();

    }

    /**
     * Read-only symbols.
     */
    public Collection<Symbol> symbols() {

        return Collections.unmodifiableCollection(
                symbols.values());

    }

}