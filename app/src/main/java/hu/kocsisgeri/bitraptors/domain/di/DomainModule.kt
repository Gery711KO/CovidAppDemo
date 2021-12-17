package hu.kocsisgeri.bitraptors.domain.di

import android.app.Application
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hu.kocsisgeri.bitraptors.data.dao.AppDatabase
import hu.kocsisgeri.bitraptors.data.dao.PersonDao
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

val domainModule = module {
    factory<Moshi> {
        Moshi.Builder().apply {
            add(Date::class.java, Rfc3339DateJsonAdapter())
            add(KotlinJsonAdapterFactory())
        }.build()
    }

    factory { MoshiConverterFactory.create(get<Moshi>()) }
}

val dataModule = module {
    fun provideDataBase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "mainDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: AppDatabase): PersonDao {
        return dataBase.personDao()
    }
    single { provideDataBase(application = get()) }
    single { provideDao(dataBase = get()) }
}
