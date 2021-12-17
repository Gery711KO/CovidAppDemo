package hu.kocsisgeri.bitraptors.domain

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import hu.kocsisgeri.bitraptors.domain.interceptor.NetworkConnectionInterceptor
import hu.kocsisgeri.bitraptors.domain.model.NetworkType
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

fun hasInternetConnection(context: Context?): Boolean {
    return context?.let { networkType(it) != NetworkType.Offline } ?: false
}

fun networkType(context: Context): NetworkType {
    val connectivityManager = context.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as? ConnectivityManager
    val nw = connectivityManager?.activeNetwork ?: return NetworkType.Offline
    val actNw = connectivityManager.getNetworkCapabilities(nw)
        ?: return NetworkType.Offline
    return when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkType.Wifi
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkType.Mobile
        else -> NetworkType.Offline
    }
}

fun httpClient(
    vararg interceptors: Interceptor,
    context: Context,
    useLogging: Boolean,
    timeOutInSec: Long
): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder().apply {
        if (useLogging) addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        addInterceptor(NetworkConnectionInterceptor(context))
        interceptors.forEach { addInterceptor(it) }

        connectTimeout(timeOutInSec, TimeUnit.SECONDS)
        readTimeout(timeOutInSec, TimeUnit.SECONDS)
        writeTimeout(timeOutInSec, TimeUnit.SECONDS)
    }
    return clientBuilder.build()
}

fun retrofit(
    vararg factories: Converter.Factory,
    baseUrl: String,
    httpClient: OkHttpClient
) = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(httpClient).apply {
        factories.forEach { addConverterFactory(it) }
    }
