package hu.kocsisgeri.bitraptors.domain.interceptor

import android.content.Context
import hu.kocsisgeri.bitraptors.domain.exception.NoInternetException
import hu.kocsisgeri.bitraptors.domain.hasInternetConnection
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class NetworkConnectionInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!hasInternetConnection(context)) throw NoInternetException
        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}