package di

import android.content.Context
import com.example.shopdanisms.SmsSDK
import com.example.shopdanisms.android.GreetPresenter
import com.example.shopdanisms.android.ui.viewmodel.MainActivityViewModel
import com.example.shopdanisms.cache.DatabaseDriverFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun androidModule(context: Context) = module {
    singleOf(::GreetPresenter)
    single { SmsSDK(DatabaseDriverFactory(context)) }
    viewModel { MainActivityViewModel(get()) }
}