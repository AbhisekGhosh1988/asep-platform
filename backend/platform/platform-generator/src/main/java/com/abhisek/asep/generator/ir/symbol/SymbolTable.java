package com.abhisek.asep.generator.ir.symbol;

import lombok.Getter;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class SymbolTable {

    private final Map<String, Symbol> symbols =
            new LinkedHashMap<>();

    public void register(
            Symbol symbol) {

        symbols.put(
                symbol.getQualifiedName(),
                symbol);

    }

    public Optional<Symbol> find(
            String qualifiedName) {

        return Optional.ofNullable(
                symbols.get(qualifiedName));

    }

    public boolean contains(
            String qualifiedName) {

        return symbols.containsKey(
                qualifiedName);

    }

    public Collection<Symbol> getAll() {

        return symbols.values();

    }

}