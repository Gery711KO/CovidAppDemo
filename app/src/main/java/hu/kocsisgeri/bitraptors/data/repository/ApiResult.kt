package hu.kocsisgeri.bitraptors.data.repository

sealed class ApiResult<out T : Any> {
    data class Progress(val percentage: Int) : ApiResult<Nothing>()
    data class Loading<out T : Any>(val data: T) : ApiResult<T>()
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val error: String) : ApiResult<Nothing>()
}