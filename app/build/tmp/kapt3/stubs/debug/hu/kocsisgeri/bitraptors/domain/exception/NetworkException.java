package hu.kocsisgeri.bitraptors.domain.exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lhu/kocsisgeri/bitraptors/domain/exception/NetworkException;", "Ljava/io/IOException;", "cause", "", "response", "", "errorCode", "", "(Ljava/lang/Throwable;Ljava/lang/String;I)V", "getCause", "()Ljava/lang/Throwable;", "getErrorCode", "()I", "getResponse", "()Ljava/lang/String;", "app_debug"})
public class NetworkException extends java.io.IOException {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Throwable cause = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String response = null;
    private final int errorCode = 0;
    
    public NetworkException(@org.jetbrains.annotations.Nullable()
    java.lang.Throwable cause, @org.jetbrains.annotations.Nullable()
    java.lang.String response, int errorCode) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Throwable getCause() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getResponse() {
        return null;
    }
    
    public final int getErrorCode() {
        return 0;
    }
}