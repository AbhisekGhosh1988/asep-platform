package com.abhisek.asep.generator.spi;

public interface PlatformGeneratorFactory {

    PlatformGenerator getGenerator(
            TargetPlatform platform);

}