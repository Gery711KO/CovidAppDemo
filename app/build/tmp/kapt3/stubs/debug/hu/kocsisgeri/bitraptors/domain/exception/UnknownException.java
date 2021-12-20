package hu.kocsisgeri.bitraptors.domain.exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lhu/kocsisgeri/bitraptors/domain/exception/UnknownException;", "Lhu/kocsisgeri/bitraptors/domain/exception/NetworkException;", "cause", "", "errorCode", "", "(Ljava/lang/Throwable;I)V", "getCause", "()Ljava/lang/Throwable;", "app_debug"})
public final class UnknownException extends hu.kocsisgeri.bitraptors.domain.exception.NetworkException {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Throwable cause = null;
    
    public UnknownException(@org.jetbrains.annotations.Nullable()
    java.lang.Throwable cause, int errorCode) {
        super(null, null, 0);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Throwable getCause() {
        return null;
    }
}