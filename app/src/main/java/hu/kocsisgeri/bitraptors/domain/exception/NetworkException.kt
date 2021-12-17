package hu.kocsisgeri.bitraptors.domain.exception

import java.io.IOException

open class NetworkException(
    override val cause: Throwable?,
    val response: String?,
    val errorCode: Int
) : IOException(cause)

object NoInternetException : NetworkException(null, null, 0)
class UnknownException(
    override val cause: Throwable?, errorCode: Int
) : NetworkException(cause, null, errorCode)

class ApiCommunicationFailure(val response: String) : Exception()