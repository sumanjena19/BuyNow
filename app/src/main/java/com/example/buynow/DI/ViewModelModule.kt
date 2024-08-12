package com.example.buynow.DI

import androidx.lifecycle.ViewModel
import com.example.buynow.ViewModel.MainActivityViewModel
import com.example.buynow.ViewModel.MainActivityViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @ClassKey(MainActivityViewModel::class)
    @IntoMap
    @Binds
    abstract fun getViewModel1(mainActivityViewModel: MainActivityViewModel): ViewModel

    @ClassKey(MainActivityViewModel2::class)
    @IntoMap
    @Binds
    abstract fun getViewModel2(mainActivityViewModel2: MainActivityViewModel2): ViewModel

}