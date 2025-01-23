package org.akstudios.kmpsample.di

import kotlinx.serialization.json.Json
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.akstudios.kmpsample.data.remote.KtorService
import org.akstudios.kmpsample.data.repository.UserRepositoryImpl
import org.akstudios.kmpsample.domain.repository.UserRepository
import org.akstudios.kmpsample.domain.usecase.GetUserListUseCase
import org.akstudios.kmpsample.presentation.UserListViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) =

    startKoin {
        appDeclaration()
        modules(
            repositoryModule,
            useCaseModule,
            viewModelModule,
            ktorModule,
        )
    }

val viewModelModule = module {
    factory { UserListViewModel(get()) }
}

val useCaseModule = module {
    factory { GetUserListUseCase(get()) }
}

val repositoryModule = module {
    single { KtorService(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}

val ktorModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }
        }
    }

}

