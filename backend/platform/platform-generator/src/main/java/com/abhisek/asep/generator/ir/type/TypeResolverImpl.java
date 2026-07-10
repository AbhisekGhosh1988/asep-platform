package com.abhisek.asep.generator.ir.type;

import com.abhisek.asep.generator.ir.symbol.Symbol;
import com.abhisek.asep.generator.ir.symbol.SymbolKind;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeResolverImpl implements TypeResolver {

    @Override
    public TypeRegistry resolve(SymbolTable symbolTable) {

        TypeRegistry registry = new TypeRegistry();

        for (Symbol symbol : symbolTable.symbols()) {

            registry.register(Type.builder().name(symbol.getName()).qualifiedName(symbol.getName()).kind(map(symbol.getKind())).build());

        }

        return registry;

    }

    private TypeKind map(SymbolKind kind) {

        return switch (kind) {

            case ENTITY -> TypeKind.ENTITY;

            case VALUE_OBJECT -> TypeKind.VALUE_OBJECT;

            case COMMAND -> TypeKind.COMMAND;

            case QUERY -> TypeKind.QUERY;

            case DOMAIN_EVENT -> TypeKind.EVENT;

            default -> TypeKind.UNKNOWN;

        };

    }

}