package di

import com.example.shopdanisms.android.GreetPresenter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    singleOf(::GreetPresenter)
}