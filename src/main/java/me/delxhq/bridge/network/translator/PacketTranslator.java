package me.delxhq.bridge.network.translator;

public abstract class PacketTranslator<T> {

    public abstract void translate(T packet);
}