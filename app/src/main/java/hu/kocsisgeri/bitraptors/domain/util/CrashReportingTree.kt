package hu.kocsisgeri.bitraptors.domain.util

import android.util.Log

import timber.log.Timber

/**
 * Report crashes, warnings and error to Crashlytics.

 * Make sure not to log verbose, debug and info.
 */
class CrashReportingTree : Timber.Tree() {

    override fun isLoggable(tag: String?, priority: Int): Boolean {
        return priority >= Log.ERROR
    }

    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        val priorityCharacter = when (priority) {
            Log.ERROR -> "E"
            Log.WARN -> "W"
            Log.ASSERT -> "A"
            else -> "?"
        }

//        FirebaseCrashlytics.getInstance().log("%s/%s:".format(priorityCharacter, tag, message))

        if (throwable != null) {
//            FirebaseCrashlytics.getInstance().recordException(throwable)
        }
    }
}