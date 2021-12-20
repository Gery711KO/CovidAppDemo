package hu.kocsisgeri.bitraptors.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a7\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\f\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003\u001a7\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00102\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0007\"\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"hasInternetConnection", "", "context", "Landroid/content/Context;", "httpClient", "Lokhttp3/OkHttpClient;", "interceptors", "", "Lokhttp3/Interceptor;", "useLogging", "timeOutInSec", "", "([Lokhttp3/Interceptor;Landroid/content/Context;ZJ)Lokhttp3/OkHttpClient;", "networkType", "Lhu/kocsisgeri/bitraptors/domain/model/NetworkType;", "retrofit", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "factories", "Lretrofit2/Converter$Factory;", "baseUrl", "", "([Lretrofit2/Converter$Factory;Ljava/lang/String;Lokhttp3/OkHttpClient;)Lretrofit2/Retrofit$Builder;", "app_debug"})
public final class NetworkExtensionKt {
    
    public static final boolean hasInternetConnection(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final hu.kocsisgeri.bitraptors.domain.model.NetworkType networkType(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final okhttp3.OkHttpClient httpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor[] interceptors, @org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean useLogging, long timeOutInSec) {
        return null;
    }
    
    public static final retrofit2.Retrofit.Builder retrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Converter.Factory[] factories, @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient httpClient) {
        return null;
    }
}