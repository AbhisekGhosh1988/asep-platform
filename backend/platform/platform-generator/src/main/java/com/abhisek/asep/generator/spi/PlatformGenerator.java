package com.abhisek.asep.generator.spi;

import com.abhisek.asep.generator.session.GenerationSession;

public interface PlatformGenerator {

    TargetPlatform getTargetPlatform();

    void generate(GenerationSession session);

}