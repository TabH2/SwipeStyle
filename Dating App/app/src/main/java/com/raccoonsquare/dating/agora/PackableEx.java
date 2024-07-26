package com.raccoonsquare.dating.agora;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}
