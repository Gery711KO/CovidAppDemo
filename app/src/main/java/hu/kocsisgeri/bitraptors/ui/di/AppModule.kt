package hu.kocsisgeri.bitraptors.ui.di

import hu.kocsisgeri.bitraptors.ui.filter.FilterViewModel
import hu.kocsisgeri.bitraptors.ui.main.MainViewModel
import hu.kocsisgeri.bitraptors.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SplashViewModel() }

    viewModel { MainViewModel(repo = get()) }
    viewModel { FilterViewModel(repo = get()) }
}